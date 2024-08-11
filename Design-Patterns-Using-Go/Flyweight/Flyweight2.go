package main

import "fmt"

// Flyweight interface
type Flyweight interface {
	Operation(extrinsicState string)
}

// ConcreteFlyweight type
type ConcreteFlyweight struct {
	intrinsicState string
}

func (cf *ConcreteFlyweight) Operation(extrinsicState string) {
	fmt.Println("Operation inside concrete flyweight.")
}

// FlyweightFactory type
type FlyweightFactory struct {
	flyweights map[string]Flyweight
}

func NewFlyweightFactory() *FlyweightFactory {
	return &FlyweightFactory{
		flyweights: make(map[string]Flyweight),
	}
}

func (ff *FlyweightFactory) GetFlyweight(intrinsicState string) Flyweight {
	if _, exists := ff.flyweights[intrinsicState]; !exists {
		ff.flyweights[intrinsicState] = &ConcreteFlyweight{intrinsicState: intrinsicState}
	}
	return ff.flyweights[intrinsicState]
}

// ClientClass type
type ClientClass struct {
	flyweight       Flyweight
	extrinsicState  string
}

func NewClientClass(factory *FlyweightFactory, intrinsicState, extrinsicState string) *ClientClass {
	return &ClientClass{
		flyweight:      factory.GetFlyweight(intrinsicState),
		extrinsicState: extrinsicState,
	}
}

func (cc *ClientClass) Operation() {
	fmt.Println("Operation inside context.")
	cc.flyweight.Operation(cc.extrinsicState)
}

// Client Code
func main() {
	factory := NewFlyweightFactory()
	c := NewClientClass(factory, "common", "separate1")
	c.Operation()

	c2 := NewClientClass(factory, "common", "separate2")
	c2.Operation()
}

/*
Operation inside context.
Operation inside concrete flyweight.
Operation inside context.
Operation inside concrete flyweight.
*/