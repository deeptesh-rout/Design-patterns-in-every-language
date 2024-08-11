package main

import (
	"fmt"
	"math/rand"
	"time"
)

// Shape interface
type Shape interface {
	Draw(x1, y1, x2, y2 int)
}

// RectangleWithIntrinsic type
type RectangleWithIntrinsic struct {
	color string // Intrinsic State
}

func NewRectangleWithIntrinsic(color string) *RectangleWithIntrinsic {
	return &RectangleWithIntrinsic{color: color}
}

func (r *RectangleWithIntrinsic) Draw(x1, y1, x2, y2 int) {
	fmt.Printf("Draw rectangle color:%s topleft: (%d,%d) rightBottom: (%d,%d)\n", r.color, x1, y1, x2, y2)
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

func (rf *RectangleFactory) GetRectangle(color string) Shape {
	if shape, exists := rf.shapes[color]; exists {
		return shape
	}

	shape := NewRectangleWithIntrinsic(color)
	rf.shapes[color] = shape
	return shape
}

// Rectangle type without flyweight
type Rectangle struct {
	color string // Intrinsic State
	x1, y1, x2, y2 int // Extrinsic State
}

func NewRectangle(color string, x1, y1, x2, y2 int) *Rectangle {
	return &Rectangle{
		color: color,
		x1: x1, y1: y1,
		x2: x2, y2: y2,
	}
}

func (r *Rectangle) Draw() {
	fmt.Printf("Draw rectangle color:%s topleft: (%d,%d) rightBottom: (%d,%d)\n", r.color, r.x1, r.y1, r.x2, r.y2)
}

// Client code
func main() {
	rand.Seed(time.Now().UnixNano())

	// Test with flyweight pattern
	factory := NewRectangleFactory()
	start := time.Now()
	for i := 0; i < 10000; i++ {
		factory.GetRectangle(fmt.Sprintf("%d", rand.Intn(10))).Draw(rand.Intn(100), rand.Intn(100), rand.Intn(100), rand.Intn(100))
	}
	fmt.Printf("Elapsed time with flyweight pattern: %v\n", time.Since(start))

	// Test without flyweight pattern
	start = time.Now()
	for i := 0; i < 10000; i++ {
		rect := NewRectangle(fmt.Sprintf("%d", rand.Intn(10)), rand.Intn(100), rand.Intn(100), rand.Intn(100), rand.Intn(100))
		rect.Draw()
	}
	fmt.Printf("Elapsed time without flyweight pattern: %v\n", time.Since(start))
}
