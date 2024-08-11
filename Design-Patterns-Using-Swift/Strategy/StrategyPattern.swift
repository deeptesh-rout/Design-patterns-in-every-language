import Foundation

protocol Strategy {
    func execute(_ data: Int)
}

class ConcreteStrategy1: Strategy {
    func execute(_ data: Int) {
        print("ConcreteStrategy1 execute")
    }
}

class ConcreteStrategy2: Strategy {
    func execute(_ data: Int) {
        print("ConcreteStrategy2 execute")
    }
}

class Context {
    private var strategy: Strategy

    init(strategy: Strategy) {
        self.strategy = strategy
    }

    func setStrategy(_ strategy: Strategy) {
        self.strategy = strategy
    }

    func execute() {
        let data = 1
        self.strategy.execute(data)
    }
}

// Client code.
let context = Context(strategy: ConcreteStrategy1())
context.execute()

context.setStrategy(ConcreteStrategy2())
context.execute()

/*
ConcreteStrategy1 execute
ConcreteStrategy2 execute
*/