package main

import "fmt"

// Expression interface
type Expression interface {
	interpret(context *Context) int
}

// NumberExpression struct
type NumberExpression struct {
	number int
}

func (n *NumberExpression) interpret(context *Context) int {
	return n.number
}

// AddExpression struct
type AddExpression struct {
	left  Expression
	right Expression
}

func (a *AddExpression) interpret(context *Context) int {
	return a.left.interpret(context) + a.right.interpret(context)
}

// Context struct
type Context struct {
	variables map[string]int
}

func (c *Context) setVariable(variable string, value int) {
	if c.variables == nil {
		c.variables = make(map[string]int)
	}
	c.variables[variable] = value
}

func (c *Context) getVariable(variable string) int {
	return c.variables[variable]
}

// Client code
func main() {
	context := &Context{}
	context.setVariable("x", 10)
	context.setVariable("y", 5)

	// Create the expression tree: x + (y + 2)
	expression := &AddExpression{
		left: &NumberExpression{number: context.getVariable("x")},
		right: &AddExpression{
			left:  &NumberExpression{number: context.getVariable("y")},
			right: &NumberExpression{number: 2},
		},
	}

	result := expression.interpret(context)
	fmt.Printf("Result: %d\n", result) // Output: Result: 17
}

/*
Result: 17
*/