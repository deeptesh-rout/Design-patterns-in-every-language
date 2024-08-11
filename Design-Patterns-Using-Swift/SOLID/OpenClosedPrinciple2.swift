class Animal {
    var name: String

    init(name: String) {
        self.name = name
    }
}

class Bird: Animal {
    override init(name: String) {
        super.init(name: name)
    }

    func fly() {
        if name == "Dodo" {
            print("The dodo is extinct and cannot fly.")
        } else if name == "Penguin" {
            print("The penguin cannot fly.")
        } else if name == "Eagle" {
            print("The eagle is soaring through the sky!")
        } else if name == "Sparrow" {
            print("The sparrow is fluttering its wings!")
        }
    }
}

// Client code
let bird1 = Bird(name: "Eagle")
bird1.fly()

let bird2 = Bird(name: "Dodo")
bird2.fly()

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
*/