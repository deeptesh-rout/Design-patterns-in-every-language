package main

import "fmt"

// Person struct
type Person struct {
	name string
	oath string
}

// NewPerson constructor
func NewPerson(name string) *Person {
	return &Person{name: name}
}

// SetOath method for Person
func (p *Person) SetOath() {
	p.oath = "Always tell the truth"
}

// ToString method for Person
func (p *Person) ToString() string {
	return fmt.Sprintf("Person: %s:%s", p.name, p.oath)
}

// Citizen struct
type Citizen struct {
	Person
	id int
}

// NewCitizen constructor
func NewCitizen(name string, id int) *Citizen {
	return &Citizen{Person: Person{name: name}, id: id}
}

// SetOath method for Citizen
func (c *Citizen) SetOath() {
	c.oath = "Country comes first"
}

// Client Code
func main() {
	p := NewPerson("John") // p is an object of type Person
	p.SetOath()
	fmt.Println(p.ToString())

	c := NewCitizen("Smith", 31)
	c.SetOath()
	fmt.Println(c.ToString())
}

/*
Person: John:Always tell the truth
Person: Smith:Country comes first
*/