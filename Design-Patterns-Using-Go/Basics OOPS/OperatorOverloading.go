package main

import (
	"fmt"
	"math"
)

// Rectangle struct
type Rectangle struct {
	length, breadth float64
}

// NewRectangle constructor
func NewRectangle(length, breadth float64) *Rectangle {
	return &Rectangle{length: length, breadth: breadth}
}

// Area method for Rectangle
func (r *Rectangle) Area() float64 {
	return r.length * r.breadth
}

// Perimeter method for Rectangle
func (r *Rectangle) Perimeter() float64 {
	return 2 * (r.length + r.breadth)
}

// Add method for Rectangle (overloading + operator)
func (r *Rectangle) Add(rec *Rectangle) *Rectangle {
	return NewRectangle(r.length+rec.length, r.breadth+rec.breadth)
}

// Subtract method for Rectangle (overloading - operator)
func (r *Rectangle) Subtract(rec *Rectangle) *Rectangle {
	return NewRectangle(math.Abs(r.length-rec.length), math.Abs(r.breadth-rec.breadth))
}

// Equals method for Rectangle (overloading == operator)
func (r *Rectangle) Equals(rec *Rectangle) bool {
	return r.length == rec.length && r.breadth == rec.breadth
}

// String method for Rectangle (overriding __str__ function)
func (r *Rectangle) String() string {
	return fmt.Sprintf("Rectangle length and breadth: %.2f %.2f", r.length, r.breadth)
}

func main() {
	r1 := NewRectangle(4, 6)
	r2 := NewRectangle(10, 6)

	fmt.Printf("Is r1 == r2 ? %t\n", r1.Equals(r2))

	r3 := r1.Add(r2)
	r4 := r1.Subtract(r2)

	fmt.Println(r1)
	fmt.Println(r2)
	fmt.Println(r3)
	fmt.Println(r4)
}

/*
Is r1 == r2 ? false
Rectangle length and breadth: 4.00 6.00
Rectangle length and breadth: 10.00 6.00
Rectangle length and breadth: 14.00 12.00
Rectangle length and breadth: 6.00 0.00
*/