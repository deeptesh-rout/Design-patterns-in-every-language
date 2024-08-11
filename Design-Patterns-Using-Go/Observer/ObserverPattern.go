package main

import "fmt"

// Subject interface
type Subject interface {
	Attach(observer Observer)
	Detach(observer Observer)
	Notify()
}

// ConcreteSubject struct
type ConcreteSubject struct {
	state     string
	observers []Observer
}

func (s *ConcreteSubject) Attach(observer Observer) {
	observer.SetSubject(s)
	s.observers = append(s.observers, observer)
}

func (s *ConcreteSubject) Detach(observer Observer) {
	for i, obs := range s.observers {
		if obs == observer {
			observer.SetSubject(nil)
			s.observers = append(s.observers[:i], s.observers[i+1:]...)
			break
		}
	}
}

func (s *ConcreteSubject) Notify() {
	for _, observer := range s.observers {
		observer.Update()
	}
}

func (s *ConcreteSubject) GetState() string {
	return s.state
}

func (s *ConcreteSubject) SetState(state string) {
	s.state = state
	s.Notify()
}

// Observer interface
type Observer interface {
	Update()
	SetSubject(subject Subject)
}

// ConcreteObserver struct
type ConcreteObserver struct {
	subject Subject
}

func (o *ConcreteObserver) Update() {
	state := o.subject.(*ConcreteSubject).GetState()
	fmt.Printf("%s notified to Observer\n", state)
}

func (o *ConcreteObserver) SetSubject(subject Subject) {
	o.subject = subject
}

// Client code
func main() {
	subject := &ConcreteSubject{}
	observer1 := &ConcreteObserver{}
	observer2 := &ConcreteObserver{}

	subject.Attach(observer1)
	subject.Attach(observer2)

	subject.SetState("First state")
	subject.SetState("Second state")
}

/*
First state notified to Observer
First state notified to Observer
Second state notified to Observer
Second state notified to Observer
*/