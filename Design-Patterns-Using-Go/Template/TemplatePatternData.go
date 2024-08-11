package main

import "fmt"

// AddDataTemplate is the abstract class defining the template method.
type AddDataTemplate interface {
	addData()
	open()
	add()
	close()
}

// AddDataToFile is a concrete implementation of AddDataTemplate for adding data to a file.
type AddDataToFile struct{}

func (a *AddDataToFile) addData() {
	a.open()
	a.add()
	a.close()
}

func (a *AddDataToFile) open() {
	fmt.Println("Open file.")
}

func (a *AddDataToFile) add() {
	fmt.Println("Add data to file.")
}

func (a *AddDataToFile) close() {
	fmt.Println("Close file.")
}

// AddDataToDB is another concrete implementation of AddDataTemplate for adding data to a database.
type AddDataToDB struct{}

func (a *AddDataToDB) addData() {
	a.open()
	a.add()
	a.close()
}

func (a *AddDataToDB) open() {
	fmt.Println("Open Database.")
}

func (a *AddDataToDB) add() {
	fmt.Println("Add data to Database.")
}

func (a *AddDataToDB) close() {
	fmt.Println("Close Database.")
}

// Client code
func main() {
	o := &AddDataToDB{}
	o.addData()
}

/*
Open Database.
Add data to Database.
Close Database.
*/