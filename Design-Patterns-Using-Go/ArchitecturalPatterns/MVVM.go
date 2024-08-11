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

// SetData method
func (m *Model) SetData(data string) {
	fmt.Println("Model: Set data.")
	m.data = data
}

// GetData method
func (m *Model) GetData() string {
	fmt.Println("Model: Get data.")
	return m.data
}

// View struct
type View struct {
	viewModel *ViewModel
}

// NewView constructor
func NewView(viewModel *ViewModel) *View {
	return &View{
		viewModel: viewModel,
	}
}

// DisplayData method
func (v *View) DisplayData() {
	fmt.Println("Display Data:", v.viewModel.GetData())
}

// GetUserInput method
func (v *View) GetUserInput() {
	fmt.Print("View: Enter user input: ")
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	userInput := scanner.Text()
	v.viewModel.SetData(userInput)
}

// ViewModel struct
type ViewModel struct {
	model *Model
}

// NewViewModel constructor
func NewViewModel(model *Model) *ViewModel {
	return &ViewModel{
		model: model,
	}
}

// SetData method
func (vm *ViewModel) SetData(data string) {
	fmt.Println("ViewModel: Set data.")
	vm.model.SetData(data)
}

// GetData method
func (vm *ViewModel) GetData() string {
	fmt.Println("ViewModel: Get data.")
	return vm.model.GetData()
}

// Client Code
func main() {
	model := &Model{data: "Default."}
	viewModel := NewViewModel(model)
	view := NewView(viewModel)

	// Display initial data
	view.DisplayData()

	// Get user input and update data
	view.GetUserInput()

	// Display updated data
	view.DisplayData()
}

/*
ViewModel: Get data.
Model: Get data.
Display Data: Default.
View: Enter user input: Hello, World!
ViewModel: Set data.
Model: Set data.
ViewModel: Get data.
Model: Get data.
Display Data: Hello, World!
*/