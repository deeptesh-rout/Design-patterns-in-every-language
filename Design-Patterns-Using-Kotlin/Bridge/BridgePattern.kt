// Abstraction abstract class
abstract class Abstraction {
    abstract val imp: Implementor
    abstract fun operation()
}

// Implementor abstract class
abstract class Implementor {
    abstract fun operation()
}

// ConcreteImplementor1 class
class ConcreteImplementor1 : Implementor() {
    override fun operation() {
        println("ConcreteImplementor1 operation")
    }
}

// ConcreteImplementor2 class
class ConcreteImplementor2 : Implementor() {
    override fun operation() {
        println("ConcreteImplementor2 operation")
    }
}

// ConcreteAbstraction class
class ConcreteAbstraction(override val imp: Implementor) : Abstraction() {
    override fun operation() {
        imp.operation()
    }
}

// Client code
fun main() {
    val c1: Implementor = ConcreteImplementor1()
    val abstraction: Abstraction = ConcreteAbstraction(c1)
    abstraction.operation()
}

/*
ConcreteImplementor1 operation
*/