package main

import "fmt"

// Student struct
type Student struct {
	name string
}

// NewStudent constructor
func NewStudent(name string) *Student {
	return &Student{name: name}
}

// String method for Student
func (s *Student) String() string {
	return fmt.Sprintf("Student: %s", s.name)
}

// Class struct
type Class struct {
	className string
	students  []*Student
}

// NewClass constructor
func NewClass(className string) *Class {
	return &Class{className: className, students: []*Student{}}
}

// AddStudent method for Class
func (c *Class) AddStudent(st *Student) {
	c.students = append(c.students, st)
}

// Display method for Class
func (c *Class) Display() {
	for _, student := range c.students {
		fmt.Println(student)
	}
}

// Client Code
func main() {
	c := NewClass("SS1")
	s1 := NewStudent("John Smith")
	s2 := NewStudent("Jane Smith")
	c.AddStudent(s1)
	c.AddStudent(s2)
	c.Display()
}

/*
Student: John Smith
Student: Jane Smith
*/