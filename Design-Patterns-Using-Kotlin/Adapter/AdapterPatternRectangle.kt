// Desired Shape Interface
interface Shape {
    fun draw()
}

// Circle class
class Circle(private val x: Int, private val y: Int, private val radius: Int) : Shape {
    override fun draw() {
        println("Draw the Circle.")
    }
}

// Rectangle class (Adaptee)
open class Rectangle(private val x: Int, private val y: Int, val length: Int, private val width: Int) {
    fun oldDraw() {
        println("Drawing Rectangle.")
    }
}

// RectangleAdapter class
class RectangleAdapter(x: Int, y: Int, l: Int, w: Int) : Shape {
    private val adaptee = Rectangle(x, y, l, w)

    override fun draw() {
        adaptee.oldDraw()
    }
}

// Client Code
fun main() {
    val adapter: Shape = RectangleAdapter(1, 2, 3, 4)
    adapter.draw()
}

/*
Drawing Rectangle.
*/