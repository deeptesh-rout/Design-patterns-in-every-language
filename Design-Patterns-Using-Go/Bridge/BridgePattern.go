package main

import "fmt"

// Implementor interface
type Implementor interface {
	Operation()
}

// Abstraction struct
type Abstraction struct {
	imp Implementor
}

// NewAbstraction constructor
func NewAbstraction(imp Implementor) *Abstraction {
	return &Abstraction{imp: imp}
}

// Operation method for Abstraction
func (a *Abstraction) Operation() {
	a.imp.Operation()
}

// ConcreteImplementor1 struct
type ConcreteImplementor1 struct{}

// Operation method for ConcreteImplementor1
func (c *ConcreteImplementor1) Operation() {
	fmt.Println("ConcreteImplementor1 operation")
}

// ConcreteImplementor2 struct
type ConcreteImplementor2 struct{}

// Operation method for ConcreteImplementor2
func (c *ConcreteImplementor2) Operation() {
	fmt.Println("ConcreteImplementor2 operation")
}

// Client Code
func main() {
	c1 := &ConcreteImplementor1{}
	abstraction := NewAbstraction(c1)
	abstraction.Operation()
}

/*
ConcreteImplementor1 operation
*/