package main

import "fmt"

// AbstractExpression interface
type AbstractExpression interface {
	interpret()
}

// NonterminalExpression struct
type NonterminalExpression struct {
	expression AbstractExpression
}

func (n *NonterminalExpression) interpret() {
	fmt.Println("NonterminalExpression:interpret")
	n.expression.interpret()
}

// TerminalExpression struct
type TerminalExpression struct{}

func (t *TerminalExpression) interpret() {
	fmt.Println("TerminalExpression:interpret")
}

// Client code
func main() {
	tree := &NonterminalExpression{
		expression: &TerminalExpression{},
	}
	tree.interpret()
}

/*
NonterminalExpression:interpret
TerminalExpression:interpret
*/