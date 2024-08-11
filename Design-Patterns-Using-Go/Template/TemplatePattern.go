package main

import "fmt"

// AbstractClass is the abstract class defining the template method.
type AbstractClass interface {
	templateMethod()
	operation1()
	operation2()
}

// ConcreteClass1 is a concrete implementation of AbstractClass.
type ConcreteClass1 struct{}

func (c *ConcreteClass1) templateMethod() {
	c.operation1()
	c.operation2()
}

func (c *ConcreteClass1) operation1() {
	fmt.Println("Concrete Class 1 : Operation 1")
}

func (c *ConcreteClass1) operation2() {
	fmt.Println("Concrete Class 1 : Operation 2")
}

// ConcreteClass2 is another concrete implementation of AbstractClass.
type ConcreteClass2 struct{}

func (c *ConcreteClass2) templateMethod() {
	c.operation1()
	c.operation2()
}

func (c *ConcreteClass2) operation1() {
	fmt.Println("Concrete Class 2 : Operation 1")
}

func (c *ConcreteClass2) operation2() {
	fmt.Println("Concrete Class 2 : Operation 2")
}

// Client code
func main() {
	concreteClass := &ConcreteClass1{}
	concreteClass.templateMethod()
}

/*
Concrete Class 1 : Operation 1
Concrete Class 1 : Operation 2
*/