package main

import "fmt"

// Animal interface
type Animal interface {
	Speak()
}

// Concrete Product classes
type Dog struct{}

func (d *Dog) Speak() {
	fmt.Println("Woof!")
}

type Cat struct{}

func (c *Cat) Speak() {
	fmt.Println("Meow!")
}

// Creator abstract class
type AnimalFactory interface {
	CreateAnimal() Animal
}

// Concrete Creator classes
type DogFactory struct{}

func (df *DogFactory) CreateAnimal() Animal {
	return &Dog{}
}

type CatFactory struct{}

func (cf *CatFactory) CreateAnimal() Animal {
	return &Cat{}
}

// Client code
func main() {
	dogFactory := &DogFactory{}
	dog := dogFactory.CreateAnimal()
	dog.Speak()

	catFactory := &CatFactory{}
	cat := catFactory.CreateAnimal()
	cat.Speak()
}

/*
Woof!
Meow!
*/
