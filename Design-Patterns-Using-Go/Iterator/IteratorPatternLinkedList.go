package main

import "fmt"

// Node struct representing elements of linked list
type Node struct {
	value int
	next  *Node
}

// LinkedList struct representing a linked list
type LinkedList struct {
	head *Node
	tail *Node
	size int
}

// AddTail adds a new node to the tail of the linked list
func (ll *LinkedList) AddTail(value int) {
	newNode := &Node{value: value, next: nil}
	if ll.head == nil {
		ll.head = newNode
	} else {
		ll.tail.next = newNode
	}
	ll.tail = newNode
	ll.size++
}

// AddHead adds a new node to the head of the linked list
func (ll *LinkedList) AddHead(value int) {
	newNode := &Node{value: value, next: ll.head}
	if ll.head == nil {
		ll.tail = newNode
	}
	ll.head = newNode
	ll.size++
}

// LinkedListIterator struct representing an iterator for the linked list
type LinkedListIterator struct {
	aggregate *LinkedList
	curr      *Node
}

// NewLinkedListIterator creates a new iterator for the linked list
func NewLinkedListIterator(aggregate *LinkedList) *LinkedListIterator {
	return &LinkedListIterator{
		aggregate: aggregate,
		curr:      aggregate.head,
	}
}

// Next returns the next element in the iteration
func (li *LinkedListIterator) Next() int {
	if li.curr == nil {
		return -1 // Use a sentinel value to indicate the end of the iteration
	}
	val := li.curr.value
	li.curr = li.curr.next
	return val
}

// Client code
func main() {
	aggregate := &LinkedList{}
	for i := 0; i < 5; i++ {
		aggregate.AddHead(i)
	}

	iterator := NewLinkedListIterator(aggregate)

	for val := iterator.Next(); val != -1; val = iterator.Next() {
		fmt.Print(val, " ")
	}
}
