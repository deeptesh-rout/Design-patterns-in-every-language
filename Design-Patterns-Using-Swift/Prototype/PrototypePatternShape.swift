import Foundation

protocol Shape {
    var color: String { get set }
    func clone() -> Shape
    func description() -> String
}

class Rectangle: Shape {
    var color: String = ""

    required init(color: String) {
        self.color = color
    }

    func clone() -> Shape {
        return type(of: self).init(color: color)
    }

    func description() -> String {
        return "Rectangle."
    }
}

class Circle: Shape {
    var color: String = ""

    required init(color: String) {
        self.color = color
    }

    func clone() -> Shape {
        return type(of: self).init(color: color)
    }

    func description() -> String {
        return "Circle."
    }
}

class ShapeRegistry {
    private static var shapes: [String: Shape] = [:]

    static func addShape(key: String, value: Shape) {
        shapes[key] = value
    }

    static func getShape(key: String) -> Shape? {
        return shapes[key]?.clone()
    }

    static func load() {
        addShape(key: "circle", value: Circle(color:"Red"))
        addShape(key: "rectangle", value: Rectangle(color:"Red"))
    }
}

// Client code
ShapeRegistry.load()
let c = ShapeRegistry.getShape(key: "circle")
let r = ShapeRegistry.getShape(key: "rectangle")
print("\(c!.description()) \(r!.description())")

/*
Circle. Rectangle.
*/