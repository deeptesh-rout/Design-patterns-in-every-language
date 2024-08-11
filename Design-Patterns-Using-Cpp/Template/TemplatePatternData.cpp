#include <iostream>

// AddDataTemplate class
class AddDataTemplate {
public:
    void addData() {
        open();
        add();
        close();
    }

    virtual ~AddDataTemplate() {}

private:
    virtual void open() = 0;
    virtual void add() = 0;
    virtual void close() = 0;
};

// AddDataToFile class
class AddDataToFile : public AddDataTemplate {
private:
    void open() override {
        std::cout << "Open file." << std::endl;
    }

    void add() override {
        std::cout << "Add data to file." << std::endl;
    }

    void close() override {
        std::cout << "Close file." << std::endl;
    }
};

// AddDataToDB class
class AddDataToDB : public AddDataTemplate {
private:
    void open() override {
        std::cout << "Open Database." << std::endl;
    }

    void add() override {
        std::cout << "Add data to Database." << std::endl;
    }

    void close() override {
        std::cout << "Close Database." << std::endl;
    }
};

// Client code
int main() {
    AddDataTemplate* addDataToDB = new AddDataToDB();
    addDataToDB->addData();

    delete addDataToDB; // Freeing allocated memory

    return 0;
}

/*
Open Database.
Add data to Database.
Close Database.
*/