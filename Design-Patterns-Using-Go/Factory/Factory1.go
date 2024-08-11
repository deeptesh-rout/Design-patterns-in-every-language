package main

import "fmt"

// Product interface
type Product interface {
	Operation()
}

// Concrete Product classes
type ConcreteProduct1 struct{}

func (cp1 *ConcreteProduct1) Operation() {
	fmt.Println("Concrete Product1 Operation!")
}

type ConcreteProduct2 struct{}

func (cp2 *ConcreteProduct2) Operation() {
	fmt.Println("Concrete Product2 Operation!")
}

// Creator abstract class
type Factory interface {
	CreateProduct() Product
}

// Concrete Creator classes
type ConcreteFactory1 struct{}

func (cf1 *ConcreteFactory1) CreateProduct() Product {
	return &ConcreteProduct1{}
}

type ConcreteFactory2 struct{}

func (cf2 *ConcreteFactory2) CreateProduct() Product {
	return &ConcreteProduct2{}
}

// Client code
func main() {
	f1 := &ConcreteFactory1{}
	p1 := f1.CreateProduct()
	p1.Operation()

	f2 := &ConcreteFactory2{}
	p2 := f2.CreateProduct()
	p2.Operation()
}

/*
Concrete Product1 Operation!
Concrete Product2 Operation!
*/