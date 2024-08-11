import Foundation

// Shape abstract class
class Shape {
    var colour: Int // Intrinsic State

    init(colour: Int) {
        self.colour = colour
    }

    func draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        fatalError("Subclasses must override the draw method")
    }
}

// Rectangle class
class Rectangle: Shape {
    override func draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        //print("Draw Rectangle colour: \(colour) topleft: (\(x1),\(y1)) rightBottom: (\(x2),\(y2))")
    }
}

// RectangleFactory class
class RectangleFactory {
    private var shapes: [Int: Shape] = [:]

    func getRectangle(colour: Int) -> Shape {
        if shapes[colour] == nil {
            shapes[colour] = Rectangle(colour: colour)
        }
        return shapes[colour]!
    }

    var count: Int {
        return shapes.count
    }
}

// Client code
let factory = RectangleFactory()

for _ in 0..<1000 {
    let rect = factory.getRectangle(colour: Int.random(in: 0..<1000))
    rect.draw(x1: Int.random(in: 0..<100), y1: Int.random(in: 0..<100), x2: Int.random(in: 0..<100), y2: Int.random(in: 0..<100))
}
print(factory.count)

