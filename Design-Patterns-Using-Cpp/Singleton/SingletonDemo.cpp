#include <iostream>

class Database {
public:
    Database() {
        std::cout << "Database created" << std::endl;
    }

    void addData(const std::string& data) {
        std::cout << data << std::endl;
    }
};

class Singleton {
private:
    static Singleton* instance;
    Database db;

    Singleton() {
        instance = this;
    }

public:
    static Singleton* getInstance() {
        if (instance == nullptr) {
            instance = new Singleton();
        }
        return instance;
    }

    void addData(const std::string& data) {
        db.addData(data);
    }
};

Singleton* Singleton::instance = nullptr;

// Client code
int main() {
    Singleton* s1 = Singleton::getInstance();
    Singleton* s2 = Singleton::getInstance();

    std::cout << s1 << std::endl;
    std::cout << s2 << std::endl;

    s2->addData("Hello, world!");

    delete s1;  // Clean up allocated instance

    return 0;
}

/*
Database created
0x55ad35ddeeb0
0x55ad35ddeeb0
Hello, world!
*/