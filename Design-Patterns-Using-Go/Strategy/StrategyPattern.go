package main

import "fmt"

type Strategy interface {
	execute(data int)
}

type ConcreteStrategy1 struct{}

func (cs1 *ConcreteStrategy1) execute(data int) {
	fmt.Println("ConcreteStrategy1 execute")
}

type ConcreteStrategy2 struct{}

func (cs2 *ConcreteStrategy2) execute(data int) {
	fmt.Println("ConcreteStrategy2 execute")
}

type Context struct {
	strategy Strategy
}

func NewContext(strategy Strategy) *Context {
	return &Context{
		strategy: strategy,
	}
}

func (c *Context) setStrategy(strategy Strategy) {
	c.strategy = strategy
}

func (c *Context) execute() {
	data := 1
	c.strategy.execute(data)
}

// Client code
func main() {
	c := NewContext(&ConcreteStrategy1{})
	c.execute()
	c.setStrategy(&ConcreteStrategy2{})
	c.execute()
}

/*
ConcreteStrategy1 execute
ConcreteStrategy2 execute
*/