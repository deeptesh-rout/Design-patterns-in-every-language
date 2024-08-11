// Abstraction protocol
protocol Shape {
    func draw()
}

// Implementor protocol
protocol Color {
    func fill() -> String
}

// Rectangle class
class Rectangle: Shape {
    private var imp: Color

    init(imp: Color) {
        self.imp = imp
    }

    func draw() {
        print("Drawing Rectangle with color \(imp.fill())")
    }
}

// Circle class
class Circle: Shape {
    private var imp: Color

    init(imp: Color) {
        self.imp = imp
    }

    func draw() {
        print("Drawing Circle with color \(imp.fill())")
    }
}

// Red class
class Red: Color {
    func fill() -> String {
        return "Red"
    }
}

// Green class
class Green: Color {
    func fill() -> String {
        return "Green"
    }
}

// Blue class
class Blue: Color {
    func fill() -> String {
        return "Blue"
    }
}

// Client code
let c1 = Red()
let abstraction = Circle(imp: c1)
abstraction.draw()

let c2 = Green()
let abstraction2 = Rectangle(imp: c2)
abstraction2.draw()

/*
Drawing Circle with color Red
Drawing Rectangle with color Green
*/