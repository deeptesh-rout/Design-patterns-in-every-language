import java.util.HashMap
import java.util.Random

// Shape abstract class
abstract class Shape(val colour: Int) {
    abstract fun draw(x1: Int, y1: Int, x2: Int, y2: Int) // Extrinsic State
}

// Rectangle class
class Rectangle(colour: Int) : Shape(colour) {
    override fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        println("Draw Rectangle colour:$colour topleft: ($x1,$y1) rightBottom: ($x2,$y2)")
    }
}

// RectangleFactory class
class RectangleFactory {
    private val shapes: MutableMap<Int, Shape> = HashMap()

    fun getRectangle(colour: Int): Shape {
        if (!shapes.containsKey(colour)) {
            shapes[colour] = Rectangle(colour)
        }
        return shapes[colour]!!
    }

    fun getCount(): Int {
        return shapes.size
    }
}

// Client code
fun main() {
    val factory = RectangleFactory()
    val random = Random()

    repeat(1000) {
        val rect = factory.getRectangle(random.nextInt(1000))
        rect.draw(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100))
    }
    println(factory.getCount())
}
