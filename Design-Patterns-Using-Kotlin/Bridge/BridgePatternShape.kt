// Abstraction abstract class
abstract class Shape(protected val imp: Colour) {
    abstract fun draw()
}

// Rectangle class
class Rectangle(imp: Colour) : Shape(imp) {
    override fun draw() {
        println("Drawing Rectangle with colour ${imp.fill()}")
    }
}

// Circle class
class Circle(imp: Colour) : Shape(imp) {
    override fun draw() {
        println("Drawing Circle with colour ${imp.fill()}")
    }
}

// Colour interface
interface Colour {
    fun fill(): String
}

// Red class
class Red : Colour {
    override fun fill(): String {
        return "Red"
    }
}

// Green class
class Green : Colour {
    override fun fill(): String {
        return "Green"
    }
}

// Blue class
class Blue : Colour {
    override fun fill(): String {
        return "Blue"
    }
}

// Client code
fun main() {
    val c1: Colour = Red()
    var abstraction: Shape = Circle(c1)
    abstraction.draw()

    val c2: Colour = Green()
    abstraction = Rectangle(c2)
    abstraction.draw()
}

/*
Drawing Circle with color Red
Drawing Rectangle with color Green
*/
