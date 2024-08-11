#include <iostream>

// Menu interface
class Menu {
public:
    virtual void desc() = 0;
    virtual ~Menu() {} // Virtual destructor for proper cleanup
};

// WinMenu class
class WinMenu : public Menu {
public:
    void desc() override {
        std::cout << "Win Menu!!" << std::endl;
    }
};

// MacMenu class
class MacMenu : public Menu {
public:
    void desc() override {
        std::cout << "Mac Menu!!" << std::endl;
    }
};

// Button interface
class Button {
public:
    virtual void desc() = 0;
    virtual ~Button() {} // Virtual destructor for proper cleanup
};

// WinButton class
class WinButton : public Button {
public:
    void desc() override {
        std::cout << "Win Button!!" << std::endl;
    }
};

// MacButton class
class MacButton : public Button {
public:
    void desc() override {
        std::cout << "Mac Button!!" << std::endl;
    }
};

// Abstract Factory interface
class AbstractFactory {
public:
    virtual Menu* getMenu() = 0;
    virtual Button* getButton() = 0;
    virtual ~AbstractFactory() {} // Virtual destructor for proper cleanup
};

// WinFactory class
class WinFactory : public AbstractFactory {
public:
    Menu* getMenu() override {
        return new WinMenu();
    }

    Button* getButton() override {
        return new WinButton();
    }
};

// MacFactory class
class MacFactory : public AbstractFactory {
public:
    Menu* getMenu() override {
        return new MacMenu();
    }

    Button* getButton() override {
        return new MacButton();
    }
};

// Client code
int main() {
    AbstractFactory* macFactory = new MacFactory();
    macFactory->getMenu()->desc();
    macFactory->getButton()->desc();

    AbstractFactory* winFactory = new WinFactory();
    winFactory->getButton()->desc();
    winFactory->getMenu()->desc();

    // Clean up memory
    delete macFactory;
    delete winFactory;

    return 0;
}

/*
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!!
*/