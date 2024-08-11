import java.util.HashMap

abstract class Shape : Cloneable {
    var color: String = ""

    abstract override fun toString(): String

    public override fun clone(): Shape{
        return super.clone() as Shape
    }
}

class Rectangle : Shape() {
    public override fun clone(): Shape {
        return super.clone() as Rectangle
    }

    override fun toString(): String {
        return "Rectangle."
    }
}

class Circle : Shape() {
    public override fun clone(): Shape {
        return super.clone() as Circle
    }

    override fun toString(): String {
        return "Circle."
    }
}

object ShapeRegistry {
    private val shapes: MutableMap<String, Shape> = HashMap()

    fun addShape(key: String, value: Shape) {
        if (!shapes.containsKey(key)) {
            shapes[key] = value
        }
    }

    fun getShape(key: String): Shape {
        return shapes[key]?.clone() ?: throw NoSuchElementException("Shape with key $key not found")
    }

    fun load() {
        addShape("circle", Circle())
        addShape("rectangle", Rectangle())
    }
}

// Client code
fun main() {
    ShapeRegistry.load()
    val c = ShapeRegistry.getShape("circle")
    val r = ShapeRegistry.getShape("rectangle")
    println("$c")
    println("$r")
}

/*
Circle. 
Rectangle.
*/