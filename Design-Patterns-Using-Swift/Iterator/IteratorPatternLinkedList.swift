class LinkedList: Sequence {
    // Node class representing elements of linked list.
    class Node {
        var value: Int
        var next: Node?

        init(_ value: Int, _ next: Node? = nil) {
            self.value = value
            self.next = next
        }
    }

    var head: Node?
    var tail: Node?
    var size: Int

    // Constructor of linked list.
    init() {
        head = nil
        tail = nil
        size = 0
    }

    func addHead(_ value: Int) {
        let newNode = Node(value, head)
        if head == nil {
            tail = newNode
        }
        head = newNode
        size += 1
    }

    func makeIterator() -> LinkedListIterator {
        return LinkedListIterator(aggregate: self)
    }

    func getSize() -> Int {
        return size
    }
}

struct LinkedListIterator: IteratorProtocol {
    var aggregate: LinkedList
    var current: LinkedList.Node?

    init(aggregate: LinkedList) {
        self.aggregate = aggregate
        self.current = aggregate.head
    }

    mutating func next() -> Int? {
        guard let current = current else {
            return nil
        }
        defer {
            self.current = current.next
        }
        return current.value
    }
}

// Client Code
var aggregate = LinkedList()
for i in 0..<5 {
    aggregate.addHead(i)
}

for val in aggregate {
    print(val, terminator: " ")
}

/*
4 3 2 1 0 
*/
