package main

import (
	"database/sql"
	"fmt"
	"log"

	_ "github.com/lib/pq"
)

func processData(data string) (*sql.Rows, error) {
	// Validate input
	if data == "" {
		fmt.Println("Invalid data")
		return nil, nil
	}

	// Define connection parameters
	connStr := "user=user dbname=mydb password=password sslmode=disable"

	// Connect to the database
	db, err := sql.Open("postgres", connStr)
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	// Process data
	query := "SELECT * FROM mytable WHERE data = $1"
	rows, err := db.Query(query, data)
	if err != nil {
		log.Fatal(err)
	}

	return rows, nil
}

// Client Code
func main() {
	data := "exampleData"
	results, err := processData(data)
	if err != nil {
		log.Fatal(err)
	}
	defer results.Close()

	// Process the results if needed
}
