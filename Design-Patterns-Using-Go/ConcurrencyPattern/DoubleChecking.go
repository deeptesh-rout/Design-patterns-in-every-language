package main

import (
	"fmt"
	"sync"
)

// Database represents a dummy database
type Database struct{}

// NewDatabase creates a new Database instance
func NewDatabase() *Database {
	fmt.Println("Database created")
	return &Database{}
}

// AddData adds data to the database
func (d *Database) AddData(data string) {
	fmt.Println(data)
}

// Singleton represents a singleton object
type Singleton struct {
	db *Database
}

var (
	instance *Singleton
	once     sync.Once
	mu       sync.Mutex // Mutex for synchronization
)

// GetInstance returns the singleton instance
func GetInstance() *Singleton {
	if instance == nil { // Check without acquiring lock to improve performance
		mu.Lock()
		defer mu.Unlock()
		if instance == nil {
			instance = &Singleton{db: NewDatabase()}
		}
	}
	return instance
}

// AddData adds data to the database via the singleton instance
func (s *Singleton) AddData(data string) {
	s.db.AddData(data)
}

// Client Code
func main() {
	s1 := GetInstance()
	s2 := GetInstance()

	fmt.Println(s1)
	fmt.Println(s2)

	s2.AddData("Hello, world!")
}

/*
Database created
&{0x5500b8}
&{0x5500b8}
Hello, world!
*/