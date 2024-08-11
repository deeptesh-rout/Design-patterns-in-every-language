package main

import "fmt"

// DrawingAPI interface
type DrawingAPI interface {
	DrawSquare()
	DrawCircle()
}

// Shape struct
type Shape struct {
	implementation DrawingAPI
}

// NewShape constructor
func NewShape(implementation DrawingAPI) *Shape {
	return &Shape{implementation: implementation}
}

// Draw method for Shape
func (s *Shape) Draw() {
	// Common draw logic for all shapes
}

// Square struct
type Square struct {
	*Shape
}

// Draw method for Square
func (sq *Square) Draw() {
	sq.implementation.DrawSquare()
}

// Circle struct
type Circle struct {
	*Shape
}

// Draw method for Circle
func (c *Circle) Draw() {
	c.implementation.DrawCircle()
}

// WindowsAPI struct
type WindowsAPI struct{}

// DrawSquare method for WindowsAPI
func (w *WindowsAPI) DrawSquare() {
	fmt.Println("Drawing a square on Windows.")
}

// DrawCircle method for WindowsAPI
func (w *WindowsAPI) DrawCircle() {
	fmt.Println("Drawing a circle on Windows.")
}

// MacAPI struct
type MacAPI struct{}

// DrawSquare method for MacAPI
func (m *MacAPI) DrawSquare() {
	fmt.Println("Drawing a square on Mac.")
}

// DrawCircle method for MacAPI
func (m *MacAPI) DrawCircle() {
	fmt.Println("Drawing a circle on Mac.")
}

// Client Code
func main() {
	windowsAPI := &WindowsAPI{}
	macAPI := &MacAPI{}

	square := &Square{NewShape(windowsAPI)}
	square.Draw() // Output: Drawing a square on Windows.

	circle := &Circle{NewShape(macAPI)}
	circle.Draw() // Output: Drawing a circle on Mac.
}

/*
Drawing a square on Windows.
Drawing a circle on Mac.
*/