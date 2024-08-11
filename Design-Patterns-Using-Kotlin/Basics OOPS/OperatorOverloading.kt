import kotlin.math.abs

open class Rectangle(private val length: Double, private val breadth: Double) {
    fun area(): Double {
        return length * breadth
    }

    fun perimeter(): Double {
        return 2 * (length + breadth)
    }

    // Overloading + operator
    fun add(rec: Rectangle): Rectangle {
        return Rectangle(abs(length + rec.length), this.breadth + rec.breadth)
    }

    // Overloading - operator
    fun subtract(rec: Rectangle): Rectangle {
        return Rectangle(abs(this.length - rec.length), abs(this.breadth - rec.breadth))
    }

    // Overloading == operator
    fun equals(rec: Rectangle): Boolean {
        return this.length == rec.length && this.breadth == rec.breadth
    }

    // Overriding toString method
    override fun toString(): String {
        return "Rectangle length and width: $length $breadth"
    }
}

fun main() {
    val r1 = Rectangle(4.0, 6.0)
    val r2 = Rectangle(10.0, 6.0)

    println("Is r1 == r2 ? " + r1.equals(r2))

    val r3: Rectangle = r1.add(r2)
    val r4: Rectangle = r1.subtract(r2)

    println(r1)
    println(r2)
    println(r3)
    println(r4)
}

/*
Is r1 == r2 ? false
Rectangle length and width: 4.0 6.0
Rectangle length and width: 10.0 6.0
Rectangle length and width: 14.0 12.0
Rectangle length and width: 6.0 0.0
*/