package main

import (
	"fmt"
	"reflect"
)

// Shape is an interface representing a shape.
type Shape interface {
	fmt.Stringer
	Clone() Shape
}

// Rectangle is a concrete implementation of the Shape interface.
type Rectangle struct{}

func (r *Rectangle) Clone() Shape {
	// Rectangle clone
	return &Rectangle{}
}

func (r *Rectangle) String() string {
	return "Rectangle."
}

// Circle is a concrete implementation of the Shape interface.
type Circle struct{}

func (c *Circle) Clone() Shape {
	// Circle clone
	return &Circle{}
}

func (c *Circle) String() string {
	return "Circle."
}

// ShapeRegistry is a registry for managing shapes.
type ShapeRegistry struct {
	shapes map[string]Shape
}

// NewShapeRegistry creates a new instance of ShapeRegistry.
func NewShapeRegistry() *ShapeRegistry {
	return &ShapeRegistry{
		shapes: make(map[string]Shape),
	}
}

// AddShape adds a shape to the registry.
func (sr *ShapeRegistry) AddShape(key string, value Shape) {
	if _, exists := sr.shapes[key]; !exists {
		sr.shapes[key] = value
	}
}

// GetShape retrieves a shape from the registry and returns a clone.
func (sr *ShapeRegistry) GetShape(key string) Shape {
	if shape, exists := sr.shapes[key]; exists {
		// Use reflection to create a deep copy of the shape
		return reflect.New(reflect.TypeOf(shape).Elem()).Interface().(Shape)
	}
	return nil
}

// Load loads predefined shapes into the registry.
func (sr *ShapeRegistry) Load() {
	sr.AddShape("circle", &Circle{})
	sr.AddShape("rectangle", &Rectangle{})
}

// Client code
func main() {
	shapeRegistry := NewShapeRegistry()
	shapeRegistry.Load()

	circle := shapeRegistry.GetShape("circle")
	rectangle := shapeRegistry.GetShape("rectangle")

	fmt.Println(circle, rectangle)
}

/*
Circle. Rectangle.
*/