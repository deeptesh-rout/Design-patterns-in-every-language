package main

import (
	"fmt"
)

type Rectangle struct {
	height int
	width  int
}

func NewRectangle(l, w int) *Rectangle {
	return &Rectangle{height: l, width: w}
}

func (r *Rectangle) SetWidth(w int) {
	r.width = w
}

func (r *Rectangle) SetHeight(h int) {
	r.height = h
}

func (r *Rectangle) GetWidth() int {
	return r.width
}

func (r *Rectangle) GetHeight() int {
	return r.height
}

type Square struct {
	*Rectangle
}

func NewSquare(l int) *Square {
	return &Square{Rectangle: NewRectangle(l, l)}
}

func (s *Square) SetWidth(w int) {
	s.width = w
    s.height = w
}

func (s *Square) SetHeight(h int) {
	s.width = h 
    s.height = h
}

func TestRect(rect *Rectangle) {
	if 10*20 != rect.GetHeight()*rect.GetWidth() {
		fmt.Println("Test failed")
	} else {
        fmt.Println("Test success")
    }
}

// Client code
func main() {
	r := NewRectangle(10, 20)
    r.SetHeight(10)
	r.SetWidth(20)
	TestRect(r)

	s := NewSquare(10)
    s.SetHeight(10)
	s.SetWidth(20)
	TestRect(s.Rectangle)
}

/*
Test success
Test failed
*/