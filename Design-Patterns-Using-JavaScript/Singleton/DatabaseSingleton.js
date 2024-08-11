const sqlite3 = require('sqlite3').verbose();

class DatabaseSingleton {
    constructor() {
        console.log('Database created');
        this.connection = new sqlite3.Database('db.sqlite3');
        this.createTable();
    }

    static getInstance() {
        if (!this._instance) {
            this._instance = new DatabaseSingleton();
        }
        return this._instance;
    }

    createTable() {
        this.connection.run(
            'CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);'
        );
    }

    addData(id, name) {
        const statement = this.connection.prepare(
            'INSERT INTO students (id, name) VALUES (?, ?);'
        );
        statement.run(id, name);
    }

    display() {
        this.connection.each('SELECT * FROM students;', (err, row) => {
            if (err) {
                console.error(err.message);
            } else {
                console.log(`${row.id} ${row.name}`);
            }
        });
    }
}

// Client code
const db1 = DatabaseSingleton.getInstance();
const db2 = DatabaseSingleton.getInstance();

console.log('Database Objects DB1:', db1);
console.log('Database Objects DB2:', db2);

db1.addData(1, 'john');
db2.addData(2, 'smith');

db1.display();
