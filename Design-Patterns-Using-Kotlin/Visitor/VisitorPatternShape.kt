import kotlin.collections.ArrayList

abstract class Shape {
    abstract fun accept(visitor: Visitor): String
}

class Circle(val x: Int, val y: Int, val radius: Int) : Shape() {
    override fun accept(visitor: Visitor): String {
        return visitor.visitCircle(this)
    }
}

class Rectangle(val x: Int, val y: Int, val width: Int, val height: Int) : Shape() {
    override fun accept(visitor: Visitor): String {
        return visitor.visitRectangle(this)
    }
}

abstract class Visitor {
    abstract fun visitCircle(element: Circle): String
    abstract fun visitRectangle(element: Rectangle): String
}

class XMLVisitor : Visitor() {
    override fun visitCircle(element: Circle): String {
        return "<circle>\n  <x>${element.x}</x>\n  <y>${element.y}</y>\n  <radius>${element.radius}</radius>\n</circle>"
    }

    override fun visitRectangle(element: Rectangle): String {
        return "<rectangle>\n  <x>${element.x}</x>\n  <y>${element.y}</y>\n  <width>${element.width}</width>\n  <height>${element.height}</height>\n</rectangle>"
    }
}

class TextVisitor : Visitor() {
    override fun visitCircle(element: Circle): String {
        return "Circle ( (x : ${element.x}, y : ${element.y}), radius : ${element.radius}) "
    }

    override fun visitRectangle(element: Rectangle): String {
        return "Rectangle ( (x : ${element.x}, y : ${element.y}), width : ${element.width}, height : ${element.height})"
    }
}

class ObjectsStructure {
    private val shapes: MutableList<Shape> = ArrayList()
    private lateinit var visitor: Visitor

    fun addShapes(shape: Shape) {
        shapes.add(shape)
    }

    fun setVisitor(visitor: Visitor) {
        this.visitor = visitor
    }

    fun accept() {
        shapes.forEach { shape -> println(shape.accept(visitor)) }
    }
}

// Client code
fun main() {
    val os = ObjectsStructure()
    os.addShapes(Rectangle(6, 7, 8, 9))
    os.addShapes(Circle(6, 7, 8))

    os.setVisitor(XMLVisitor())
    os.accept()

    os.setVisitor(TextVisitor())
    os.accept()
}

/*
<rectangle>
  <x>6</x>
  <y>7</y>
  <width>8</width>
  <height>9</height>
</rectangle>
<circle>
  <x>6</x>
  <y>7</y>
  <radius>8</radius>
</circle>
Rectangle ( (x : 6, y : 7), width : 8, height : 9)
Circle ( (x : 6, y : 7), radius : 8) 
*/