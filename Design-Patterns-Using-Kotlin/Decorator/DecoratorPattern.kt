// Interface Component
interface Component {
    fun operation()
}

// ConcreteComponent
class ConcreteComponent : Component {
    override fun operation() {
        println("ConcreteComponent operation.")
    }
}

// Decorator
abstract class Decorator(private val component: Component) : Component {
    override fun operation() {
        component.operation()
    }
}

// ConcreteDecorator1
class ConcreteDecorator1(component: Component) : Decorator(component) {
    override fun operation() {
        println("ConcreteDecorator1 operation start.")
        super.operation()
        println("ConcreteDecorator1 operation end.")
    }
}

// ConcreteDecorator2
class ConcreteDecorator2(component: Component) : Decorator(component) {
    override fun operation() {
        println("ConcreteDecorator2 operation start.")
        super.operation()
        println("ConcreteDecorator2 operation end.")
    }
}

// Client code
fun main() {
    val component: Component = ConcreteComponent()
    val decorator1: Decorator = ConcreteDecorator1(component)
    val decorator2: Decorator = ConcreteDecorator2(decorator1)
    decorator2.operation()
}

/*
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end.
*/

