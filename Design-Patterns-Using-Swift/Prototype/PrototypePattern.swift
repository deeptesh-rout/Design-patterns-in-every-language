import Foundation

protocol Clonable {
    func clone() -> Self
}

class Prototype: Clonable {
    func clone() -> Self {
        return self
    }

    func display() {
        fatalError("Subclasses must override the 'display' method.")
    }
}

class ConcretePrototype1: Prototype {
    override func display() {
        print("ConcretePrototype1")
    }
}

class ConcretePrototype2: Prototype {
    override func display() {
        print("ConcretePrototype2")
    }
}

class PrototypeRegistry {
    private static var prototypes: [String: Clonable] = [:]

    static func addPrototype(key: String, value: Clonable) {
        prototypes[key] = value
    }

    static func getPrototype(key: String) -> Clonable? {
        return prototypes[key]?.clone()
    }

    static func load() {
        addPrototype(key: "CP1", value: ConcretePrototype1())
        addPrototype(key: "CP2", value: ConcretePrototype2())
    }
}

// Client code
PrototypeRegistry.load()
if let c1 = PrototypeRegistry.getPrototype(key: "CP1") as? Prototype {
    c1.display()
}
if let c2 = PrototypeRegistry.getPrototype(key: "CP2") as? Prototype {
    c2.display()
}

/*
ConcretePrototype1
ConcretePrototype2
*/
