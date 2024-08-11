// Product protocol
protocol Animal {
    func speak()
}

// Concrete Product classes
class Dog: Animal {
    func speak() {
        print("Woof Woof!")
    }
}

class Cat: Animal {
    func speak() {
        print("Meow Meow!")
    }
}

// Creator protocol
protocol AnimalFactory {
    func createAnimal() -> Animal
}

// Concrete Creator classes
class DogFactory: AnimalFactory {
    func createAnimal() -> Animal {
        return Dog()
    }
}

class CatFactory: AnimalFactory {
    func createAnimal() -> Animal {
        return Cat()
    }
}

// Client code
let dogFactory: AnimalFactory = DogFactory()
let dog = dogFactory.createAnimal()
dog.speak()

let catFactory: AnimalFactory = CatFactory()
let cat = catFactory.createAnimal()
cat.speak()

/*
Woof Woof!
Meow Meow!
*/