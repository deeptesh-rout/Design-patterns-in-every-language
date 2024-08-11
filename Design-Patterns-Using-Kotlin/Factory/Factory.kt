// Animal interface
interface Animal {
    fun speak()
}

// Concrete Animal classes
class Dog : Animal {
    override fun speak() {
        println("Woof!")
    }
}

// Concrete Animal classes
class Cat : Animal {
    override fun speak() {
        println("Meow!")
    }
}

// AnimalFactory abstract class
abstract class AnimalFactory {
    abstract fun createAnimal(): Animal
}

// Concrete DogFactory classes
class DogFactory : AnimalFactory() {
    override fun createAnimal(): Animal {
        return Dog()
    }
}

// Concrete CatFactory classes
class CatFactory : AnimalFactory() {
    override fun createAnimal(): Animal {
        return Cat()
    }
}

// Client code
fun main() {
    val dogFactory: AnimalFactory = DogFactory()
    val dog = dogFactory.createAnimal()
    dog.speak()

    val catFactory: AnimalFactory = CatFactory()
    val cat = catFactory.createAnimal()
    cat.speak()
}

/*
Woof!
Meow!
*/

