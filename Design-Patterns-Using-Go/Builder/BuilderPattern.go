package main

import "fmt"

// Product struct
type Product struct {
	partA, partB string
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
	product *Product
}

// NewConcreteBuilder constructor
func NewConcreteBuilder() *ConcreteBuilder {
	return &ConcreteBuilder{product: &Product{partA:"AA", partB:"BB"}}
}

// setPartA method for ConcreteBuilder
func (cb *ConcreteBuilder) setPartA(A string) Builder {
	cb.product.partA = A
	return cb
}

// setPartB method for ConcreteBuilder
func (cb *ConcreteBuilder) setPartB(B string) Builder {
	cb.product.partB = B
	return cb
}

// getProduct method for ConcreteBuilder
func (cb *ConcreteBuilder) getProduct() *Product {
	temp := cb.product
	cb.product = &Product{partA:"AA", partB:"BB"} // assign new product
	return temp
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

// construct3 method for Director
func (d *Director) construct3() *Product {
	return d.builder.setPartA("A3").getProduct()
}

// Client Code
func main() {
	builder := NewConcreteBuilder()
	director := NewDirector(builder)

	product := director.construct()
	fmt.Println(product)

	product2 := director.construct2()
	fmt.Println(product2)

	product3 := director.construct3()
	fmt.Println(product3)
}

/*
Product : (A1, B1)
Product : (A2, B2)
Product : (A3, BB)
*/