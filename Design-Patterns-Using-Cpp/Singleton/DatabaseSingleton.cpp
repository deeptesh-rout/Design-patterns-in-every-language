#include <iostream>
#include "sqlite_modern_cpp.h"

class DatabaseSingleton {
private:
    static DatabaseSingleton* instance;
    sqlite::database db;

    DatabaseSingleton() : db("db.sqlite3") {
        std::cout << "Database created" << std::endl;
    }

public:
    static DatabaseSingleton* getInstance() {
        if (!instance) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    void createTable() {
        db << "CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);";
    }

    void addData(int id, const std::string& name) {
        db << "INSERT INTO students (id, name) VALUES (?, ?);" << id << name;
    }

    void display() {
        auto result = db << "SELECT * FROM students;";
        for (auto& row : result) {
            std::cout << row["id"] << " " << row["name"] << std::endl;
        }
    }
};

DatabaseSingleton* DatabaseSingleton::instance = nullptr;

// Client code
int main() {
    DatabaseSingleton* db1 = DatabaseSingleton::getInstance();
    DatabaseSingleton* db2 = DatabaseSingleton::getInstance();

    std::cout << "Database Objects DB1: " << db1 << std::endl;
    std::cout << "Database Objects DB2: " << db2 << std::endl;

    db1->createTable();
    db1->addData(1, "john");
    db2->addData(2, "smith");

    db1->display();

    delete db1;  // Clean up allocated instance

    return 0;
}
