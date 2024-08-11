package main

import "fmt"

// Shape interface
type Shape interface {
	Draw()
}

// Circle struct
type Circle struct {
	x, y, radius int
}

// NewCircle constructor
func NewCircle(x, y, r int) *Circle {
	return &Circle{x: x, y: y, radius: r}
}

// Draw method for Circle
func (c *Circle) Draw() {
	fmt.Println("Draw the Circle.")
}

// Rectangle struct
type Rectangle struct {
	x, y, length, width int
}

// NewRectangle constructor
func NewRectangle(x, y, l, w int) *Rectangle {
	return &Rectangle{x: x, y: y, length: l, width: w}
}

// OldDraw method for Rectangle
func (r *Rectangle) OldDraw() {
	fmt.Println("Drawing Rectangle.")
}

// RectangleAdapter struct
type RectangleAdapter struct {
	adaptee *Rectangle
}

// NewRectangleAdapter constructor
func NewRectangleAdapter(x, y, l, w int) *RectangleAdapter {
	return &RectangleAdapter{adaptee: NewRectangle(x, y, l, w)}
}

// Draw method for RectangleAdapter
func (ra *RectangleAdapter) Draw() {
	ra.adaptee.OldDraw()
}

// Client Code
func main() {
	adapter := NewRectangleAdapter(1, 2, 3, 4)
	adapter.Draw()
}

/* 
Drawing Rectangle.
*/