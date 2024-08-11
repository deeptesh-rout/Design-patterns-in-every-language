// Flyweight protocol
protocol Flyweight {
    func operation(extrinsicState: String)
}

// Concrete Flyweight class
class ConcreteFlyweight: Flyweight {
    private let intrinsicState: String

    init(intrinsicState: String) {
        self.intrinsicState = intrinsicState
    }

    func operation(extrinsicState: String) {
        print("Operation inside concrete flyweight: \(self)")
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
        print("Operation inside context: \(self)")
        flyweight.operation(extrinsicState: extrinsicState)
    }
}

// Client Code
let factory = FlyweightFactory()
let c = ClientClass(factory: factory, intrinsicState: "common", extrinsicState: "separate1")
c.operation()
let c2 = ClientClass(factory: factory, intrinsicState: "common", extrinsicState: "separate2")
c2.operation()

/*
Operation inside context: Flyweight2.ClientClass
Operation inside concrete flyweight: Flyweight2.ConcreteFlyweight
Operation inside context: Flyweight2.ClientClass
Operation inside concrete flyweight: Flyweight2.ConcreteFlyweight
*/