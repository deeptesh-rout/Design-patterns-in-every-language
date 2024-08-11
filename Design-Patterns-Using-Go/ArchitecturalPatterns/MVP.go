package main

import (
	"fmt"
	"bufio"
	"os"
)

// Model struct
type Model struct {
	data string
}

// NewModel constructor
func NewModel() *Model {
	return &Model{
		data: "Hello",
	}
}

// SetData method
func (m *Model) SetData(data string) {
	fmt.Println("Model: Set data:", data)
	m.data = data
}

// GetData method
func (m *Model) GetData() string {
	fmt.Println("Model: Get data:", m.data)
	return m.data
}

// View struct
type View struct{}

// GetUserInput method
func (v *View) GetUserInput() string {
	fmt.Println("View: getUserInput")
	//fmt.Println("View: Enter user input: Hello, World!")
	//return "Hello, World!"
    fmt.Print("View: Enter user input: ")
    scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	userInput := scanner.Text()
	return userInput
}

// DisplayData method
func (v *View) DisplayData(data string) {
	fmt.Println("View: Display Result:", data)
}

// Presenter struct
type Presenter struct {
	model *Model
	view  *View
}

// NewPresenter constructor
func NewPresenter(model *Model, view *View) *Presenter {
	return &Presenter{
		model: model,
		view:  view,
	}
}

// OnButtonClick method
func (p *Presenter) OnButtonClick() {
	fmt.Println("Presenter: onButtonClick.")
	data := p.view.GetUserInput()
	p.model.SetData(data)
	data = p.model.GetData()
	p.view.DisplayData(data)
}

// Client Code
func main() {
	model := NewModel()
	view := &View{}
	presenter := NewPresenter(model, view)
	presenter.OnButtonClick()
}

/*
Presenter: onButtonClick.
View: getUserInput
View: Enter user input: Hello, World!
Model: Set data: Hello, World!
Model: Get data: Hello, World!
View: Display Result: Hello, World!
*/