package main

import "fmt"

// ProductA interface
type ProductA interface {
	OperationA()
}

// ProductA1 struct
type ProductA1 struct{}

func (p ProductA1) OperationA() {
	fmt.Println("ProductA1 operationA")
}

// ProductA2 struct
type ProductA2 struct{}

func (p ProductA2) OperationA() {
	fmt.Println("ProductA2 operationA")
}

// ProductB interface
type ProductB interface {
	OperationB()
}

// ProductB1 struct
type ProductB1 struct{}

func (p ProductB1) OperationB() {
	fmt.Println("ProductB1 operationB")
}

// ProductB2 struct
type ProductB2 struct{}

func (p ProductB2) OperationB() {
	fmt.Println("ProductB2 operationB")
}

// AbstractFactory interface
type AbstractFactory interface {
	CreateProductA() ProductA
	CreateProductB() ProductB
}

// ConcreteFactory1 struct
type ConcreteFactory1 struct{}

func (f ConcreteFactory1) CreateProductA() ProductA {
	return ProductA1{}
}

func (f ConcreteFactory1) CreateProductB() ProductB {
	return ProductB1{}
}

// ConcreteFactory2 struct
type ConcreteFactory2 struct{}

func (f ConcreteFactory2) CreateProductA() ProductA {
	return ProductA2{}
}

func (f ConcreteFactory2) CreateProductB() ProductB {
	return ProductB2{}
}

// Client Code
func main() {
	factory1 := ConcreteFactory1{}
	productA1 := factory1.CreateProductA()
	productB1 := factory1.CreateProductB()
	productA1.OperationA()
	productB1.OperationB()

	factory2 := ConcreteFactory2{}
	productA2 := factory2.CreateProductA()
	productB2 := factory2.CreateProductB()
	productA2.OperationA()
	productB2.OperationB()
}

/*
ProductA1 operationA
ProductB1 operationB
ProductA2 operationA
ProductB2 operationB
*/