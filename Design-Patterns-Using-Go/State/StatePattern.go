package main

import "fmt"

type BulbControl struct {
	current BulbState
}

func NewBulbControl() *BulbControl {
	return &BulbControl{
		current: &Off{},
	}
}

func (bc *BulbControl) setState(state BulbState) {
	bc.current = state
}

func (bc *BulbControl) flip() {
	bc.current.flip(bc)
}

func (bc *BulbControl) toString() string {
	return bc.current.toString()
}

type BulbState interface {
	flip(bc *BulbControl)
	toString() string
}

type On struct{}

func (o *On) flip(bc *BulbControl) {
	bc.setState(&Off{})
}

func (o *On) toString() string {
	return "On"
}

type Off struct{}

func (off *Off) flip(bc *BulbControl) {
	bc.setState(&On{})
}

func (off *Off) toString() string {
	return "Off"
}

// Client code
func main() {
	c := NewBulbControl()
	c.flip()
	fmt.Println(c.toString())
	c.flip()
	fmt.Println(c.toString())
}

/*
On
Off
*/