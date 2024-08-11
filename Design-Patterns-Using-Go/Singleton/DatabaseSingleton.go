package main

import (
	"database/sql"
	"fmt"
	"log"
	"os"

	_ "github.com/mattn/go-sqlite3"
)

type Database struct {
	connection *sql.DB
	cursorobj  *sql.Stmt
}

var instance *Database

func NewDatabase() *Database {
	if instance == nil {
		instance = &Database{}
		fmt.Println("Database created")
		var err error
		instance.connection, err = sql.Open("sqlite3", "db.sqlite3")
		if err != nil {
			log.Fatal(err)
			os.Exit(1)
		}
	}
	return instance
}

func (db *Database) createTable() {
	_, err := db.connection.Exec("CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);")
	if err != nil {
		log.Fatal(err)
		os.Exit(1)
	}
}

func (db *Database) addData(id int, name string) {
	query := fmt.Sprintf("INSERT INTO students (id, name) VALUES (%d, '%s');", id, name)
	_, err := db.connection.Exec(query)
	if err != nil {
		log.Fatal(err)
		os.Exit(1)
	}
}

func (db *Database) display() {
	rows, err := db.connection.Query("SELECT * FROM students;")
	if err != nil {
		log.Fatal(err)
		os.Exit(1)
	}
	defer rows.Close()

	for rows.Next() {
		var id int
		var name string
		err := rows.Scan(&id, &name)
		if err != nil {
			log.Fatal(err)
			os.Exit(1)
		}
		fmt.Println(id, name)
	}
}

// Client code
func main() {
	db1 := NewDatabase()
	db2 := NewDatabase()

	fmt.Println("Database Objects DB1", db1)
	fmt.Println("Database Objects DB2", db2)

	db1.createTable()
	db1.addData(1, "john")
	db2.addData(2, "smith")

	db1.display()
}
