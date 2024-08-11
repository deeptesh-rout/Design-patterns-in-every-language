package main

import "fmt"

// ATMHandler interface
type ATMHandler interface {
	handleRequest(amount int)
}

// ATMHandlerConcrete struct
type ATMHandlerConcrete struct {
	successor     ATMHandler
	denomination  int
}

// NewATMHandlerConcrete constructor
func NewATMHandlerConcrete(successor ATMHandler, denomination int) *ATMHandlerConcrete {
	return &ATMHandlerConcrete{
		successor:    successor,
		denomination: denomination,
	}
}

// handleRequest method for ATMHandlerConcrete
func (ahc *ATMHandlerConcrete) handleRequest(amount int) {
	q := amount / ahc.denomination
	r := amount % ahc.denomination

	if q != 0 {
		fmt.Printf("%d notes of %d\n", q, ahc.denomination)
	}

	if r != 0 && ahc.successor != nil {
		ahc.successor.handleRequest(r)
	}
}

// Client Code
func main() {
	ch := NewATMHandlerConcrete(
		NewATMHandlerConcrete(
			NewATMHandlerConcrete(
				NewATMHandlerConcrete(nil, 10),
				50,
			),
			100,
		),
		1000,
	)

	ch.handleRequest(5560)
}

/*
5 notes of 1000
5 notes of 100
1 notes of 50
1 notes of 10
*/