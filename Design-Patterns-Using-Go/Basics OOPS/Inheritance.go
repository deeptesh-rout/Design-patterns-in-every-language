package main

import "fmt"

// Person struct
type Person struct {
	name   string
	age    int
	gender string
}

// NewPerson constructor
func NewPerson(name string, age int, gender string) *Person {
	return &Person{name: name, age: age, gender: gender}
}

// String method for Person
func (p *Person) String() string {
	return fmt.Sprintf("Person: %s is a %s and %d years old.", p.name, p.gender, p.age)
}

// GetGender method for Person
func (p *Person) GetGender() string {
	return p.gender
}

// Citizen struct
type Citizen struct {
	Person
	id int
}

// NewCitizen constructor
func NewCitizen(name string, age int, id int, gender string) *Citizen {
	return &Citizen{Person: Person{name: name, age: age, gender: gender}, id: id}
}

// VoterID method for Citizen
func (c *Citizen) VoterID() int {
	return c.id
}

// String method for Citizen
func (c *Citizen) String() string {
	return fmt.Sprintf("Citizen: %s is a %s and %d years old with voter id %d.", c.name, c.gender, c.age, c.id)
}

// Client Code
func main() {
	p := NewPerson("John", 32, "Male")
	fmt.Println(p)

	c := NewCitizen("Smith", 31, 1234, "Male")
	fmt.Println(c)
}

/*
Person: John is a Male and 32 years old.
Citizen: Smith is a Male and 31 years old with voter id 1234.
*/