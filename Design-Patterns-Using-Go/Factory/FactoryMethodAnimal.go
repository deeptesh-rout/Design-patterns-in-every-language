package main

import "fmt"

// Animal interface
type Animal interface {
	Voice()
}

// Dog type
type Dog struct{}

func (d *Dog) Voice() {
	fmt.Println("Bhow Bhow!!")
}

// Cat type
type Cat struct{}

func (c *Cat) Voice() {
	fmt.Println("Meow Meow!!")
}

// AnimalFactory interface
type AnimalFactory interface {
	GetAnimal() Animal
}

// CatFactory type
type CatFactory struct{}

func (cf *CatFactory) GetAnimal() Animal {
	return &Cat{}
}

// DogFactory type
type DogFactory struct{}

func (df *DogFactory) GetAnimal() Animal {
	return &Dog{}
}

// Cow type
type Cow struct{}

func (c *Cow) Voice() {
	fmt.Println("Gooaa Gooaa!!")
}

// CowFactory type
type CowFactory struct{}

func (cf *CowFactory) GetAnimal() Animal {
	return &Cow{}
}

// Client Code
func main() {
	// Dog
	dogFactory := &DogFactory{}
	dogFactory.GetAnimal().Voice()

	// Cat
	catFactory := &CatFactory{}
	catFactory.GetAnimal().Voice()

	// Cow
	cowFactory := &CowFactory{}
	cowFactory.GetAnimal().Voice()
}

/*
Bhow Bhow!!
Meow Meow!!
Gooaa Gooaa!!
*/
