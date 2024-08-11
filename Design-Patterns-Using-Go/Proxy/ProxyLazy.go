package main

import "fmt"

// Subject is an interface representing a subject.
type Subject interface {
	Request()
}

// RealSubject is a concrete implementation of the Subject interface.
type RealSubject struct{}

func (rs *RealSubject) Request() {
	fmt.Println("Concrete Subject Request Method")
}

// Proxy is a proxy implementation of the Subject interface.
type Proxy struct {
	subject Subject
}

func (p *Proxy) Request() {
	if p.subject == nil {
		p.subject = &RealSubject{} // Lazy Init
	}
	p.subject.Request()
}

// Client code
func main() {
	proxy := &Proxy{}
	proxy.Request()
}

/*
Concrete Subject Request Method
*/
