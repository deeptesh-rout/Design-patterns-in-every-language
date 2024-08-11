package main

import (
	"fmt"
)

// Flyweight interface
type Flyweight interface {
	Operation(extrinsicState interface{})
}

// ConcreteFlyweight type
type ConcreteFlyweight struct {
	intrinsicState string
}

func (cf *ConcreteFlyweight) Operation(extrinsicState interface{}) {
	fmt.Println("Operation inside concrete flyweight")
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

func (ff *FlyweightFactory) GetFlyweight(key string) Flyweight {
	if flyweight, exists := ff.flyweights[key]; exists {
		return flyweight
	}

	flyweight := &ConcreteFlyweight{intrinsicState: key}
	ff.flyweights[key] = flyweight
	return flyweight
}

func (ff *FlyweightFactory) GetCount() int {
	return len(ff.flyweights)
}

// Client Code
func main() {
	factory := NewFlyweightFactory()
	flyweight1 := factory.GetFlyweight("key")
	flyweight2 := factory.GetFlyweight("key")

	flyweight1.Operation(nil)
	fmt.Println(flyweight1, flyweight2)
	fmt.Println("Object count:", factory.GetCount())
}

/*
Operation inside concrete flyweight
&{key} &{key}
Object count: 1
*/