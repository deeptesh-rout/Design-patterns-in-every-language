open class Animal(val name: String)

open class Bird(name: String) : Animal(name) {
    open fun fly() {
        // Abstract method, to be overridden by subclasses
    }
}

class Dodo : Bird("Dodo") {
    override fun fly() {
        println("The dodo is extinct and cannot fly.")
    }
}

class Penguin : Bird("Penguin") {
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

class Eagle : Bird("Eagle") {
    override fun fly() {
        println("The eagle is soaring through the sky!")
    }
}

class Sparrow : Bird("Sparrow") {
    override fun fly() {
        println("The sparrow is fluttering its wings!")
    }
}

// Client code
fun main() {
    val bird1: Bird = Eagle()
    bird1.fly()

    val bird2: Bird = Dodo()
    bird2.fly()

    val bird3: Bird = Pigeon()
    bird3.fly()
}

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
The pigeon is fluttering its wings!
*/

class Pigeon : Bird("Pigeon") {
    fun makeCooingSound() {
        println("The pigeon is making a cooing sound.")
    }

    override fun fly() {
        println("The pigeon is fluttering its wings!")
    }
}
