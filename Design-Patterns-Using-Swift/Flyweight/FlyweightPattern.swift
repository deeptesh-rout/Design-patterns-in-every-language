import Foundation

// Flyweight class
class Flyweight {
    var intrinsicState: String

    init(intrinsicState: String) {
        self.intrinsicState = intrinsicState
    }

    func operation(extrinsicState: Any?) {
        print("Operation inside flyweight")
    }
}

// Concrete Flyweight class
class ConcreteFlyweight: Flyweight {
    override func operation(extrinsicState: Any?) {
        print("Operation inside concrete flyweight")
    }
}

// FlyweightFactory class
class FlyweightFactory {
    private var flyweights: [String: Flyweight] = [:]

    func getFlyweight(key: String) -> Flyweight {
        if flyweights[key] == nil {
            flyweights[key] = ConcreteFlyweight(intrinsicState: key)
        }
        return flyweights[key]!
    }

    var count: Int {
        return flyweights.count
    }
}

// Client code
let factory = FlyweightFactory()
let flyweight1 = factory.getFlyweight(key: "key")
let flyweight2 = factory.getFlyweight(key: "key")
flyweight1.operation(extrinsicState: nil)
print("\(flyweight1) \(flyweight2)")
print("Object count: \(factory.count)")

/*
Operation inside concrete flyweight
FlyweightPattern.ConcreteFlyweight FlyweightPattern.ConcreteFlyweight
Object count: 1
*/
