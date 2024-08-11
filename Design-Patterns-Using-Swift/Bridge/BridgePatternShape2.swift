// Abstraction
class Shape {
    var implementation: DrawingAPI

    init(implementation: DrawingAPI) {
        self.implementation = implementation
    }

    func draw() {
        fatalError("Abstract method. Subclasses must implement this method.")
    }
}

// Concrete Abstraction
class Square: Shape {
    override func draw() {
        implementation.drawSquare()
    }
}

class Circle: Shape {
    override func draw() {
        implementation.drawCircle()
    }
}

// Implementation
protocol DrawingAPI {
    func drawSquare()
    func drawCircle()
}

// Concrete Implementation
class WindowsAPI: DrawingAPI {
    func drawSquare() {
        print("Drawing a square on Windows.")
    }

    func drawCircle() {
        print("Drawing a circle on Windows.")
    }
}

class MacAPI: DrawingAPI {
    func drawSquare() {
        print("Drawing a square on Mac.")
    }

    func drawCircle() {
        print("Drawing a circle on Mac.")
    }
}

// Client Code
let windowsAPI = WindowsAPI()
let macAPI = MacAPI()

let square = Square(implementation: windowsAPI)
square.draw()  // Output: Drawing a square on Windows.

let circle = Circle(implementation: macAPI)
circle.draw()  // Output: Drawing a circle on Mac.

/*
Drawing a square on Windows.
Drawing a circle on Mac.
*/