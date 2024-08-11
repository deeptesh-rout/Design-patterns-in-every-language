package main

import (
	"fmt"
)

// Color struct
type Color struct {
	color string
}

// NewColor constructor
func NewColor(color string) *Color {
	return &Color{color: color}
}

// GetColor method for Color
func (c *Color) GetColor() string {
	return c.color
}

// SetColor method for Color
func (c *Color) SetColor(color string) {
	c.color = color
}

// Shape interface
type Shape interface {
	Area() float64
	Perimeter() float64
}

// Rectangle struct
type Rectangle struct {
	Color
	length  float64
	breadth float64
}

// NewRectangle constructor
func NewRectangle(length, breadth float64, color string) *Rectangle {
	return &Rectangle{Color: *NewColor(color), length: length, breadth: breadth}
}

// Area method for Rectangle
func (r *Rectangle) Area() float64 {
	return r.length * r.breadth
}

// Perimeter method for Rectangle
func (r *Rectangle) Perimeter() float64 {
	return 2 * (r.length + r.breadth)
}

// Client Code
func main() {
	r := NewRectangle(10, 20, "red")
	fmt.Printf("Area: %.2f, Perimeter: %.2f, Color: %s\n", r.Area(), r.Perimeter(), r.GetColor())

	r.SetColor("white")
	fmt.Printf("Area: %.2f, Perimeter: %.2f, Color: %s\n", r.Area(), r.Perimeter(), r.GetColor())
}

/*
Area: 200.00, Perimeter: 60.00, Color: red
Area: 200.00, Perimeter: 60.00, Color: white
*/