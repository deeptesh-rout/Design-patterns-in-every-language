// Abstraction protocol
protocol Abstraction {
    func operation()
}

// Implementor protocol
protocol Implementor {
    func operation()
}

// ConcreteImplementor1 class
class ConcreteImplementor1: Implementor {
    func operation() {
        print("ConcreteImplementor1 operation")
    }
}

// ConcreteImplementor2 class
class ConcreteImplementor2: Implementor {
    func operation() {
        print("ConcreteImplementor2 operation")
    }
}

// ConcreteAbstraction class
class ConcreteAbstraction: Abstraction {
    private var imp: Implementor

    init(imp: Implementor) {
        self.imp = imp
    }

    func operation() {
        imp.operation()
    }
}

// Client code
let c1 = ConcreteImplementor1()
let abstraction: Abstraction = ConcreteAbstraction(imp: c1)
abstraction.operation()

/*
ConcreteImplementor1 operation
*/