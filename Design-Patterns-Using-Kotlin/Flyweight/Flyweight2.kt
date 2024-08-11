// Flyweight interface
interface Flyweight {
    fun operation(extrinsicState: String?)
}

// Concrete Flyweight class
class ConcreteFlyweight(private val intrinsicState: String) : Flyweight {
    override fun operation(extrinsicState: String?) {
        println("Operation inside concrete Flyweight: $this")
    }
}

// FlyweightFactory class
class FlyweightFactory {
    private val flyweights: MutableMap<String, Flyweight> = HashMap()

    fun getFlyweight(intrinsicState: String): Flyweight? {
        if (!flyweights.containsKey(intrinsicState)) {
            flyweights[intrinsicState] = ConcreteFlyweight(intrinsicState)
        }
        return flyweights[intrinsicState]
    }
}

// ClientClass
class ClientClass(factory: FlyweightFactory, intrinsicState: String, var extrinsicState: String) {
    var flyweight: Flyweight? = factory.getFlyweight(intrinsicState)

    fun operation() {
        println("Operation inside context: $this")
        flyweight!!.operation(extrinsicState)
    }
}

// Client Code
fun main() {
    val factory = FlyweightFactory()
    val c = ClientClass(factory, "common", "separate1")
    c.operation()
    val c2 = ClientClass(factory, "common", "separate2")
    c2.operation()
}

/*
Operation inside context: ClientClass@7d4991ad
Operation inside concrete Flyweight: ConcreteFlyweight@28d93b30
Operation inside context: ClientClass@1b6d3586
Operation inside concrete Flyweight: ConcreteFlyweight@28d93b30
*/

