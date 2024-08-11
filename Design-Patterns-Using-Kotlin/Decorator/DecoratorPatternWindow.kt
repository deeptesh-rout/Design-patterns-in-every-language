// Window (Component)
interface Window {
    fun draw()
}

// SimpleWindow (ConcreteComponent)
class SimpleWindow : Window {
    override fun draw() {
        println("SimpleWindow draw.")
    }
}

// Decorator (Decorator)
abstract class Decorator(protected var component: Window) : Window {
    override fun draw() {
        component.draw()
    }
}

// VerticalScrollBarDecorator (ConcreteDecorator)
class VerticalScrollBarDecorator(component: Window) : Decorator(component) {
    override fun draw() {
        super.draw()
        println("VerticalScrollBarDecorator draw")
    }
}

// HorizontalScrollBarDecorator (ConcreteDecorator)
class HorizontalScrollBarDecorator(component: Window) : Decorator(component) {
    override fun draw() {
        super.draw()
        println("HorizontalScrollBarDecorator draw")
    }
}

// Client code
fun main() {
    val component: Window = SimpleWindow()
    val decorator1: Window = VerticalScrollBarDecorator(component)
    val decorator2: Window = HorizontalScrollBarDecorator(decorator1)
    decorator2.draw()
}

/*
SimpleWindow draw.
VerticalScrollBarDecorator draw
HorizontalScrollBarDecorator draw
*/
