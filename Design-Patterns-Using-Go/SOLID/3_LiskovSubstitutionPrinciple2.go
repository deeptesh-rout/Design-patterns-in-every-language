package main

import "fmt"

type Bird struct {
    name         string
    flightHeight int
}

func NewBird(name string) *Bird {
    return &Bird{name: name, flightHeight: 0}
}

type Sparrow struct {
    *Bird
}

func NewSparrow(name string) *Sparrow {
    return &Sparrow{Bird: NewBird(name)}
}

func (s *Sparrow) Fly() {
    fmt.Println("The sparrow is fluttering its wings.")
    s.flightHeight = 100
}

type Penguin struct {
    *Bird
}

func NewPenguin(name string) *Penguin {
    return &Penguin{Bird: NewBird(name)}
}

func (p *Penguin) Fly() {
    fmt.Println("The penguin cannot fly.")
}

func (p *Penguin) Slide() {
    fmt.Println("The penguin is sliding on its belly!")
}

func (p *Penguin) Swim() {
    fmt.Println("The penguin is swimming in the water!")
}

type Dodo struct {
    *Bird
}

func NewDodo(name string) *Dodo {
    return &Dodo{Bird: NewBird(name)}
}

func (d *Dodo) Fly() {
    fmt.Println("The dodo is extinct and cannot fly.")
}

func Test(bird *Bird) {
    if bird.flightHeight > 0 {
        fmt.Println("Bird is flying at a positive height.")
    } else {
        fmt.Println("Error: Fly() method called; flight height is still zero.")
    }
}

// Client code
func main() {
    sparrow := NewSparrow("Sparrow")
    sparrow.Fly()
    Test(sparrow.Bird)

    penguin := NewPenguin("Penguin")
    penguin.Fly()
    Test(penguin.Bird)

    dodo := NewDodo("Dodo")
    dodo.Fly()
    Test(dodo.Bird)
}

/*
The sparrow is fluttering its wings.
Bird is flying at a positive height.
The penguin cannot fly.
Error: fly() method called; flight height is still zero.
The dodo is extinct and cannot fly.
Error: fly() method called; flight height is still zero.
*/