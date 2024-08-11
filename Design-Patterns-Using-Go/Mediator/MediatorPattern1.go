package main

import (
	"fmt"
)

// Mediator interface
type Mediator interface {
	addColleague(colleague Colleague)
	sendMessage(message string, colleagueID string)
}

// ConcreteMediator struct
type ConcreteMediator struct {
	colleagues map[string]Colleague
}

func (m *ConcreteMediator) addColleague(colleague Colleague) {
	m.colleagues[colleague.getID()] = colleague
}

func (m *ConcreteMediator) sendMessage(message string, colleagueID string) {
	fmt.Printf("Mediator pass Message: %s\n", message)
	m.colleagues[colleagueID].receive(message)
}

// Colleague interface
type Colleague interface {
	getID() string
	send(message string, to string)
	receive(message string)
}

// ConcreteColleague1 struct
type ConcreteColleague1 struct {
	mediator Mediator
	id       string
}

func (c *ConcreteColleague1) getID() string {
	return c.id
}

func (c *ConcreteColleague1) send(message string, to string) {
	fmt.Printf("%s Sent Message: %s\n", c.id, message)
	c.mediator.sendMessage(message, to)
}

func (c *ConcreteColleague1) receive(message string) {
	fmt.Printf("%s Received Message %s\n", c.id, message)
}

// ConcreteColleague2 struct
type ConcreteColleague2 struct {
	mediator Mediator
	id       string
}

func (c *ConcreteColleague2) getID() string {
	return c.id
}

func (c *ConcreteColleague2) send(message string, to string) {
	fmt.Printf("%s Sent Message: %s\n", c.id, message)
	c.mediator.sendMessage(message, to)
}

func (c *ConcreteColleague2) receive(message string) {
	fmt.Printf("%s Received Message %s\n", c.id, message)
}

// Client code
func main() {
	mediator := &ConcreteMediator{
		colleagues: make(map[string]Colleague),
	}

	first := &ConcreteColleague1{
		mediator: mediator,
		id:       "First",
	}
	mediator.addColleague(first)

	second := &ConcreteColleague2{
		mediator: mediator,
		id:       "Second",
	}
	mediator.addColleague(second)

	first.send("Hello, World!", "Second")
}

/*
First Sent Message: Hello, World!
Mediator pass Message: Hello, World!
Second Received Message Hello, World!
*/