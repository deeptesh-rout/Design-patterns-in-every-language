interface DesiredInterface {
    fun operation()
}

// Adapter class
class Adapter : DesiredInterface {
    private val adaptee = Adaptee()

    override fun operation() {
        adaptee.someOperation()
    }
}

// Adaptee class
class Adaptee {
    fun someOperation() {
        println("Adaptee someOperation() function called.")
    }
}

// Client Code
fun main() {
    val adapter: DesiredInterface = Adapter()
    adapter.operation()
}

/*
Adaptee someOperation() function called.
*/