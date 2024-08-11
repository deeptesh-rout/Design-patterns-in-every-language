// Subsystem1
class Subsystem1 {
    fun operation1() {
        println("Subsystem1 operation1")
    }

    fun operation2() {
        println("Subsystem1 operation2")
    }
}

// Subsystem2
class Subsystem2 {
    fun operation1() {
        println("Subsystem2 operation1")
    }

    fun operation2() {
        println("Subsystem2 operation2")
    }
}

// SystemManagerFacade
class SystemManagerFacade {
    private val subsystem1 = Subsystem1()
    private val subsystem2 = Subsystem2()

    fun operation() {
        subsystem1.operation1()
        subsystem1.operation2()
        subsystem2.operation1()
        subsystem2.operation2()
    }
}

// Client code
fun main() {
    val facade = SystemManagerFacade()
    facade.operation()
}

/*
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
*/

