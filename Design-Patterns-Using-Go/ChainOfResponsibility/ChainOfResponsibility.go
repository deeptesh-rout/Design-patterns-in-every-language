package main

import "fmt"

// Handler defines the interface for handling requests
type Handler interface {
	HandleRequest(request string)
	SetSuccessor(successor Handler)
}

// BaseHandler implements the basic handler structure
type BaseHandler struct {
	successor Handler
}

// SetSuccessor sets the successor handler
func (h *BaseHandler) SetSuccessor(successor Handler) {
	h.successor = successor
}

// ConcreteHandler1 handles request1
type ConcreteHandler1 struct {
	*BaseHandler
}

// HandleRequest handles the request
func (ch1 *ConcreteHandler1) HandleRequest(request string) {
	if request == "request1" {
		fmt.Println("ConcreteHandler1 handles the request1.")
	} else if ch1.successor != nil {
		ch1.successor.HandleRequest(request)
	}
}

// ConcreteHandler2 handles request2
type ConcreteHandler2 struct {
	*BaseHandler
}

// HandleRequest handles the request
func (ch2 *ConcreteHandler2) HandleRequest(request string) {
	if request == "request2" {
		fmt.Println("ConcreteHandler2 handles the request2.")
	} else if ch2.successor != nil {
		ch2.successor.HandleRequest(request)
	}
}

// ConcreteHandler3 handles request3
type ConcreteHandler3 struct {
	*BaseHandler
}

// HandleRequest handles the request
func (ch3 *ConcreteHandler3) HandleRequest(request string) {
	if request == "request3" {
		fmt.Println("ConcreteHandler3 handles the request3.")
	} else if ch3.successor != nil {
		ch3.successor.HandleRequest(request)
	}
}

func main() {
	ch1 := &ConcreteHandler1{&BaseHandler{nil}}
	ch2 := &ConcreteHandler2{&BaseHandler{ch1}}
	ch3 := &ConcreteHandler3{&BaseHandler{ch2}}

	ch3.HandleRequest("request1")
	ch3.HandleRequest("request2")
	ch3.HandleRequest("request3")
	ch3.HandleRequest("request4")
}

/*
ConcreteHandler1 handles the request1.
ConcreteHandler2 handles the request2.
ConcreteHandler3 handles the request3.
*/
