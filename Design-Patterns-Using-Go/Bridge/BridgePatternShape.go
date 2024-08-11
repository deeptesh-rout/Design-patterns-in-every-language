package main

import "fmt"

// Color interface (Implementor)
type Color interface {
	Fill() string
}

// Shape interface (Abstraction)
type Shape interface {
	Draw()
}

// Rectangle struct
type Rectangle struct {
	color Color
}

// NewRectangle constructor
func NewRectangle(color Color) *Rectangle {
	return &Rectangle{color: color}
}

// Draw method for Rectangle
func (r *Rectangle) Draw() {
	fmt.Printf("Drawing Rectangle with color %s\n", r.color.Fill())
}

// Circle struct
type Circle struct {
	color Color
}

// NewCircle constructor
func NewCircle(color Color) *Circle {
	return &Circle{color: color}
}

// Draw method for Circle
func (c *Circle) Draw() {
	fmt.Printf("Drawing Circle with color %s\n", c.color.Fill())
}

// Red struct
type Red struct{}

// Fill method for Red
func (r *Red) Fill() string {
	return "Red"
}

// Green struct
type Green struct{}

// Fill method for Green
func (g *Green) Fill() string {
	return "Green"
}

// Blue struct
type Blue struct{}

// Fill method for Blue
func (b *Blue) Fill() string {
	return "Blue"
}

// Client Code
func main() {
	c1 := &Red{}
	circle := NewCircle(c1)
	circle.Draw() // Output: Drawing Circle with color Red

	c2 := &Green{}
	rectangle := NewRectangle(c2)
	rectangle.Draw() // Output: Drawing Rectangle with color Green
}

/*
Drawing Circle with color Red
Drawing Rectangle with color Green
*/