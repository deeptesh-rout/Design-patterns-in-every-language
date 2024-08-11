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
	concSub *RealSubject
}

func NewProxy() *Proxy {
	return &Proxy{
		concSub: &RealSubject{},
	}
}

func (p *Proxy) Request() {
	p.concSub.Request()
}

// Client code
func main() {
	proxy := NewProxy()
	proxy.Request()
}

/*
Concrete Subject Request Method
*/