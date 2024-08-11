class LinkedList : Iterable<Int?> {
    inner class Node(var value: Int, var next: Node?)

    var head: Node? = null
    var tail: Node? = null
    var size: Int = 0

    fun addHead(value: Int) {
        val newNode: Node = Node(value, head)
        if (head == null) {
            tail = newNode
        }
        head = newNode
        size++
    }

    override fun iterator(): Iterator<Int> {
        return LinkedListIterator(this)
    }
}

class LinkedListIterator(var aggregate: LinkedList) : Iterator<Int> {
    var current: LinkedList.Node?
    var previous: LinkedList.Node? = null

    init {
        this.current = aggregate.head
    }

    override fun hasNext(): Boolean {
        return current != null
    }

    override fun next(): Int {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val value = current!!.value
        previous = current
        current = current!!.next
        return value
    }
}

// Client Code
fun main() {
    val aggregate = LinkedList()
    for (i in 0..4) {
        aggregate.addHead(i)
    }

    for (`val` in aggregate) {
        print("$`val` ")
    }
}

/*
4 3 2 1 0 
*/