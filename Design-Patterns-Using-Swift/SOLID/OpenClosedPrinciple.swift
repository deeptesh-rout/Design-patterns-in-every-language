class Animal {
    var name: String

    init(name: String) {
        self.name = name
    }
}

class Bird: Animal {
    override init(name: String = "") {
        super.init(name: name)
    }
        
    func fly() {
        // Abstract method, to be overridden by subclasses
    }
}

class Dodo: Bird {
    override init(name: String = "") {
        super.init(name: "Dodo")
    }

    override func fly() {
        print("The dodo is extinct and cannot fly.")
    }
}

class Penguin: Bird {
    override init(name: String = "") {
        super.init(name: "Penguin")
    }

    override func fly() {
        print("The penguin cannot fly.")
    }

    func slide() {
        print("The penguin is sliding on its belly!")
    }

    func swim() {
        print("The penguin is swimming in the water!")
    }
}

class Eagle: Bird {
    override init(name: String = "") {
        super.init(name: "Eagle")
    }

    override func fly() {
        print("The eagle is soaring through the sky!")
    }
}

class Sparrow: Bird {
    override init(name: String = "") {
        super.init(name: "Sparrow")
    }

    override func fly() {
        print("The sparrow is fluttering its wings!")
    }
}

class Pigeon: Bird {
    override init(name: String = "") {
        super.init(name: "Pigeon")
    }

    func makeCooingSound() {
        print("The pigeon is making a cooing sound.")
    }

    override func fly() {
        print("The pigeon is fluttering its wings!")
    }
}

// Client code
let bird1: Bird = Eagle()
bird1.fly()

let bird2: Bird = Dodo()
bird2.fly()

let bird3: Bird = Pigeon()
bird3.fly()

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
The pigeon is fluttering its wings!
*/