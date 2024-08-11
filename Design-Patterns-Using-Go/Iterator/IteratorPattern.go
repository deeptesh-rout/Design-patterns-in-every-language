package main

import "fmt"

// Aggregate interface
type Aggregate interface {
	getIterator() Iterator
}

// ConcreteAggregate struct
type ConcreteAggregate struct {
	data []int
}

func (ca *ConcreteAggregate) addData(val int) {
	ca.data = append(ca.data, val)
}

func (ca *ConcreteAggregate) getIterator() Iterator {
	return &ConcreteIterator{aggregate: ca, index: 0}
}

// Iterator interface
type Iterator interface {
	next() int
	hasNext() bool
}

// ConcreteIterator struct
type ConcreteIterator struct {
	aggregate *ConcreteAggregate
	index     int
}

func (ci *ConcreteIterator) next() int {
	if ci.index >= len(ci.aggregate.data) {
		panic("StopIteration")
	}
	val := ci.aggregate.data[ci.index]
	ci.index++
	return val
}

func (ci *ConcreteIterator) hasNext() bool {
	return ci.index < len(ci.aggregate.data)
}

// Client code
func main() {
	aggregate := &ConcreteAggregate{}
	for i := 0; i < 5; i++ {
		aggregate.addData(i)
	}

	iterator := aggregate.getIterator()
	for iterator.hasNext() {
		fmt.Print(iterator.next(), " ")
	}

	// Output: 0 1 2 3 4
}
