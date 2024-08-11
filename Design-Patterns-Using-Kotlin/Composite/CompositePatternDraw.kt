// Interface IShape
interface IShape {
    fun move(x: Int, y: Int)
    fun draw(): String
}

// Rectangle
open class Rectangle(private var x: Int, private var y: Int, private val length: Int, private val breadth: Int) : IShape {
    override fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun draw(): String {
        println("Draw a Rectangle at ($x, $y).")
        return "<Rectangle>"
    }
}

// Circle
class Circle(private var x: Int, private var y: Int, private val radius: Int) : IShape {
    override fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun draw(): String {
        println("Draw a Circle of radius $radius at ($x, $y).")
        return "<Circle>"
    }
}

// CompoundShape
class CompoundShape : IShape {
    private val children: MutableSet<IShape> = HashSet()

    fun add(child: IShape) {
        children.add(child)
    }

    fun remove(child: IShape) {
        children.remove(child)
    }

    override fun move(x: Int, y: Int) {
        for (child in children) {
            child.move(x, y)
        }
    }

    override fun draw(): String {
        var st = "Shapes("
        for (child in children) {
            st += child.draw()
        }
        st += ")"
        return st
    }
}

// Client code
fun main() {
    val all = CompoundShape()
    all.add(Rectangle(1, 2, 1, 2))
    all.add(Circle(5, 3, 10))

    val group = CompoundShape()
    group.add(Rectangle(5, 7, 1, 2))
    group.add(Circle(2, 1, 2))
    all.add(group)
    println(all.draw())
}


/*
Draw a Rectangle at (1, 2).
Draw a Circle of radius 2 at (2, 1).
Draw a Rectangle at (5, 7).
Draw a Circle of radius 10 at (5, 3).
Shapes(<Rectangle>Shapes(<Circle><Rectangle>)<Circle>)
*/
