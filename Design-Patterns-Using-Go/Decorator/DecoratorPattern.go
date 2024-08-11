package main

import "fmt"

// Component is the interface for the base component
type Component interface {
	Operation()
}

// ConcreteComponent is the concrete implementation of Component
type ConcreteComponent struct{}

// Operation implements the Operation method for ConcreteComponent
func (c *ConcreteComponent) Operation() {
	fmt.Println("ConcreteComponent operation.")
}

// Decorator is the interface for the decorator
type Decorator interface {
	Operation()
}

// BaseDecorator provides default implementation for the Operation method
type BaseDecorator struct {
	component Component
}

// Operation implements the Operation method for BaseDecorator
func (d *BaseDecorator) Operation() {
	d.component.Operation()
}

// ConcreteDecorator1 is a concrete decorator
type ConcreteDecorator1 struct {
	BaseDecorator
}

// Operation implements the Operation method for ConcreteDecorator1
func (d *ConcreteDecorator1) Operation() {
	fmt.Println("ConcreteDecorator1 operation start.")
	d.BaseDecorator.Operation()
	fmt.Println("ConcreteDecorator1 operation end.")
}

// ConcreteDecorator2 is another concrete decorator
type ConcreteDecorator2 struct {
	BaseDecorator
}

// Operation implements the Operation method for ConcreteDecorator2
func (d *ConcreteDecorator2) Operation() {
	fmt.Println("ConcreteDecorator2 operation start.")
	d.BaseDecorator.Operation()
	fmt.Println("ConcreteDecorator2 operation end.")
}

// Client code
func main() {
	component := &ConcreteComponent{}
	decorator1 := &ConcreteDecorator1{BaseDecorator{component}}
	decorator2 := &ConcreteDecorator2{BaseDecorator{decorator1}}
	decorator2.Operation()
}

/*
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end.
*/
