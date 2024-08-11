interface State {
    fun handle(context: Context)
}

class Context(private var currentState: State) {
    fun changeState(state: State) {
        this.currentState = state
    }

    fun request() {
        currentState.handle(this)
    }
}

class ConcreteState1 : State {
    override fun handle(context: Context) {
        println("ConcreteState1 handle")
        context.changeState(ConcreteState2())
    }
}

class ConcreteState2 : State {
    override fun handle(context: Context) {
        println("ConcreteState2 handle")
        context.changeState(ConcreteState1())
    }
}

// Client code.
fun main() {
    val state1: State = ConcreteState1()
    val context = Context(state1)
    context.request()
    context.request()
}

/*
ConcreteState1 handle
ConcreteState2 handle
*/