interface Strategy {
    fun execute(data: Int)
}

class ConcreteStrategy1 : Strategy {
    override fun execute(data: Int) {
        println("ConcreteStrategy1 execute")
    }
}

class ConcreteStrategy2 : Strategy {
    override fun execute(data: Int) {
        println("ConcreteStrategy2 execute")
    }
}

class Context(private var strategy: Strategy) {
    fun setStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun execute() {
        val data = 1
        strategy.execute(data)
    }
}

// Client code
fun main() {
    val context = Context(ConcreteStrategy1())
    context.execute()

    context.setStrategy(ConcreteStrategy2())
    context.execute()
}

/*
ConcreteStrategy1 execute
ConcreteStrategy2 execute
*/