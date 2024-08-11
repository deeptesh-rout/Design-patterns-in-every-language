package main

import "fmt"

// A struct
type A struct{}

// NewA constructor
func NewA() *A {
	fmt.Println("A created")
	return &A{}
}

// Fun1 method for A
func (a *A) Fun1() {
	fmt.Println("fun1")
}

// B struct
type B struct{}

// NewB constructor
func NewB() *B {
	fmt.Println("B created")
	return &B{}
}

// Fun2 method for B
func (b *B) Fun2() {
	fmt.Println("fun2 start")
	a := NewA()
	a.Fun1()
	fmt.Println("fun2 end")
}

// Client Code
func main() {
	b := NewB()
	b.Fun2()
}

/*
B created
fun2 start
A created
fun1
fun2 end
*/