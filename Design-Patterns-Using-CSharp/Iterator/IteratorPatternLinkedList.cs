using System;
using System.Collections;
using System.Collections.Generic;

public class LinkedList : IEnumerable<int> {
    // Node class representing elements of linked list.
    public class Node {
        public int Value;
        public Node Next;

        public Node(int v, Node n) {
            Value = v;
            Next = n;
        }
    }

    public Node head;
    public Node tail;
    int size;

    // Constructor of linked list.
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void AddHead(int value) {
        Node newNode = new Node(value, head);
        if (head == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public IEnumerator<int> GetEnumerator() {
        return new LinkedListIterator(this);
    }

    IEnumerator IEnumerable.GetEnumerator() {
        return GetEnumerator();
    }

    public int GetSize() {
        return size;
    }
}

public class LinkedListIterator : IEnumerator<int> {
    private LinkedList.Node current;
    private LinkedList.Node initialHead; // Store the initial head

    public LinkedListIterator(LinkedList aggregate) {
        this.current = null;
        this.initialHead = aggregate.head; // Save the initial head
    }

    public bool MoveNext() {
        if (current == null) {
            current = initialHead; // Start from the initial head
        } else {
            current = current.Next;
        }
        return current != null;
    }

    public void Reset() {
        current = null;
    }

    public int Current {
        get {
            if (current == null) {
                throw new InvalidOperationException();
            }
            return current.Value;
        }
    }

    object IEnumerator.Current => Current;

    public void Dispose() {
    }
}

// Client code

public class IteratorPatternLinkedList {
    public static void Main(string[] args) {
        LinkedList aggregate = new LinkedList();
        for (int i = 0; i < 5; i++) {
            aggregate.AddHead(i);
        }

        // Print individual elements
        foreach (int val in aggregate) {
            Console.Write(val + " ");
        }
    }
}
