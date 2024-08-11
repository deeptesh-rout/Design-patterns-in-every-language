// Component
protocol Component {
    func operation()
}

// ConcreteComponent
class ConcreteComponent: Component {
    func operation() {
        print("ConcreteComponent operation.")
    }
}

// Decorator
class Decorator: Component {
    private let component: Component

    init(_ component: Component) {
        self.component = component
    }

    func operation() {
        component.operation()
    }
}

// ConcreteDecorator1
class ConcreteDecorator1: Decorator {
    override func operation() {
        print("ConcreteDecorator1 operation start.")
        super.operation()
        print("ConcreteDecorator1 operation end.")
    }
}

// ConcreteDecorator2
class ConcreteDecorator2: Decorator {
    override func operation() {
        print("ConcreteDecorator2 operation start.")
        super.operation()
        print("ConcreteDecorator2 operation end.")
    }
}

// Client code
let component: Component = ConcreteComponent()
let decorator1: Decorator = ConcreteDecorator1(component)
let decorator2: Decorator = ConcreteDecorator2(decorator1)
decorator2.operation()

/*
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end.
*/