// Animal protocol
protocol Animal {
    func voice()
}

// Concrete Animal classes
class Dog: Animal {
    func voice() {
        print("Bhow Bhow!!")
    }
}

class Cat: Animal {
    func voice() {
        print("Meow Meow!!")
    }
}

// AnimalFactory protocol
protocol AnimalFactory {
    func getAnimal() -> Animal
}

// Concrete AnimalFactory classes
class CatFactory: AnimalFactory {
    func getAnimal() -> Animal {
        return Cat()
    }
}

class DogFactory: AnimalFactory {
    func getAnimal() -> Animal {
        return Dog()
    }
}

// Client code
let dogFactory: AnimalFactory = DogFactory()
dogFactory.getAnimal().voice()

let catFactory: AnimalFactory = CatFactory()
catFactory.getAnimal().voice()

// Future changes to include cow type of objects.
class Cow: Animal {
    func voice() {
        print("Gooaa Gooaa!!")
    }
}

class CowFactory: AnimalFactory {
    func getAnimal() -> Animal {
        return Cow()
   }
}

// Client code for Cow
let cowFactory: AnimalFactory = CowFactory()
cowFactory.getAnimal().voice()

/*
Bhow Bhow!!
Meow Meow!!
Gooaa Gooaa!!
*/