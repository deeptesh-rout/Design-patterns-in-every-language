package main

import (
	"fmt"
	"math/rand"
)

// Shape interface
type Shape interface {
	Draw(x1, y1, x2, y2 int)
}

// Rectangle type
type Rectangle struct {
	colour string // Intrinsic State
}

func NewRectangle(colour string) *Rectangle {
	return &Rectangle{colour: colour}
}

func (r *Rectangle) Draw(x1, y1, x2, y2 int) {
	fmt.Printf("Draw rectangle colour:%s topleft: (%d,%d) rightBottom: (%d,%d)\n", r.colour, x1, y1, x2, y2)
}

// RectangleFactory type
type RectangleFactory struct {
	shapes map[string]Shape
}

func NewRectangleFactory() *RectangleFactory {
	return &RectangleFactory{
		shapes: make(map[string]Shape),
	}
}

func (rf *RectangleFactory) GetRectangle(colour string) Shape {
	if shape, exists := rf.shapes[colour]; exists {
		return shape
	}

	shape := NewRectangle(colour)
	rf.shapes[colour] = shape
	return shape
}

func (rf *RectangleFactory) GetCount() int {
	return len(rf.shapes)
}

// Client Code
func main() {
	factory := NewRectangleFactory()
	for i := 0; i < 1000; i++ {
		colour := fmt.Sprintf("%d", rand.Intn(1000))
		rect := factory.GetRectangle(colour)
		rect.Draw(rand.Intn(100), rand.Intn(100), rand.Intn(100), rand.Intn(100))
	}
	fmt.Println(factory.GetCount())
}
