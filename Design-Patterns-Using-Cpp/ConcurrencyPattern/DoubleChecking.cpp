#include <iostream>
#include <mutex>

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
    static Database* db;
    static std::mutex instanceMutex;

    Singleton() {
        db = new Database();
    }

public:
    static Singleton* getInstance() {
        if (instance == nullptr) {
            std::lock_guard<std::mutex> lock(instanceMutex);
            if (instance == nullptr) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    void addData(const std::string& data) {
        db->addData(data);
    }
};

// Initialize static members
Singleton* Singleton::instance = nullptr;
Database* Singleton::db = nullptr;
std::mutex Singleton::instanceMutex;

int main() {
    Singleton* s1 = Singleton::getInstance();
    Singleton* s2 = Singleton::getInstance();

    std::cout << s1 << std::endl;
    std::cout << s2 << std::endl;

    s2->addData("Hello, world!");

    return 0;
}

/*
Database created
0x55df73c77eb0
0x55df73c77eb0
Hello, world!
*/