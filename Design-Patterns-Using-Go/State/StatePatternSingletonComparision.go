package main

import (
	"fmt"
	"time"
)

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

type ConcreteState1 struct {
}

var concreteState1Instance *ConcreteState1

func NewConcreteState1() *ConcreteState1 {
	return &ConcreteState1{}
}

func (cs1 *ConcreteState1) handle(context *Context) {
	context.changeState(ConcreteState2Instance())
}

func ConcreteState1Instance() *ConcreteState1 {
	if concreteState1Instance == nil {
		concreteState1Instance = NewConcreteState1()
	}
	return concreteState1Instance
}

type ConcreteState2 struct {
}

var concreteState2Instance *ConcreteState2

func NewConcreteState2() *ConcreteState2 {
	return &ConcreteState2{}
}

func (cs2 *ConcreteState2) handle(context *Context) {
	context.changeState(ConcreteState3Instance())
}

func ConcreteState2Instance() *ConcreteState2 {
	if concreteState2Instance == nil {
		concreteState2Instance = NewConcreteState2()
	}
	return concreteState2Instance
}

type ConcreteState3 struct {
}

var concreteState3Instance *ConcreteState3

func NewConcreteState3() *ConcreteState3 {
	return &ConcreteState3{}
}

func (cs3 *ConcreteState3) handle(context *Context) {
	context.changeState(ConcreteState4Instance())
}

func ConcreteState3Instance() *ConcreteState3 {
	if concreteState3Instance == nil {
		concreteState3Instance = NewConcreteState3()
	}
	return concreteState3Instance
}

type ConcreteState4 struct {
}

var concreteState4Instance *ConcreteState4

func NewConcreteState4() *ConcreteState4 {
	return &ConcreteState4{}
}

func (cs4 *ConcreteState4) handle(context *Context) {
	context.changeState(ConcreteState1Instance())
}

func ConcreteState4Instance() *ConcreteState4 {
	if concreteState4Instance == nil {
		concreteState4Instance = NewConcreteState4()
	}
	return concreteState4Instance
}

func test(state State, count int) {
	context := NewContext(state)
	a := time.Now()
	for i := 0; i < count; i++ {
		context.request()
	}
	b := time.Now()
	delta := b.Sub(a)
	fmt.Println(delta.Seconds())
}

// Client code
func main() {
	state1 := &ConcreteState1{}
	test(state1, 10)

	// Using singleton.
	state1 = ConcreteState1Instance()
	test(state1, 10)
}
