package main

import "fmt"

// Element is the abstract class defining the accept method.
type Element interface {
	accept(visitor Visitor)
}

// ConcreteElementA is a concrete implementation of Element for element A.
type ConcreteElementA struct{}

func (e *ConcreteElementA) accept(visitor Visitor) {
	visitor.visitElementA(e)
}

// ConcreteElementB is another concrete implementation of Element for element B.
type ConcreteElementB struct{}

func (e *ConcreteElementB) accept(visitor Visitor) {
	visitor.visitElementB(e)
}

// Visitor is the abstract class defining the visit methods.
type Visitor interface {
	visitElementA(elementA *ConcreteElementA)
	visitElementB(elementB *ConcreteElementB)
}

// ConcreteVisitor1 is a concrete implementation of Visitor.
type ConcreteVisitor1 struct{}

func (v *ConcreteVisitor1) visitElementA(elementA *ConcreteElementA) {
	fmt.Println("ConcreteVisitor1 visitElementA() method called.")
}

func (v *ConcreteVisitor1) visitElementB(elementB *ConcreteElementB) {
	fmt.Println("ConcreteVisitor1 visitElementB() method called.")
}

// ConcreteVisitor2 is another concrete implementation of Visitor.
type ConcreteVisitor2 struct{}

func (v *ConcreteVisitor2) visitElementA(elementA *ConcreteElementA) {
	fmt.Println("ConcreteVisitor2 visitElementA() method called.")
}

func (v *ConcreteVisitor2) visitElementB(elementB *ConcreteElementB) {
	fmt.Println("ConcreteVisitor2 visitElementB() method called.")
}

func main() {
	// Client Code
	visitor1 := &ConcreteVisitor1{}

	elementA := &ConcreteElementA{}
	elementA.accept(visitor1)

	elementB := &ConcreteElementB{}
	elementB.accept(visitor1)
}

/*
ConcreteVisitor1 visitElementA() method called.
ConcreteVisitor1 visitElementB() method called.
*/