#include <iostream>
#include <sqlite3.h>

class Database {
private:
    static Database* _instance; // Keep instance reference
    sqlite3* connection;

    Database() {
        try {
            std::cout << "Database created" << std::endl;
            sqlite3_open("db.sqlite3", &connection);
        } catch (const std::exception& e) {
            std::cerr << e.what() << std::endl;
        }
    }

public:
    static Database* getInstance() {
        if (_instance == nullptr) {
            _instance = new Database();
        }
        return _instance;
    }

    void createTable() {
        try {
            sqlite3_exec(
                connection,
                "CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);",
                nullptr,
                nullptr,
                nullptr
            );
        } catch (const std::exception& e) {
            std::cerr << e.what() << std::endl;
        }
    }

    void addData(int id, const std::string& name) {
        try {
            sqlite3_stmt* statement;
            sqlite3_prepare_v2(
                connection,
                "INSERT INTO students (id, name) VALUES (?, ?);",
                -1,
                &statement,
                nullptr
            );
            sqlite3_bind_int(statement, 1, id);
            sqlite3_bind_text(statement, 2, name.c_str(), -1, SQLITE_STATIC);
            sqlite3_step(statement);
            sqlite3_finalize(statement);
        } catch (const std::exception& e) {
            std::cerr << e.what() << std::endl;
        }
    }

    void display() {
        try {
            sqlite3_stmt* statement;
            sqlite3_prepare_v2(
                connection,
                "SELECT * FROM students;",
                -1,
                &statement,
                nullptr
            );
            while (sqlite3_step(statement) == SQLITE_ROW) {
                int id = sqlite3_column_int(statement, 0);
                const char* name = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
                std::cout << "ID: " << id << ", Name: " << name << std::endl;
            }
            sqlite3_finalize(statement);
        } catch (const std::exception& e) {
            std::cerr << e.what() << std::endl;
        }
    }

    ~Database() {
        sqlite3_close(connection);
    }
};

Database* Database::_instance = nullptr;

// Client code
int main() {
    Database* db1 = Database::getInstance();
    Database* db2 = Database::getInstance();

    std::cout << "Database Objects DB1: " << db1 << std::endl;
    std::cout << "Database Objects DB2: " << db2 << std::endl;

    db1->createTable();
    db1->addData(1, "john");
    db2->addData(2, "smith");

    db1->display();

    return 0;
}
