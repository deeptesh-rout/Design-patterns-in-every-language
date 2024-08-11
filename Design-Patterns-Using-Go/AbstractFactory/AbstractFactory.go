package main

import "fmt"

// Menu interface
type Menu interface {
    Desc()
}

// WinMenu struct
type WinMenu struct{}

func (wm WinMenu) Desc() {
    fmt.Println("Win Menu!!")
}

// MacMenu struct
type MacMenu struct{}

func (mm MacMenu) Desc() {
    fmt.Println("Mac Menu!!")
}

// Button interface
type Button interface {
    Desc()
}

// WinButton struct
type WinButton struct{}

func (wb WinButton) Desc() {
    fmt.Println("Win Button!!")
}

// MacButton struct
type MacButton struct{}

func (mb MacButton) Desc() {
    fmt.Println("Mac Button!!")
}

// AbstractFactory interface
type AbstractFactory interface {
    GetMenu() Menu
    GetButton() Button
}

// WinFactory struct
type WinFactory struct{}

func (wf WinFactory) GetMenu() Menu {
    return WinMenu{}
}

func (wf WinFactory) GetButton() Button {
    return WinButton{}
}

// MacFactory struct
type MacFactory struct{}

func (mf MacFactory) GetMenu() Menu {
    return MacMenu{}
}

func (mf MacFactory) GetButton() Button {
    return MacButton{}
}

// Client Code
func main() {
    m := MacFactory{}
    m.GetMenu().Desc()
    m.GetButton().Desc()

    w := WinFactory{}
    w.GetButton().Desc()
    w.GetMenu().Desc()
}

/*
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!!
*/