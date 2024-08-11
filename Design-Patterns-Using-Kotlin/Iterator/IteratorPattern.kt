interface Iterator {
    fun next(): Int
    fun hasNext(): Boolean
}

interface Aggregate {
    val iterator: Iterator
}

class ConcreteIterator(private val aggregate: ConcreteAggregate) : Iterator {
    private var index = 0

    override fun next(): Int {
        if (index >= aggregate.getData().size) {
            throw IndexOutOfBoundsException()
        }
        val value = aggregate.getData()[index]
        index++
        return value
    }

    override fun hasNext(): Boolean {
        return index < aggregate.getData().size
    }
}

class ConcreteAggregate : Aggregate {
    private val data: MutableList<Int> = ArrayList()

    fun addData(`val`: Int) {
        data.add(`val`)
    }

    override val iterator: Iterator = ConcreteIterator(this)

    fun getData(): List<Int> {
        return data
    }
}

// Client Code
fun main() {
    val aggregate = ConcreteAggregate()
    for (i in 0..4) {
        aggregate.addData(i)
    }

    val iterator = aggregate.iterator
    while (iterator.hasNext()) {
        print(iterator.next().toString() + " ")
    }
}


/*
0 1 2 3 4 
*/