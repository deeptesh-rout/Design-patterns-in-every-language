package main

import (
	"fmt"
)

// Element is the abstract class defining the accept method.
type Element interface {
	accept(visitor Visitor) float64
}

// Book is a concrete implementation of Element for books.
type Book struct {
	price float64
	isbn  int
}

func (b *Book) accept(visitor Visitor) float64 {
	return visitor.visitBook(b)
}

// Fruit is another concrete implementation of Element for fruits.
type Fruit struct {
	price    float64
	quantity int
	typeName string
}

func (f *Fruit) accept(visitor Visitor) float64 {
	return visitor.visitFruit(f) * float64(f.quantity)
}

// Visitor is the abstract class defining the visit methods.
type Visitor interface {
	visitBook(book *Book) float64
	visitFruit(fruit *Fruit) float64
}

// SundayDiscount is a concrete implementation of Visitor for Sunday discounts.
type SundayDiscount struct{}

func (v *SundayDiscount) visitBook(book *Book) float64 {
	return book.price - 50
}

func (v *SundayDiscount) visitFruit(fruit *Fruit) float64 {
	return fruit.price - 5
}

// SaleDiscount is another concrete implementation of Visitor for sale discounts.
type SaleDiscount struct{}

func (v *SaleDiscount) visitBook(book *Book) float64 {
	return book.price / 2
}

func (v *SaleDiscount) visitFruit(fruit *Fruit) float64 {
	return fruit.price / 2
}

// ShoppingCart is the structure holding a list of items.
type ShoppingCart struct {
	list    []Element
	visitor Visitor
}

func (os *ShoppingCart) add(o Element) {
	os.list = append(os.list, o)
}

func (os *ShoppingCart) setDiscountVisitor(discount Visitor) {
	os.visitor = discount
}

func (os *ShoppingCart) accept() {
	cost := 0.0
	for _, o := range os.list {
		cost += o.accept(os.visitor)
	}
	fmt.Printf("total cost : %.2f\n", cost)
}

func main() {
	// Client Code
	os := &ShoppingCart{}
	os.add(&Fruit{100, 10, "Apple"})
	os.add(&Book{100, 12345})

	os.setDiscountVisitor(&SundayDiscount{})
	os.accept()

	os.setDiscountVisitor(&SaleDiscount{})
	os.accept()
}

/*
total cost : 1000.00
total cost : 550.00
*/