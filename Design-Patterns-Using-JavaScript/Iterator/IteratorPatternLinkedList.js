class Node {
    constructor(value, next) {
        this.value = value;
        this.next = next;
    }
}

class Iterator {
    next() {}
    hasNext() {}
}

class LinkedListIterator extends Iterator {
    constructor(aggregate) {
        super();
        this.aggregate = aggregate;
        this.current = aggregate.head;
    }

    hasNext() {
        return this.current !== null;
    }

    next() {
        if (!this.hasNext()) {
            throw new Error("No such element");
        }
        const value = this.current.value;
        this.current = this.current.next;
        return value;
    }
}

class Iterable {
    iterator() {}
}

class LinkedList extends Iterable {
    constructor() {
        super();
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    addHead(value) {
        const newNode = new Node(value, this.head);
        if (!this.head) {
            this.tail = newNode;
        }
        this.head = newNode;
        this.size++;
    }

    iterator() {
        return new LinkedListIterator(this);
    }

    getSize() {
        return this.size;
    }
}

// Client code
const linkedList = new LinkedList();
linkedList.addHead(1);
linkedList.addHead(2);
linkedList.addHead(3);

const iterator = linkedList.iterator();
while (iterator.hasNext()) {
    console.log(iterator.next());
}

/*
3
2
1
*/
