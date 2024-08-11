#include <iostream>
#include <string>

class Handler {
protected:
    Handler* parent;
    std::string helpText;

public:
    Handler(Handler* parent) : parent(parent), helpText("") {}

    virtual void showHelperText() = 0;

    void setHelperText(const std::string& text) {
        helpText = text;
    }
};

class Container : public Handler {
public:
    Container(Handler* parent) : Handler(parent) {}

    void showHelperText() override {
        if (!helpText.empty()) {
            std::cout << "Help :: " << helpText << std::endl;
        } else if (parent != nullptr) {
            std::cout << "Message passed to next in chain by Container" << std::endl;
            parent->showHelperText();
        }
    }
};

class Button : public Handler {
private:
    std::string label;

public:
    Button(const std::string& label, Handler* parent) : Handler(parent), label(label) {}

    void showHelperText() override {
        if (!helpText.empty()) {
            std::cout << "Help :: " << helpText << std::endl;
        } else if (parent != nullptr) {
            std::cout << "Message passed to next in chain by Button" << std::endl;
            parent->showHelperText();
        }
    }
};

class Panel : public Handler {
public:
    Panel() : Handler(nullptr) {}

    void showHelperText() override {
        if (!helpText.empty()) {
            std::cout << "Help :: " << helpText << std::endl;
        } else if (parent != nullptr) {
            std::cout << "Message passed to next in chain by Panel" << std::endl;
            parent->showHelperText();
        }
    }
};

// Client code
int main() {
    Panel p;
    p.setHelperText("Panel help text.");

    Button b1("Ok", &p);
    b1.setHelperText("Ok button help text.");

    Button b2("Cancel", &p);

    b1.showHelperText();
    b2.showHelperText();

    return 0;
}

/*
Help :: Ok button help text.
Message passed to next in chain by Button
Help :: Panel help text.
*/