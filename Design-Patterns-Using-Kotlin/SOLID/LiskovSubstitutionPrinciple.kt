abstract class Animal(val name: String) {
    abstract fun makeSound()
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("woof woof!")
    }
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("meow!")
    }
}



open class Rectangle(var _height: Int, var _width: Int) {

    open fun setWidth(w: Int) {
        _width = w
    }

    open fun setHeight(h: Int) {
        _height = h
    }

    fun getWidth(): Int {
        return _width
    }

    fun getHeight(): Int {
        return _height
    }
}

class Square(l: Int) : Rectangle(l, l) {

    override fun setWidth(w: Int) {
        super.setWidth(w)
        super.setHeight(w)
    }

    override fun setHeight(h: Int) {
        super.setWidth(h)
        super.setHeight(h)
    }
}

fun testRectangle() {
    val r = Rectangle(10, 20)
    testRect(r)
}

fun testSquare() {
    val s = Square(10)
    s.setWidth(20)
    testRect(s)
}

private fun testRect(rect: Rectangle) {
    rect.setHeight(10)
    rect.setWidth(20)
    if (200 == rect.getHeight() * rect.getWidth())
        println("success")
    else
        println("failure")
}

// Client code
fun main() {
    testRectangle()
    testSquare()
}

/*
success
failure
*/