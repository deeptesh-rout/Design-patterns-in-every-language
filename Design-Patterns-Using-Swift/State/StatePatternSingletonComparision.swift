import Foundation

protocol State {
    func handle(_ context: Context)
}

class Context {
    private var currentState: State

    init(state: State) {
        self.currentState = state
    }

    func changeState(_ state: State) {
        self.currentState = state
    }

    func request() {
        self.currentState.handle(self)
    }
}

class ConcreteState1: State {
    private static var instance: ConcreteState1?

    private init() {}

    static func getInstance() -> ConcreteState1 {
        if instance == nil {
            instance = ConcreteState1()
        }
        return instance!
    }

    func handle(_ context: Context) {
        context.changeState(ConcreteState2.getInstance())
    }
}

class ConcreteState2: State {
    private static var instance: ConcreteState2?

    private init() {}

    static func getInstance() -> ConcreteState2 {
        if instance == nil {
            instance = ConcreteState2()
        }
        return instance!
    }

    func handle(_ context: Context) {
        context.changeState(ConcreteState3.getInstance())
    }
}

class ConcreteState3: State {
    private static var instance: ConcreteState3?

    private init() {}

    static func getInstance() -> ConcreteState3 {
        if instance == nil {
            instance = ConcreteState3()
        }
        return instance!
    }

    func handle(_ context: Context) {
        context.changeState(ConcreteState4.getInstance())
    }
}

class ConcreteState4: State {
    private static var instance: ConcreteState4?

    private init() {}

    static func getInstance() -> ConcreteState4 {
        if instance == nil {
            instance = ConcreteState4()
        }
        return instance!
    }

    func handle(_ context: Context) {
        context.changeState(ConcreteState1.getInstance())
    }
}

func test(state: State, count: Int) {
    let context = Context(state: state)
    let start = Date()
    for _ in 0..<count {
        context.request()
    }
    let end = Date()
    let duration = end.timeIntervalSince(start)
    print(duration)
}

// Client Code
let state1 = ConcreteState1.getInstance()
test(state: state1, count: 10)

let state2 = ConcreteState1.getInstance()
test(state: state2, count: 10)

/*
2.9802322387695312e-06
1.9073486328125e-06
*/