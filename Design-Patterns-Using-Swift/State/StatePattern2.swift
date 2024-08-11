protocol State {
    func handle(_ context: Context)
}

class Context {
    private var currentState: State

    init(_ state: State) {
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
    func handle(_ context: Context) {
        print("ConcreteState1 handle")
        context.changeState(ConcreteState2())
    }
}

class ConcreteState2: State {
    func handle(_ context: Context) {
        print("ConcreteState2 handle")
        context.changeState(ConcreteState1())
    }
}

// Client code.
let state1 = ConcreteState1()
let context = Context(state1)
context.request()
context.request()

/* 
ConcreteState1 handle
ConcreteState2 handle 
*/