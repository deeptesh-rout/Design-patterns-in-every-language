abstract class Animal {
    abstract fun voice()
}

class Dog : Animal() {
    override fun voice() {
        println("Woof Woof!!")
    }
}

class Cat : Animal() {
    override fun voice() {
        println("Meow Meow!!")
    }
}

abstract class AnimalFactory {
    abstract fun getAnimal(): Animal
}

class CatFactory : AnimalFactory() {
    override fun getAnimal(): Animal {
        return Cat()
    }
}

class DogFactory : AnimalFactory() {
    override fun getAnimal(): Animal {
        return Dog()
    }
}

// Client Code
fun main2() {
    val dogFactory: AnimalFactory = DogFactory()
    dogFactory.getAnimal().voice()

    val catFactory: AnimalFactory = CatFactory()
    catFactory.getAnimal().voice()
}


// Future changes to include cow type of objects.
class Cow : Animal() {
    override fun voice() {
        println("Gooaa Gooaa!!")
    }
}

class CowFactory : AnimalFactory() {
    override fun getAnimal(): Animal {
        return Cow()
    }
}

// Client Code
fun main() {
    val cowFactory: AnimalFactory = CowFactory()
    cowFactory.getAnimal().voice()
}

/*
Woof Woof!!
Meow Meow!!
Gooaa Gooaa!!
*/
