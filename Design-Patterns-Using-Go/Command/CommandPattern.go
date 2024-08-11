package main

import "fmt"

// Command interface
type Command interface {
	execute()
	unexecute()
}

// Invoker struct
type Invoker struct {
	commands []Command
}

// setCommand method for Invoker
func (i *Invoker) setCommand(command Command) {
	i.commands = append(i.commands, command)
}

// executeCommands method for Invoker
func (i *Invoker) executeCommands() {
	for _, command := range i.commands {
		command.execute()
	}
}

// unexecuteCommands method for Invoker
func (i *Invoker) unexecuteCommands() {
	for _, command := range i.commands {
		command.unexecute()
	}
}

// ConcreteCommand struct
type ConcreteCommand struct {
	receiver Receiver
}

// NewConcreteCommand constructor
func NewConcreteCommand(receiver Receiver) *ConcreteCommand {
	return &ConcreteCommand{
		receiver: receiver,
	}
}

// execute method for ConcreteCommand
func (c *ConcreteCommand) execute() {
	c.receiver.action("Action 1")
}

// unexecute method for ConcreteCommand
func (c *ConcreteCommand) unexecute() {
	c.receiver.action("Action 2")
}

// Receiver struct
type Receiver struct{}

// action method for Receiver
func (r *Receiver) action(action string) {
	fmt.Println(action)
}

// Client Code
func main() {
	receiver := &Receiver{}
	concreteCommand := NewConcreteCommand(*receiver)
	invoker := &Invoker{}
	invoker.setCommand(concreteCommand)
	invoker.executeCommands()
	invoker.unexecuteCommands()
}

/*
Action 1
Action 2
*/

