package main

import (
	"fmt"
)

// ICoffee is the interface for coffee
type ICoffee interface {
	GetCost() int
	GetIngredients() string
}

// SimpleCoffee is a simple concrete implementation of ICoffee
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
	ICoffee
}

// BaseCoffeeDecorator provides default implementation for the CoffeeDecorator interface
type BaseCoffeeDecorator struct {
	component ICoffee
	name      string
	cost      int
}

// GetCost implements the GetCost method for BaseCoffeeDecorator
func (d *BaseCoffeeDecorator) GetCost() int {
	return d.component.GetCost() + d.cost
}

// GetIngredients implements the GetIngredients method for BaseCoffeeDecorator
func (d *BaseCoffeeDecorator) GetIngredients() string {
	return d.component.GetIngredients() + ", " + d.name
}

// MilkDecorator is a concrete decorator for adding milk to coffee
type MilkDecorator struct {
	BaseCoffeeDecorator
}

// EspressoDecorator is a concrete decorator for adding espresso to coffee
type EspressoDecorator struct {
	BaseCoffeeDecorator
}

// Client Code
func main() {
	component := &SimpleCoffee{}
	decorator1 := &MilkDecorator{BaseCoffeeDecorator: BaseCoffeeDecorator{component, "Milk", 4}}
	decorator2 := &EspressoDecorator{BaseCoffeeDecorator: BaseCoffeeDecorator{decorator1, "Espresso", 5}}

	fmt.Printf("Coffee cost is :: %d\n", decorator2.GetCost())
	fmt.Printf("Coffee ingredients are :: %s\n", decorator2.GetIngredients())

	latte := &MilkDecorator{BaseCoffeeDecorator: BaseCoffeeDecorator{&MilkDecorator{BaseCoffeeDecorator: BaseCoffeeDecorator{&SimpleCoffee{}}}, "Milk", 4}}
	fmt.Printf("Coffee cost is :: %d\n", latte.GetCost())
	fmt.Printf("Coffee ingredients are :: %s\n", latte.GetIngredients())
}
