package main

import "fmt"

// IShape interface
type IShape interface {
	move(x, y int)
	draw() string
}

// Rectangle struct
type Rectangle struct {
	x, y, l, b int
}

// NewRectangle constructor for Rectangle
func NewRectangle(x, y, l, b int) *Rectangle {
	return &Rectangle{x: x, y: y, l: l, b: b}
}

// move method for Rectangle
func (r *Rectangle) move(x, y int) {
	r.x += x
	r.y += y
}

// draw method for Rectangle
func (r *Rectangle) draw() string {
	fmt.Printf("Draw a Rectangle at (%d, %d).\n", r.x, r.y)
	return "<Rectangle>"
}

// Circle struct
type Circle struct {
	x, y, radius int
}

// NewCircle constructor for Circle
func NewCircle(x, y, radius int) *Circle {
	return &Circle{x: x, y: y, radius: radius}
}

// move method for Circle
func (c *Circle) move(x, y int) {
	c.x += x
	c.y += y
}

// draw method for Circle
func (c *Circle) draw() string {
	fmt.Printf("Draw a Circle of radius %d at (%d, %d) .\n", c.radius, c.x, c.y)
	return "<Circle>"
}

// CompoundShape struct
type CompoundShape struct {
	children []IShape
}

// NewCompoundShape constructor for CompoundShape
func NewCompoundShape() *CompoundShape {
	return &CompoundShape{
		children: make([]IShape, 0),
	}
}

// add method for CompoundShape
func (cs *CompoundShape) add(child IShape) {
	cs.children = append(cs.children, child)
}

// remove method for CompoundShape
func (cs *CompoundShape) remove(child IShape) {
	for i, c := range cs.children {
		if c == child {
			cs.children = append(cs.children[:i], cs.children[i+1:]...)
			break
		}
	}
}

// move method for CompoundShape
func (cs *CompoundShape) move(x, y int) {
	for _, child := range cs.children {
		child.move(x, y)
	}
}

// draw method for CompoundShape
func (cs *CompoundShape) draw() string {
	st := "Shapes("
	for _, child := range cs.children {
		st += child.draw()
	}
	st += ")"
	return st
}

// Client Code
func main() {
	all := NewCompoundShape()
	all.add(NewRectangle(1, 2, 1, 2))
	all.add(NewCircle(5, 3, 10))

	group := NewCompoundShape()
	group.add(NewRectangle(5, 7, 1, 2))
	group.add(NewCircle(2, 1, 2))

	all.add(group)
	fmt.Println(all.draw())
}

/*
Draw a Rectangle at (1, 2).
Draw a Circle of radius 10 at (5, 3) .
Draw a Rectangle at (5, 7).
Draw a Circle of radius 2 at (2, 1) .
Shapes(<Rectangle><Circle>Shapes(<Rectangle><Circle>))
*/