package main

import (
	"fmt"
	"strconv"
	"strings"
)

// Expression interface
type Expression interface {
	Interpret() int
}

// Number type
type Number struct {
	value int
}

func NewNumber(value int) *Number {
	return &Number{value: value}
}

func (n *Number) Interpret() int {
	return n.value
}

// Plus type
type Plus struct {
	left  Expression
	right Expression
}

func NewPlus(left, right Expression) *Plus {
	return &Plus{left: left, right: right}
}

func (p *Plus) Interpret() int {
	return p.left.Interpret() + p.right.Interpret()
}

// Minus type
type Minus struct {
	left  Expression
	right Expression
}

func NewMinus(left, right Expression) *Minus {
	return &Minus{left: left, right: right}
}

func (m *Minus) Interpret() int {
	return m.left.Interpret() - m.right.Interpret()
}

// Context type
type Context struct {
	variables map[string]int
}

func NewContext() *Context {
	return &Context{
		variables: make(map[string]int),
	}
}

func (c *Context) GetValue(name string) int {
	return c.variables[name]
}

func (c *Context) SetValue(name string, value int) {
	c.variables[name] = value
}

func ParseExpression(expression string, context *Context) Expression {
	if strings.Contains(expression, "+") {
		split := strings.SplitN(expression, " + ", 2)
		left := ParseExpression(split[0], context)
		right := ParseExpression(split[1], context)
		return NewPlus(left, right)
	} else if strings.Contains(expression, "-") {
		split := strings.SplitN(expression, " - ", 2)
		left := ParseExpression(split[0], context)
		right := ParseExpression(split[1], context)
		return NewMinus(left, right)
	} else if val, err := strconv.Atoi(expression); err == nil {
		return NewNumber(val)
	} else {
		return NewNumber(context.GetValue(expression))
	}
}

// Client code
func main() {
	context := NewContext()
	context.SetValue("x", 10)
	context.SetValue("y", 5)

	expression := ParseExpression("x + y + 2", context)
    result := expression.Interpret()
	fmt.Println(result)
}

/*
17
*/