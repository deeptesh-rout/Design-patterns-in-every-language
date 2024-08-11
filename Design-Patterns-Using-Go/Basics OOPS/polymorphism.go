package main

import "fmt"

// Adder struct
type Adder struct {
	sum int
}

// NewAdder constructor
func NewAdder() *Adder {
	return &Adder{sum: 0}
}

// Increment method with one parameter
func (a *Adder) IncrementByValue(value int) {
	a.sum += value
}

// Increment method without parameters
func (a *Adder) Increment() {
	a.sum++
}

// GetValue method for Adder
func (a *Adder) GetValue() int {
	return a.sum
}

func main() {
	adder := NewAdder()
	adder.IncrementByValue(10)
	adder.Increment()
	fmt.Println(adder.GetValue())
}

/*
11
*/