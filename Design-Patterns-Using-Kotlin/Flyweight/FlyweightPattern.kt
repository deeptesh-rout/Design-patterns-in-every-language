// Flyweight interface
interface Flyweight {
    fun operation(extrinsicState: Any?)
}

// Concrete Flyweight class
class ConcreteFlyweight(private val intrinsicState: String) : Flyweight {
    override fun operation(extrinsicState: Any?) {
        println("Operation inside concrete flyweight.")
    }
}

// FlyweightFactory class
class FlyweightFactory {
    private val flyweights: MutableMap<String, Flyweight> = HashMap()

    fun getFlyweight(key: String): Flyweight? {
        if (!flyweights.containsKey(key)) {
            flyweights[key] = ConcreteFlyweight(key)
        }
        return flyweights[key]
    }

    val count: Int
        get() = flyweights.size
}

// Client code
fun main() {
    val factory = FlyweightFactory()
    val flyweight1 = factory.getFlyweight("key")
    val flyweight2 = factory.getFlyweight("key")
    flyweight1!!.operation(null)
    println("Flyweight: $flyweight1 & $flyweight2.")
    println("Object count: " + factory.count)
}

/* 
Operation inside concrete flyweight.
Flyweight: ConcreteFlyweight@6bc7c054 & ConcreteFlyweight@6bc7c054.
Object count: 1
*/
