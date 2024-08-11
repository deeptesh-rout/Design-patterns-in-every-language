package main

import "fmt"

type Context struct {
	currentState State
}

func NewContext(state State) *Context {
	return &Context{
		currentState: state,
	}
}

func (c *Context) changeState(state State) {
	c.currentState = state
}

func (c *Context) request() {
	c.currentState.handle(c)
}

type State interface {
	handle(context *Context)
}

type ConcreteState1 struct{}

func (cs1 *ConcreteState1) handle(context *Context) {
	fmt.Println("ConcreteState1 handle")
	context.changeState(&ConcreteState2{})
}

type ConcreteState2 struct{}

func (cs2 *ConcreteState2) handle(context *Context) {
	fmt.Println("ConcreteState2 handle")
	context.changeState(&ConcreteState1{})
}

// Client code
func main() {
	state1 := &ConcreteState1{}
	context := NewContext(state1)
	context.request()
	context.request()
}

/*
ConcreteState1 handle
ConcreteState2 handle
*/