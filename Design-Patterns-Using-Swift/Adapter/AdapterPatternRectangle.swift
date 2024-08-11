// Desired Interface
protocol Shape {
    func draw()
}

// Circle class
class Circle: Shape {
    private var x: Int
    private var y: Int
    private var radius: Int

    init(x: Int, y: Int, radius: Int) {
        self.x = x
        self.y = y
        self.radius = radius
    }

    func draw() {
        print("Draw the Circle.")
    }
}

// Rectangle class (Adaptee)
class Rectangle {
    private var x: Int
    private var y: Int
    private var length: Int
    private var width: Int

    init(x: Int, y: Int, length: Int, width: Int) {
        self.x = x
        self.y = y
        self.length = length
        self.width = width
    }

    func oldDraw() {
        print("Drawing Rectangle.")
    }
}

// RectangleAdapter class
class RectangleAdapter: Shape {
    private var adaptee: Rectangle

    init(x: Int, y: Int, length: Int, width: Int) {
        self.adaptee = Rectangle(x: x, y: y, length: length, width: width)
    }

    func draw() {
        adaptee.oldDraw()
    }
}

// Client Code
let adapter: Shape = RectangleAdapter(x: 1, y: 2, length: 3, width: 4)
adapter.draw()

/*
Drawing Rectangle.
*/
