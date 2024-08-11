package main

import "fmt"

// Product struct
type Product struct {
	partA, partB string
}

// NewProduct constructor
func NewProduct(A, B string) *Product {
	return &Product{partA: A, partB: B}
}

// String method for Product
func (p *Product) String() string {
	return fmt.Sprintf("Product : (%s, %s)", p.partA, p.partB)
}

// Builder interface
type Builder interface {
	setPartA(A string) Builder
	setPartB(B string) Builder
	getProduct() *Product
}

// ConcreteBuilder struct
type ConcreteBuilder struct {
	partA, partB string
}

// setPartA method for ConcreteBuilder
func (cb *ConcreteBuilder) setPartA(A string) Builder {
	cb.partA = A
	return cb
}

// setPartB method for ConcreteBuilder
func (cb *ConcreteBuilder) setPartB(B string) Builder {
	cb.partB = B
	return cb
}

// getProduct method for ConcreteBuilder
func (cb *ConcreteBuilder) getProduct() *Product {
	return NewProduct(cb.partA, cb.partB)
}

// Director struct
type Director struct {
	builder Builder
}

// NewDirector constructor
func NewDirector(builder Builder) *Director {
	return &Director{builder: builder}
}

// construct method for Director
func (d *Director) construct() *Product {
	return d.builder.setPartA("A1").setPartB("B1").getProduct()
}

// construct2 method for Director
func (d *Director) construct2() *Product {
	d.builder.setPartA("A2").setPartB("B2")
	return d.builder.getProduct()
}

// Client Code
func main() {
	builder := &ConcreteBuilder{}
	director := NewDirector(builder)

	product := director.construct()
	fmt.Println(product)

	product2 := director.construct2()
	fmt.Println(product2)
}

/*
Product : (A1, B1)
Product : (A2, B2)
*/