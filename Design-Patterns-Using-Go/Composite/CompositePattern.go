package main

import "fmt"

// Component interface
type Component interface {
	operation()
}

// Composite struct
type Composite struct {
	children []Component
}

// NewComposite constructor for Composite
func NewComposite() *Composite {
	return &Composite{
		children: make([]Component, 0),
	}
}

// operation method for Composite
func (c *Composite) operation() {
	fmt.Println("Composite Operation")
	for _, child := range c.children {
		child.operation()
	}
}

// add method for Composite
func (c *Composite) add(component Component) {
	c.children = append(c.children, component)
}

// remove method for Composite
func (c *Composite) remove(component Component) {
	for i, child := range c.children {
		if child == component {
			c.children = append(c.children[:i], c.children[i+1:]...)
			break
		}
	}
}

// Leaf struct
type Leaf struct{}

// operation method for Leaf
func (l *Leaf) operation() {
	fmt.Println("Leaf Operation")
}

// Client Code
func main() {
	composite := NewComposite()
	composite.add(&Leaf{})
	composite2 := NewComposite()
	composite2.add(&Leaf{})
	composite.add(composite2)
	composite.operation()
}

/*
Composite Operation
Leaf Operation
Composite Operation
Leaf Operation
*/