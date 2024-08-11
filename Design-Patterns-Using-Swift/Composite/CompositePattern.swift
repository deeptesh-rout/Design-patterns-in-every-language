// Component
class Component: Hashable {
    static func == (lhs: Component, rhs: Component) -> Bool {
        return ObjectIdentifier(lhs) == ObjectIdentifier(rhs)
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(ObjectIdentifier(self))
    }
    
    func operation() {
        fatalError("Operation must be overridden by subclasses")
    }
}

// Composite
class Composite: Component {
    private var children = Set<Component>()

    override func operation() {
        print("Composite Operation")
        for child in children {
            child.operation()
        }
    }

    func add(_ component: Component) {
        children.insert(component)
    }

    func remove(_ component: Component) {
        children.remove(component)
    }
}

// Leaf
class Leaf: Component {
    override func operation() {
        print("Leaf Operation")
    }
}

// Client code
let leaf1 = Leaf()
let leaf2 = Leaf()

let composite = Composite()
composite.add(leaf1)

let composite2 = Composite()
composite2.add(leaf2)

composite.add(composite2)

composite.operation()

/*
Composite Operation
Leaf Operation
Composite Operation
Leaf Operation
*/