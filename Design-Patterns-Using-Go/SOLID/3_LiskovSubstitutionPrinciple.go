package main

import "fmt"

// Animal interface
type AnimalInterface interface {
	MakeSound()
	Name() string // Method to get the name of the animal
}

// Animal struct
type Animal struct {
	name string
}

// NewAnimal constructor
func NewAnimal(name string) *Animal {
	return &Animal{name: name}
}

// Name method for Animal
func (a *Animal) Name() string {
	return a.name
}

// MakeSound method for Animal
func (a *Animal) MakeSound() {
	fmt.Println("Animal sound")
}

// Dog struct
type Dog struct {
	*Animal
}

// NewDog constructor
func NewDog(name string) *Dog {
	return &Dog{
		Animal: NewAnimal(name),
	}
}

// MakeSound method for Dog
func (d *Dog) MakeSound() {
	fmt.Println("woof woof!")
}

// Cat struct
type Cat struct {
	*Animal
}

// NewCat constructor
func NewCat(name string) *Cat {
	return &Cat{
		Animal: NewAnimal(name),
	}
}

// MakeSound method for Cat
func (c *Cat) MakeSound() {
	fmt.Println("meow!")
}





type Rectangle struct {
	height int
	width  int
}

func NewRectangle(l, w int) *Rectangle {
	return &Rectangle{height: l, width: w}
}

func (r *Rectangle) SetWidth(w int) {
	r.width = w
}

func (r *Rectangle) SetHeight(h int) {
	r.height = h
}

func (r *Rectangle) GetWidth() int {
	return r.width
}

func (r *Rectangle) GetHeight() int {
	return r.height
}

type Square struct {
	*Rectangle
}

func NewSquare(l int) *Square {
	return &Square{Rectangle: NewRectangle(l, l)}
}

func (s *Square) SetWidth(w int) {
	s.width = w
	s.height = w
}

func (s *Square) SetHeight(h int) {
	s.width = h
	s.height = h
}

func TestRect(rect *Rectangle) {
	if 10*20 == rect.GetHeight()*rect.GetWidth() {
		fmt.Println("Pass")
	} else {
		fmt.Println("Failed")
	}
}

// Client code
func main() {
	dog := NewDog("Buddy")
	cat := NewCat("Kitty")

	// Polymorphic behavior
	animals := []AnimalInterface{dog, cat}
	for _, animal := range animals {
		fmt.Printf("%s says: ", animal.Name())
		animal.MakeSound()
	}

	r := NewRectangle(10, 10)
    r.SetWidth(20)
	TestRect(r)

	s := NewSquare(10)
	s.SetWidth(20)
	TestRect(s.Rectangle)
}

/*
Pass
Failed
*/