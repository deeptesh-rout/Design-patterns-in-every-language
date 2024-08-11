package main

import (
	"fmt"
	"sync"
)

type Database struct {
    data string
}

var (
	instance *Database
	once     sync.Once
)

func GetInstance() *Database {
	once.Do(func() {
		instance = &Database{}
		fmt.Println("Database created")
	})
	return instance
}

func (db *Database) AddData(dt string) {
    db.data = dt
	fmt.Println("Data added:", db.data)
}

// Client code
func main() {
	s1 := GetInstance()
	s2 := GetInstance()

	s2.AddData("Hello, world!")
    fmt.Println(s1)
	fmt.Println(s2)
}

/*
Database created
Data added: Hello, world!
&{Hello, world!}
&{Hello, world!}
*/