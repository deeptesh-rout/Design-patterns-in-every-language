class Adder {
    var value: Int = 0
        private set

    // Overloaded method for incrementing by a specific value
    fun increment(a: Int) {
        this.value += a
    }

    // Overloaded method for incrementing by 1
    fun increment() {
        this.value += 1
    }
}

fun main() {
    val a = Adder()
    a.increment(10)
    a.increment()
    println(a.value)
}

/*
11
*/