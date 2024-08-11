package main

import "fmt"

// Subsystem1 represents the first subsystem
type Subsystem1 struct{}

// Operation1 implements the first operation of Subsystem1
func (s *Subsystem1) Operation1() {
	fmt.Println("Subsystem1 operation1")
}

// Operation2 implements the second operation of Subsystem1
func (s *Subsystem1) Operation2() {
	fmt.Println("Subsystem1 operation2")
}

// Subsystem2 represents the second subsystem
type Subsystem2 struct{}

// Operation1 implements the first operation of Subsystem2
func (s *Subsystem2) Operation1() {
	fmt.Println("Subsystem2 operation1")
}

// Operation2 implements the second operation of Subsystem2
func (s *Subsystem2) Operation2() {
	fmt.Println("Subsystem2 operation2")
}

// SystemManagerFacade represents the facade for the subsystems
type SystemManagerFacade struct {
	subsystem1 *Subsystem1
	subsystem2 *Subsystem2
}

// NewSystemManagerFacade creates a new SystemManagerFacade
func NewSystemManagerFacade() *SystemManagerFacade {
	return &SystemManagerFacade{
		subsystem1: &Subsystem1{},
		subsystem2: &Subsystem2{},
	}
}

// Operation invokes operations on subsystems
func (f *SystemManagerFacade) Operation() {
	f.subsystem1.Operation1()
	f.subsystem1.Operation2()
	f.subsystem2.Operation1()
	f.subsystem2.Operation2()
}

// Client Code
func main() {
	facade := NewSystemManagerFacade()
	facade.Operation()
}

/*
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
*/