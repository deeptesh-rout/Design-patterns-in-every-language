package main

import "fmt"

// Window is the interface for windows
type Window interface {
	Draw()
}

// SimpleWindow is a simple concrete implementation of Window
type SimpleWindow struct{}

// Draw implements the Draw method for SimpleWindow
func (w *SimpleWindow) Draw() {
	fmt.Println("SimpleWindow draw.")
}

// Decorator is the interface for window decorators
type Decorator interface {
	Window
}

// BaseDecorator provides default implementation for the Decorator interface
type BaseDecorator struct {
	component Window
}

// VerticalScrollBarDecorator is a concrete decorator for adding a vertical scrollbar to a window
type VerticalScrollBarDecorator struct {
	BaseDecorator
}

// Draw implements the Draw method for VerticalScrollBarDecorator
func (d *VerticalScrollBarDecorator) Draw() {
	d.component.Draw()
	fmt.Println("VerticalScrollBarDecorator draw.")
}

// HorizontalScrollBarDecorator is a concrete decorator for adding a horizontal scrollbar to a window
type HorizontalScrollBarDecorator struct {
	BaseDecorator
}

// Draw implements the Draw method for HorizontalScrollBarDecorator
func (d *HorizontalScrollBarDecorator) Draw() {
	d.component.Draw()
	fmt.Println("HorizontalScrollBarDecorator draw.")
}

// Client Code
func main() {
	component := &SimpleWindow{}
	decorator1 := &VerticalScrollBarDecorator{BaseDecorator{component}}
	decorator2 := &HorizontalScrollBarDecorator{BaseDecorator{decorator1}}
	decorator2.Draw()
}

/*
SimpleWindow draw.
VerticalScrollBarDecorator draw.
HorizontalScrollBarDecorator draw.
*/