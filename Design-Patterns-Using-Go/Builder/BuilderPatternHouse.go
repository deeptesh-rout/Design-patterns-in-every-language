package main

import "fmt"

// House struct
type House struct {
	Wall string
	Roof string
}

// NewHouse constructor
func NewHouse(wall, roof string) *House {
	return &House{Wall: wall, Roof: roof}
}

// String method for House
func (h *House) String() string {
	return fmt.Sprintf("House of %s and %s", h.Wall, h.Roof)
}

// HouseBuilder interface
type HouseBuilder interface {
	setWall() HouseBuilder
	setRoof() HouseBuilder
	getHouse() *House
}

// ConcreteHouseBuilder struct
type ConcreteHouseBuilder struct {
	house *House
}

// setWall method for ConcreteHouseBuilder
func (chb *ConcreteHouseBuilder) setWall() HouseBuilder {
	chb.house.Wall = "Concrete Wall"
	return chb
}

// setRoof method for ConcreteHouseBuilder
func (chb *ConcreteHouseBuilder) setRoof() HouseBuilder {
	chb.house.Roof = "Concrete Roof"
	return chb
}

// getHouse method for ConcreteHouseBuilder
func (chb *ConcreteHouseBuilder) getHouse() *House {
	temp := chb.house
    chb.house = &House{}
    return temp
}

// WoodenHouseBuilder struct
type WoodenHouseBuilder struct {
	house *House
}

// setWall method for WoodenHouseBuilder
func (whb *WoodenHouseBuilder) setWall() HouseBuilder {
	whb.house.Wall = "Wooden Wall"
	return whb
}

// setRoof method for WoodenHouseBuilder
func (whb *WoodenHouseBuilder) setRoof() HouseBuilder {
	whb.house.Roof = "Wooden Roof"
	return whb
}

// getHouse method for WoodenHouseBuilder
func (whb *WoodenHouseBuilder) getHouse() *House {
	temp := whb.house
    whb.house = &House{}
    return temp
}

// HouseDirector struct
type HouseDirector struct {
	builder HouseBuilder
}

// NewHouseDirector constructor
func NewHouseDirector(builder HouseBuilder) *HouseDirector {
	return &HouseDirector{builder: builder}
}

// construct method for HouseDirector
func (hd *HouseDirector) construct() *House {
	return hd.builder.setWall().setRoof().getHouse()
}

// Client Code
func main() {
	builder := &ConcreteHouseBuilder{house: &House{}}
	director := NewHouseDirector(builder)

	house := director.construct()
	fmt.Println(house)

	// Building a wooden house using a WoodenHouseBuilder object
	builder2 := &WoodenHouseBuilder{house: &House{}}
	director2 := NewHouseDirector(builder2)

	house2 := director2.construct()
	fmt.Println(house2)
}

/*
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
*/