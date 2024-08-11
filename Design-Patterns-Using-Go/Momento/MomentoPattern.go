package main

import "fmt"

// Memento struct - wrapper around state
type Memento struct {
	state string
}

func (m *Memento) GetState() string {
	return m.state
}

// Originator struct
type Originator struct {
	state string
}

func (o *Originator) SetState(state string) {
	o.state = state
}

func (o *Originator) GetState() string {
	return o.state
}

func (o *Originator) CreateMemento() *Memento {
	return &Memento{state: o.state}
}

func (o *Originator) SetMemento(m *Memento) {
	o.state = m.GetState()
}

// CareTaker struct - manages history
type CareTaker struct {
	history []Memento
	top     int
	max     int
}

func NewCareTaker() *CareTaker {
	return &CareTaker{
		history: make([]Memento, 0),
		top:     -1,
		max:     -1,
	}
}

func (c *CareTaker) AddMemento(m *Memento) {
	c.top++
	c.max = c.top
	if c.top <= len(c.history)-1 {
		c.history[c.top] = *m
	} else {
		c.history = append(c.history, *m)
	}
}

func (c *CareTaker) GetMemento(index int) *Memento {
	return &c.history[index]
}

func (c *CareTaker) Undo() *Memento {
	fmt.Println("Undoing state.")
	if c.top <= 0 {
		c.top = 0
		return c.GetMemento(0)
	}

	c.top--
	return c.GetMemento(c.top)
}

func (c *CareTaker) Redo() *Memento {
	fmt.Println("Redoing state.")
	if c.top >= len(c.history)-1 || c.top >= c.max {
		return c.GetMemento(c.top)
	}

	c.top++
	return c.GetMemento(c.top)
}

// Client code
func main() {
	originator := &Originator{}
	careTaker := NewCareTaker()

	originator.SetState("State 1")
	careTaker.AddMemento(originator.CreateMemento())
	fmt.Println(originator.GetState())
	originator.SetState("State 2")
	careTaker.AddMemento(originator.CreateMemento())
	fmt.Println(originator.GetState())
	originator.SetState("State 3")
	careTaker.AddMemento(originator.CreateMemento())
	fmt.Println(originator.GetState())

	originator.SetMemento(careTaker.Undo())
	fmt.Println(originator.GetState())
	originator.SetMemento(careTaker.Undo())
	fmt.Println(originator.GetState())
	originator.SetMemento(careTaker.Redo())
	fmt.Println(originator.GetState())
	originator.SetMemento(careTaker.Redo())
	fmt.Println(originator.GetState())
}


/*
State 1
State 2
State 3
Undoing state.
State 2
Undoing state.
State 1
Redoing state.
State 2
Redoing state.
State 3
*/