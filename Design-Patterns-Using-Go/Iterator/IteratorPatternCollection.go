package main

import (
	"fmt"
)

// Iterable interface
type Iterable interface {
	NewIterator() Iterator
}

// Iterator interface
type Iterator interface {
	Next() interface{}
	HasNext() bool
}

// ConcreteAggregate struct
type ConcreteAggregate struct {
	data []int
}

// NewConcreteAggregate creates a new ConcreteAggregate instance
func NewConcreteAggregate() *ConcreteAggregate {
	return &ConcreteAggregate{
		data: make([]int, 0),
	}
}

// AddData adds data to ConcreteAggregate
func (ca *ConcreteAggregate) AddData(val int) {
	ca.data = append(ca.data, val)
}

// NewIterator creates a new iterator for ConcreteAggregate
func (ca *ConcreteAggregate) NewIterator() Iterator {
	return &ConcreteIterator{
		aggregate: ca,
		index:     0,
	}
}

// ConcreteIterator struct
type ConcreteIterator struct {
	aggregate *ConcreteAggregate
	index     int
}

// Next returns the next element in the iteration
func (ci *ConcreteIterator) Next() interface{} {
	if ci.index >= len(ci.aggregate.data) {
		return nil
	}
	val := ci.aggregate.data[ci.index]
	ci.index++
	return val
}

// HasNext returns true if there are more elements in the iteration
func (ci *ConcreteIterator) HasNext() bool {
	return ci.index < len(ci.aggregate.data)
}

// Client code
func main() {
	aggregate := NewConcreteAggregate()

	for i := 0; i < 10; i++ {
		aggregate.AddData(i)
	}

	iterator := aggregate.NewIterator()

	for iterator.HasNext() {
		val := iterator.Next().(int)
		fmt.Print(val, " ")
	}
}
