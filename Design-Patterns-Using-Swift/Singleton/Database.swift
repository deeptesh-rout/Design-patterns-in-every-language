import SQLite

class Database {
    private static var instance: Database?

    private let connection: Connection

    private init() {
        do {
            print("Database created")
            connection = try Connection("db.sqlite3")
        } catch {
            fatalError("Error creating database: \(error)")
        }
    }

    static func getInstance() -> Database {
        if instance == nil {
            instance = Database()
        }
        return instance!
    }

    func createTable() {
        do {
            try connection.run("CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);")
        } catch {
            fatalError("Error creating table: \(error)")
        }
    }

    func addData(id: Int, name: String) {
        do {
            let insert = "INSERT INTO students (id, name) VALUES (?, ?);"
            try connection.run(insert, id, name)
        } catch {
            fatalError("Error adding data: \(error)")
        }
    }

    func display() {
        do {
            let query = "SELECT * FROM students;"
            for row in try connection.prepare(query) {
                let id = row[0] as! Int
                let name = row[1] as! String
                print("ID: \(id), Name: \(name)")
            }
        } catch {
            fatalError("Error displaying data: \(error)")
        }
    }
}

// Client Code
let db1 = Database.getInstance()
let db2 = Database.getInstance()

print("Database Objects DB1: \(db1)")
print("Database Objects DB2: \(db2)")

db1.createTable()
db1.addData(id: 1, name: "john")
db2.addData(id: 2, name: "smith")

db1.display()
