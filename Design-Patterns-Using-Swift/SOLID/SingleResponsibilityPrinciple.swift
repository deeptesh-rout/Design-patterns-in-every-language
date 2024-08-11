class Animal {
    var name: String

    init(name: String) {
        self.name = name
    }

    func eat() {
        print("\(name) is eating.")
    }

    func sleep() {
        print("\(name) is sleeping.")
    }

    func makeSound() {
        print("\(name) is making a sound.")
    }
}

class Mammal: Animal {
    override init(name: String) {
        super.init(name: name)
    }

    func giveBirth() {
        print("\(name) is giving birth to live young.")
    }
}

class Reptile: Animal {
    override init(name: String) {
        super.init(name: name)
    }

    func layEggs() {
        print("\(name) is laying eggs.")
    }
}

class Bird: Animal {
    override init(name: String) {
        super.init(name: name)
    }

    func fly() {
        print("\(name) is flying.")
    }

    func layEggs() {
        print("\(name) is laying eggs.")
    }
}

// Client code.
let animal1 = Mammal(name: "Cat")
animal1.giveBirth()
animal1.makeSound()

let animal2 = Reptile(name: "Snake")
animal2.layEggs()
animal2.eat()

let animal3 = Bird(name: "Eagle")
animal3.layEggs()
animal3.fly()

/*
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is laying eggs.
Eagle is flying.
*/