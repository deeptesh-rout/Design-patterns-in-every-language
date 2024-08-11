package main

import "fmt"

type Animal struct {
    name string
}

func (a *Animal) eat() {
    fmt.Printf("%s is eating.\n", a.name)
}

func (a *Animal) sleep() {
    fmt.Printf("%s is sleeping.\n", a.name)
}

func (a *Animal) makeSound() {
    fmt.Printf("%s is making a sound.\n", a.name)
}

type Mammal struct {
    Animal
}

func (m *Mammal) giveBirth() {
    fmt.Printf("%s is giving birth to live young.\n", m.name)
}

type Reptile struct {
    Animal
}

func (r *Reptile) layEggs() {
    fmt.Printf("%s is laying eggs.\n", r.name)
}

type Bird struct {
    Animal
}

func (b *Bird) fly() {
    fmt.Printf("%s is flying.\n", b.name)
}

func (b *Bird) layEggs() {
    fmt.Printf("%s is laying eggs.\n", b.name)
}

// Client code
func main() {
    animal1 := Mammal{Animal{"Cat"}}
    animal1.giveBirth()
    animal1.makeSound()

    animal2 := Reptile{Animal{"Snake"}}
    animal2.layEggs()
    animal2.eat()

    animal3 := Bird{Animal{"Eagle"}}
    animal3.layEggs()
    animal3.fly()
}


/*
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is flying.
Eagle is laying eggs.
*/