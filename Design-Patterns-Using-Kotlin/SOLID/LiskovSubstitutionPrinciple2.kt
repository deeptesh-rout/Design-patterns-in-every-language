abstract class Animal(val name: String)

open class Bird(name: String) : Animal(name) {
    var flightHeight: Int = 0

    open fun fly() {
        // To be implemented in subclasses
    }
}

class Sparrow(name: String) : Bird(name) {
    override fun fly() {
        println("The sparrow is fluttering its wings.")
        flightHeight = 100
    }
}

class Penguin(name: String) : Bird(name) {
    fun slide() {
        println("The penguin is sliding on its belly!")
    }

    fun swim() {
        println("The penguin is swimming in the water!")
    }

    override fun fly() {
        println("The penguin cannot fly.")
    }
}

class Dodo(name: String) : Bird(name) {
    override fun fly() {
        println("The dodo is extinct and cannot fly.")
    }
}

fun test(bird: Bird) {
    bird.fly()
    if (bird.flightHeight > 0) {
        println("Bird is flying at a positive height.")
    } else {
        println("Error: fly() method called; flight height is still zero.")
    }
}

// Client code
fun main() {
    val sparrow = Sparrow("Sparrow")
    test(sparrow)

    val penguin = Penguin("Penguin")
    test(penguin)

    val dodo = Dodo("Dodo")
    test(dodo)
}

/*
The sparrow is fluttering its wings.
Bird is flying at a positive height.
The penguin cannot fly.
Error: fly() method called; flight height is still zero.
The dodo is extinct and cannot fly.
Error: fly() method called; flight height is still zero.
*/