package main

import "fmt"

// Shape is the abstract class defining the accept method.
type Shape interface {
	accept(visitor Visitor) string
}

// Circle is a concrete implementation of Shape for circles.
type Circle struct {
	x, y, radius int
}

func (c *Circle) accept(visitor Visitor) string {
	return visitor.visitCircle(c)
}

// Rectangle is another concrete implementation of Shape for rectangles.
type Rectangle struct {
	x, y, width, height int
}

func (r *Rectangle) accept(visitor Visitor) string {
	return visitor.visitRectangle(r)
}

// Visitor is the abstract class defining the visit methods.
type Visitor interface {
	visitCircle(circle *Circle) string
	visitRectangle(rectangle *Rectangle) string
}

// XMLVisitor is a concrete implementation of Visitor for generating XML representation.
type XMLVisitor struct{}

func (v *XMLVisitor) visitCircle(circle *Circle) string {
	return fmt.Sprintf("<circle>\n  <x>%d</x>\n  <y>%d</y>\n  <radius>%d</radius>\n</circle>", circle.x, circle.y, circle.radius)
}

func (v *XMLVisitor) visitRectangle(rectangle *Rectangle) string {
	return fmt.Sprintf("<rectangle>\n  <x>%d</x>\n  <y>%d</y>\n  <width>%d</width>\n  <height>%d</height>\n</rectangle>", rectangle.x, rectangle.y, rectangle.width, rectangle.height)
}

// TextVisitor is another concrete implementation of Visitor for generating text representation.
type TextVisitor struct{}

func (v *TextVisitor) visitCircle(circle *Circle) string {
	return fmt.Sprintf("Circle ( (x : %d, y : %d), radius : %d)", circle.x, circle.y, circle.radius)
}

func (v *TextVisitor) visitRectangle(rectangle *Rectangle) string {
	return fmt.Sprintf("Rectangle ( (x : %d, y : %d), width : %d, height : %d)", rectangle.x, rectangle.y, rectangle.width, rectangle.height)
}

// ObjectsStructure is the structure holding a collection of shapes.
type ObjectsStructure struct {
	shapes  []Shape
	visitor Visitor
}

func (os *ObjectsStructure) addShapes(shape Shape) {
	os.shapes = append(os.shapes, shape)
}

func (os *ObjectsStructure) setVisitor(visitor Visitor) {
	os.visitor = visitor
}

func (os *ObjectsStructure) accept() {
	for _, shape := range os.shapes {
		fmt.Println(shape.accept(os.visitor))
	}
}

func main() {
	// Test Code
	os := &ObjectsStructure{}
	os.addShapes(&Rectangle{6, 7, 8, 9})
	os.addShapes(&Circle{6, 7, 8})

	os.setVisitor(&XMLVisitor{})
	os.accept()

	os.setVisitor(&TextVisitor{})
	os.accept()
}

/*
<rectangle>
  <x>6</x>
  <y>7</y>
  <width>8</width>
  <height>9</height>
</rectangle>
<circle>
  <x>6</x>
  <y>7</y>
  <radius>8</radius>
</circle>
Rectangle ( (x : 6, y : 7), width : 8, height : 9)
Circle ( (x : 6, y : 7), radius : 8)
*/
