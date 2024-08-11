package main

import "fmt"

// OrderPackingTemplate is the abstract class defining the template method.
type OrderPackingTemplate interface {
	packProduct()
	getProduct()
	addProductToBox()
	delivery()
}

// OnlineOrderPacking is a concrete implementation of OrderPackingTemplate for online orders.
type OnlineOrderPacking struct{}

func (o *OnlineOrderPacking) packProduct() {
	o.getProduct()
	o.addProductToBox()
	o.delivery()
}

func (o *OnlineOrderPacking) getProduct() {
	fmt.Println("Get the product from the shelf.")
}

func (o *OnlineOrderPacking) addProductToBox() {
	fmt.Println("Put the product inside the box.")
}

func (o *OnlineOrderPacking) delivery() {
	fmt.Println("Add delivery address slip and ship.")
}

// StoreOrderPacking is another concrete implementation of OrderPackingTemplate for store orders.
type StoreOrderPacking struct{}

func (s *StoreOrderPacking) packProduct() {
	s.getProduct()
	s.addProductToBox()
	s.delivery()
}

func (s *StoreOrderPacking) getProduct() {
	fmt.Println("Get the product from the shelf.")
}

func (s *StoreOrderPacking) addProductToBox() {
	fmt.Println("Put the product inside the box.")
}

func (s *StoreOrderPacking) delivery() {
	fmt.Println("Add thanks message to the box and deliver to the customer.")
}

// Client code
func main() {
	o := &OnlineOrderPacking{}
	o.packProduct()
	fmt.Println()

	s := &StoreOrderPacking{}
	s.packProduct()
}

/*
Get the product from the shelf.
Put the product inside the box.
Add delivery address slip and ship.

Get the product from the shelf.
Put the product inside the box.
Add thanks message to the box and deliver to the customer.
*/