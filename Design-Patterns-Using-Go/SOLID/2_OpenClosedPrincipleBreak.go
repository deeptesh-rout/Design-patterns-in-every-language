package main

import "fmt"

type Animal struct {
	name string
}

type Bird struct {
	Animal
}

func (b *Bird) fly() {
	switch b.name {
	case "Dodo":
		fmt.Println("The dodo is extinct and cannot fly.")
	case "Penguin":
		fmt.Println("The penguin cannot fly.")
	case "Eagle":
		fmt.Println("The eagle is soaring through the sky!")
	case "Sparrow":
		fmt.Println("The sparrow is fluttering its wings!")
	}
}

// Client code.
func main() {
	bird1 := &Bird{Animal{"Eagle"}}
	bird1.fly()

	bird2 := &Bird{Animal{"Dodo"}}
	bird2.fly()
}

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
*/