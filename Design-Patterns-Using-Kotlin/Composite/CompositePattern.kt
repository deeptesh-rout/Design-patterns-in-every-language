// Component
abstract class Component {
    abstract fun operation()
}

// Composite
class Composite : Component() {
    private val children: MutableSet<Component> = HashSet()

    override fun operation() {
        println("Composite Operation")
        for (child in children) {
            child.operation()
        }
    }

    fun add(component: Component) {
        children.add(component)
    }

    fun remove(component: Component) {
        children.remove(component)
    }
}

// Leaf
class Leaf : Component() {
    override fun operation() {
        println("Leaf Operation")
    }
}

// Client code
fun main() {
    val composite = Composite()
    composite.add(Leaf())

    val composite2 = Composite()
    composite2.add(Leaf())

    composite.add(composite2)
    composite.operation()
}

/*
Composite Operation
Leaf Operation
Composite Operation
Leaf Operation
*/