import kotlin.collections.Iterator

class ConcreteAggregate : Iterable<Int> {
    private val data: MutableList<Int> = ArrayList()

    fun addData(value: Int) {
        data.add(value)
    }

    override fun iterator(): Iterator<Int> {
        return ConcreteIterator(this)
    }

    fun getData(): List<Int> {
        return data
    }
}

class ConcreteIterator(private val aggregate: ConcreteAggregate) : Iterator<Int> {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < aggregate.getData().size
    }

    override fun next(): Int {
        if (!hasNext()) {
            throw IndexOutOfBoundsException()
        }
        val value = aggregate.getData()[index]
        index++
        return value
    }
}

// Client Code
fun main() {
    val aggregate = ConcreteAggregate()
    for (i in 0..9) {
        aggregate.addData(i)
    }

    for (value in aggregate) {
        print("$value ")
    }
}

/*
0 1 2 3 4 5 6 7 8 9 
*/