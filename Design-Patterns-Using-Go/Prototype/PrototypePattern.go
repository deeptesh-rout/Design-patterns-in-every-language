package main

import (
	"fmt"
	"reflect"
)

type Prototype interface {
	Clone() Prototype
}

type ConcretePrototype1 struct{}

func (c *ConcretePrototype1) Clone() Prototype {
	// ConcretePrototype1 clone
	return &ConcretePrototype1{}
}

func (c *ConcretePrototype1) String() string {
	return "ConcretePrototype1"
}

type ConcretePrototype2 struct{}

func (c *ConcretePrototype2) Clone() Prototype {
	// ConcretePrototype2 clone
	return &ConcretePrototype2{}
}

func (c *ConcretePrototype2) String() string {
	return "ConcretePrototype2"
}

type PrototypeRegistry struct {
	prototypes map[string]Prototype
}

func NewPrototypeRegistry() *PrototypeRegistry {
	return &PrototypeRegistry{
		prototypes: make(map[string]Prototype),
	}
}

func (pr *PrototypeRegistry) AddPrototype(key string, value Prototype) {
	if _, exists := pr.prototypes[key]; !exists {
		pr.prototypes[key] = value
	}
}

func (pr *PrototypeRegistry) GetPrototype(key string) Prototype {
	if prototype, exists := pr.prototypes[key]; exists {
		// Use reflection to create a deep copy of the prototype
		return reflect.New(reflect.TypeOf(prototype).Elem()).Interface().(Prototype)
	}
	return nil
}

func (pr *PrototypeRegistry) Load() {
	pr.AddPrototype("CP1", &ConcretePrototype1{})
	pr.AddPrototype("CP2", &ConcretePrototype2{})
}

// Client code
func main() {
	prototypeRegistry := NewPrototypeRegistry()
	prototypeRegistry.Load()

	c1 := prototypeRegistry.GetPrototype("CP1")
	c2 := prototypeRegistry.GetPrototype("CP2")

	fmt.Println(c1)
	fmt.Println(c2)
}

/*
ConcretePrototype1
ConcretePrototype2
*/