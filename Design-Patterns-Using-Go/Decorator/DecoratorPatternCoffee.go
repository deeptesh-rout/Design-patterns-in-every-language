package main

import "fmt"

// Coffee is the interface for coffee
type Coffee interface {
	GetCost() int
	GetIngredients() string
}

// SimpleCoffee is a simple concrete implementation of Coffee
type SimpleCoffee struct{}

// GetCost implements the GetCost method for SimpleCoffee
func (c *SimpleCoffee) GetCost() int {
	return 10
}

// GetIngredients implements the GetIngredients method for SimpleCoffee
func (c *SimpleCoffee) GetIngredients() string {
	return "Coffee"
}

// CoffeeDecorator is the interface for coffee decorators
type CoffeeDecorator interface {
	Coffee
}

// BaseCoffeeDecorator provides default implementation for the CoffeeDecorator interface
type BaseCoffeeDecorator struct {
	component Coffee
}

// GetCost implements the GetCost method for BaseCoffeeDecorator
func (d *BaseCoffeeDecorator) GetCost() int {
	return d.component.GetCost()
}

// GetIngredients implements the GetIngredients method for BaseCoffeeDecorator
func (d *BaseCoffeeDecorator) GetIngredients() string {
	return d.component.GetIngredients()
}

// MilkDecorator is a concrete decorator for adding milk to coffee
type MilkDecorator struct {
	BaseCoffeeDecorator
}

// GetCost implements the GetCost method for MilkDecorator
func (d *MilkDecorator) GetCost() int {
	return d.component.GetCost() + 4
}

// GetIngredients implements the GetIngredients method for MilkDecorator
func (d *MilkDecorator) GetIngredients() string {
	return d.component.GetIngredients() + ", Milk"
}

// EspressoDecorator is a concrete decorator for adding espresso to coffee
type EspressoDecorator struct {
	BaseCoffeeDecorator
}

// GetCost implements the GetCost method for EspressoDecorator
func (d *EspressoDecorator) GetCost() int {
	return d.component.GetCost() + 5
}

// GetIngredients implements the GetIngredients method for EspressoDecorator
func (d *EspressoDecorator) GetIngredients() string {
	return d.component.GetIngredients() + ", Espresso"
}

// Client Code
func main() {
	component := &SimpleCoffee{}
	decorator1 := &MilkDecorator{BaseCoffeeDecorator{component}}
	decorator2 := &EspressoDecorator{BaseCoffeeDecorator{decorator1}}

	fmt.Printf("Coffee cost is :: %d\n", decorator2.GetCost())
	fmt.Printf("Coffee ingredients are :: %s\n", decorator2.GetIngredients())

	latte := &MilkDecorator{BaseCoffeeDecorator{&MilkDecorator{BaseCoffeeDecorator{&SimpleCoffee{}}}}}
	fmt.Printf("Coffee cost is :: %d\n", latte.GetCost())
	fmt.Printf("Coffee ingredients are :: %s\n", latte.GetIngredients())
}
