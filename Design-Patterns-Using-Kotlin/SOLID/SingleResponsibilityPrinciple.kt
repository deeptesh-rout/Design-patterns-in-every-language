open class Animal(val name: String) {

    fun eat() {
        println("$name is eating.")
    }

    fun sleep() {
        println("$name is sleeping.")
    }

    open fun makeSound() {
        println("$name is making a sound.")
    }
}

class Mammal(name: String) : Animal(name) {

    fun giveBirth() {
        println("$name is giving birth to live young.")
    }
}

class Reptile(name: String) : Animal(name) {

    fun layEggs() {
        println("$name is laying eggs.")
    }
}

class Bird(name: String) : Animal(name) {

    fun fly() {
        println("$name is flying.")
    }

    override fun makeSound() {
        println("$name is making a sound.")
    }

    fun layEggs() {
        println("$name is laying eggs.")
    }
}

// Client code
fun main() {
    val animal1 = Mammal("Cat")
    animal1.giveBirth()
    animal1.makeSound()

    val animal2 = Reptile("Snake")
    animal2.layEggs()
    animal2.eat()

    val animal3 = Bird("Eagle")
    animal3.layEggs()
    animal3.fly() 
}

/*
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is laying eggs.
Eagle is flying.
*/