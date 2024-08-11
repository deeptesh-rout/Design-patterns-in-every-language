package main

import "fmt"

// Tyre struct
type Tyre struct {
	tireType string
}

// NewTyre constructor
func NewTyre(tireType string) *Tyre {
	return &Tyre{tireType: tireType}
}

// GetType method for Tyre
func (t *Tyre) GetType() string {
	return t.tireType
}

// Car struct
type Car struct {
	model string
	tyres []*Tyre
}

// NewCar constructor
func NewCar(model string) *Car {
	c := &Car{model: model, tyres: make([]*Tyre, 4)}
	for i := 0; i < 4; i++ {
		c.tyres[i] = NewTyre("MRF")
	}
	return c
}

// Display method for Car
func (c *Car) Display() {
	fmt.Printf("Car: %s, Tyre: %s\n", c.model, c.tyres[0].GetType())
}

// Client Code
func main() {
	c := NewCar("BMW")
	c.Display()
}

/*
Car: BMW, Tyre: MRF
*/