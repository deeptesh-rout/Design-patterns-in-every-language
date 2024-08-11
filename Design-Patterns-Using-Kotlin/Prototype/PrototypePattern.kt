abstract class Prototype : Cloneable {
    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        return super.clone()
    }

    abstract fun display()
}

class ConcretePrototype1 : Prototype() {
    override fun display() {
        println("ConcretePrototype1")
    }
}

class ConcretePrototype2 : Prototype() {
    override fun display() {
        println("ConcretePrototype2")
    }
}

object PrototypeRegistry {
    private val prototypes: MutableMap<String, Prototype> = HashMap()

    init {
        load()
    }

    fun addPrototype(key: String, value: Prototype) {
        prototypes[key] = value
    }

    @Throws(CloneNotSupportedException::class)
    fun getPrototype(key: String): Prototype? {
        if (prototypes.containsKey(key)) {
            return prototypes[key]!!.clone() as Prototype
        }
        return null
    }

    fun load() {
        addPrototype("CP1", ConcretePrototype1())
        addPrototype("CP2", ConcretePrototype2())
    }
}

// Client Code
fun main() {
    PrototypeRegistry.load()
    val c1 = PrototypeRegistry.getPrototype("CP1")
    val c2 = PrototypeRegistry.getPrototype("CP2")
    c1!!.display()
    c2!!.display()
}

/*
ConcretePrototype1
ConcretePrototype2
*/

