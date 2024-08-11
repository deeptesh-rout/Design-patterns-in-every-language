package main

import "fmt"

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

// ConcreteColleague struct
type ConcreteColleague struct {
	id       string
	mediator Mediator
}

func (c *ConcreteColleague) getID() string {
	return c.id
}

func (c *ConcreteColleague) send(message string, to string) {
	fmt.Printf("%s Sent Message: %s\n", c.id, message)
	c.mediator.sendMessage(message, to)
}

func (c *ConcreteColleague) receive(message string) {
	fmt.Printf("%s Received Message %s\n", c.id, message)
}

// Client code
func main() {
	mediator := &ConcreteMediator{
		colleagues: make(map[string]Colleague),
	}

	first := &ConcreteColleague{
		id:       "First",
		mediator: mediator,
	}
	mediator.addColleague(first)

	second := &ConcreteColleague{
		id:       "Second",
		mediator: mediator,
	}
	mediator.addColleague(second)

	first.send("Hello, World!", "Second")
	second.send("Hi, World!", "First")
}
