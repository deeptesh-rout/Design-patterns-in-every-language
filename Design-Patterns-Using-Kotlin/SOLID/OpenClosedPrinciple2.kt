open class Animal(val name: String)

class Bird(name: String) : Animal(name) {
    fun fly() {
        when (name) {
            "Dodo" -> println("The dodo is extinct and cannot fly.")
            "Penguin" -> println("The penguin cannot fly.")
            "Eagle" -> println("The eagle is soaring through the sky!")
            "Sparrow" -> println("The sparrow is fluttering its wings!")
        }
    }
}

// Client code
fun main() {
    val bird1 = Bird("Eagle")
    bird1.fly()

    val bird2 = Bird("Dodo")
    bird2.fly()
}

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
*/