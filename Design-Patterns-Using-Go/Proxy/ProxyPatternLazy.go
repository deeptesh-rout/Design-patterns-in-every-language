package main

import "fmt"

// BookParser is an interface representing a book parser.
type BookParser interface {
	NumPages() int
}

// ConcreteBookParser is a concrete implementation of the BookParser interface.
type ConcreteBookParser struct {
	book       string
	numOfPages int
}

func NewConcreteBookParser(book string) *ConcreteBookParser {
	fmt.Println("Concrete Subject Request Method")
	// Number of pages calculation heavy operation.
	// Suppose this calculation comes to 1000 pages.
	return &ConcreteBookParser{
		book:       book,
		numOfPages: 1000,
	}
}

func (cbp *ConcreteBookParser) NumPages() int {
	fmt.Println("Concrete Subject Request Method")
	return cbp.numOfPages
}

// LazyBookParserProxy is a proxy implementation of the BookParser interface.
type LazyBookParserProxy struct {
	book    string
	subject BookParser
}

func (lbp *LazyBookParserProxy) NumPages() int {
	if lbp.subject == nil {
		lbp.subject = NewConcreteBookParser(lbp.book)
	}
	return lbp.subject.NumPages()
}

// Client code
func main() {
	proxy := &LazyBookParserProxy{book: "LOTR"}
	fmt.Println(proxy.NumPages())
}

/*
Concrete Subject Request Method
Concrete Subject Request Method
1000
*/