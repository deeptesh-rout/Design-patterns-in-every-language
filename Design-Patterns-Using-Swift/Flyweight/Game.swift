import Foundation

// Flyweight protocol
protocol Flyweight {
    var intrinsicState: String { get }
    func operation(extrinsicState: String)
}

// Concrete Flyweight class
class ConcreteFlyweight: Flyweight {
    let intrinsicState: String

    init(intrinsicState: String) {
        self.intrinsicState = intrinsicState
    }

    func operation(extrinsicState: String) {
        print("Operation inside concrete flyweight.")
    }
}

// FlyweightFactory class
class FlyweightFactory {
    private var flyweights: [String: Flyweight] = [:]

    func getFlyweight(intrinsicState: String) -> Flyweight {
        if let existingFlyweight = flyweights[intrinsicState] {
            return existingFlyweight
        } else {
            let newFlyweight = ConcreteFlyweight(intrinsicState: intrinsicState)
            flyweights[intrinsicState] = newFlyweight
            return newFlyweight
        }
    }
}

// ClientClass
class ClientClass {
    var flyweight: Flyweight
    var extrinsicState: String

    init(factory: FlyweightFactory, intrinsicState: String, extrinsicState: String) {
        self.flyweight = factory.getFlyweight(intrinsicState: intrinsicState)
        self.extrinsicState = extrinsicState
    }

    func operation() {
        print("Operation inside context.")
        flyweight.operation(extrinsicState: extrinsicState)
    }
}

// Client code
let factory = FlyweightFactory()
let c = ClientClass(factory: factory, intrinsicState: "common", extrinsicState: "separate1")
c.operation()

let c2 = ClientClass(factory: factory, intrinsicState: "common", extrinsicState: "separate2")
c2.operation()

print(c, c2)
print(c.flyweight, c2.flyweight)

/*
Operation inside context.
Operation inside concrete flyweight.
Operation inside context.
Operation inside concrete flyweight.
Game.ClientClass Game.ClientClass
Game.ConcreteFlyweight Game.ConcreteFlyweight
*/