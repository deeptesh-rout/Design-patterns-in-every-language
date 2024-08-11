package main

import (
	"fmt"
	"bufio"
	"os"
)

// Model struct
type Model struct {
	data      string
	observers []*View
}

// NewModel constructor
func NewModel() *Model {
	return &Model{
		observers: make([]*View, 0),
	}
}

// SetData method
func (m *Model) SetData(data string) {
	fmt.Println("Model : Set data.")
	m.data = data
	m.NotifyObservers()
}

// GetData method
func (m *Model) GetData() string {
	fmt.Println("Model : Get data.")
	return m.data
}

// AddObserver method
func (m *Model) AddObserver(observer *View) {
	m.observers = append(m.observers, observer)
}

// RemoveObserver method
func (m *Model) RemoveObserver(observer *View) {
	for i, obs := range m.observers {
		if obs == observer {
			m.observers = append(m.observers[:i], m.observers[i+1:]...)
			break
		}
	}
}

// NotifyObservers method
func (m *Model) NotifyObservers() {
	fmt.Println("Model : Notify observers.")
	for _, observer := range m.observers {
		observer.Update()
	}
}

// View struct
type View struct {
	controller *Controller
	model      *Model
}

// NewView constructor
func NewView(model *Model, controller *Controller) *View {
	view := &View{
		model:      model,
		controller: controller,
	}
	model.AddObserver(view)
	return view
}

// Update method
func (v *View) Update() {
	fmt.Println("View : Update.")
	data := v.model.GetData()
	fmt.Println("Data:", data)
}

// GetUserInput method
func (v *View) GetUserInput() {
	fmt.Print("View : Enter user input: ")
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	userInput := scanner.Text()
	v.controller.HandleUserInput(userInput)
}

// Controller struct
type Controller struct {
	model *Model
}

// NewController constructor
func NewController(model *Model) *Controller {
	return &Controller{
		model: model,
	}
}

// HandleUserInput method
func (c *Controller) HandleUserInput(userInput string) {
	fmt.Println("Controller : Handle user input.")
	c.model.SetData(userInput)
}

// Client Code
func main() {
	model := NewModel()
	controller := NewController(model)
	view := NewView(model, controller)
	view.GetUserInput()
}

/*
View : Enter user input: Hello, World!
Controller : Handle user input.
Model : Set data.
Model : Notify observers.
View : Update.
Model : Get data.
Data: Hello, World!
*/