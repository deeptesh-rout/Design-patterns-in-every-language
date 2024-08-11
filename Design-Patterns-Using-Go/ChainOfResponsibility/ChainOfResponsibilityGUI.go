package main

import "fmt"

// Handler interface
type Handler interface {
	showHelperText()
	setHelperText(text string)
}

// Container struct
type Container struct {
	parent   Handler
	helpText string
}

// NewContainer constructor
func NewContainer(parent Handler) *Container {
	return &Container{
		parent: parent,
	}
}

// showHelperText method for Container
func (c *Container) showHelperText() {
	if c.helpText != "" {
		fmt.Println("Help ::", c.helpText)
	} else if c.parent != nil {
		fmt.Println("Message passed to next in chain by Container")
		c.parent.showHelperText()
	}
}

// setHelperText method for Container
func (c *Container) setHelperText(text string) {
	c.helpText = text
}

// Button struct
type Button struct {
	parent   Handler
	label    string
	helpText string
}

// NewButton constructor
func NewButton(label string, parent Handler) *Button {
	return &Button{
		parent: parent,
		label:  label,
	}
}

// showHelperText method for Button
func (b *Button) showHelperText() {
	if b.helpText != "" {
		fmt.Println("Help ::", b.helpText)
	} else if b.parent != nil {
		fmt.Println("Message passed to next in chain by Button")
		b.parent.showHelperText()
	}
}

// setHelperText method for Button
func (b *Button) setHelperText(text string) {
	b.helpText = text
}

// Panel struct
type Panel struct {
	parent   Handler
	helpText string
}

// NewPanel constructor
func NewPanel(parent Handler) *Panel {
	return &Panel{
		parent: parent,
	}
}

// showHelperText method for Panel
func (p *Panel) showHelperText() {
	if p.helpText != "" {
		fmt.Println("Help ::", p.helpText)
	} else if p.parent != nil {
		fmt.Println("Message passed to next in chain by Panel")
		p.parent.showHelperText()
	}
}

// setHelperText method for Panel
func (p *Panel) setHelperText(text string) {
	p.helpText = text
}

// Client Code
func main() {
	p := NewPanel(nil)
	p.setHelperText("Panel help text.")

	b1 := NewButton("Ok", p)
	b1.setHelperText("Ok button help text.")
	b2 := NewButton("Cancel", p)

	b1.showHelperText()
	b2.showHelperText()
}

/*
Help :: Ok button help text.
Message passed to next in chain by Button
Help :: Panel help text.
*/