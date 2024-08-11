protocol Visitor {
    func visit(circle: Circle)
    func visit(rectangle: Rectangle)
}

protocol Shape {
    func accept(visitor: Visitor)
}

class Circle: Shape {
    let x: Int
    let y: Int
    let radius: Int

    init(x: Int, y: Int, radius: Int) {
        self.x = x
        self.y = y
        self.radius = radius
    }

    func accept(visitor: Visitor) {
        visitor.visit(circle: self)
    }
}

class Rectangle: Shape {
    let x: Int
    let y: Int
    let width: Int
    let height: Int

    init(x: Int, y: Int, width: Int, height: Int) {
        self.x = x
        self.y = y
        self.width = width
        self.height = height
    }

    func accept(visitor: Visitor) {
        visitor.visit(rectangle: self)
    }
}

class XMLVisitor: Visitor {
    func visit(circle: Circle) {
        print("<circle>\n  <x>\(circle.x)</x>\n  <y>\(circle.y)</y>\n  <radius>\(circle.radius)</radius>\n</circle>")
    }

    func visit(rectangle: Rectangle) {
        print("<rectangle>\n  <x>\(rectangle.x)</x>\n  <y>\(rectangle.y)</y>\n  <width>\(rectangle.width)</width>\n  <height>\(rectangle.height)</height>\n</rectangle>")
    }
}

class TextVisitor: Visitor {
    func visit(circle: Circle) {
        print("Circle ( (x : \(circle.x), y : \(circle.y)), radius : \(circle.radius))")
    }

    func visit(rectangle: Rectangle) {
        print("Rectangle ( (x : \(rectangle.x), y : \(rectangle.y)), width : \(rectangle.width), height : \(rectangle.height))")
    }
}

class ObjectsStructure {
    private var shapes: [Shape] = []

    func addShape(_ shape: Shape) {
        shapes.append(shape)
    }

    func accept(visitor: Visitor) {
        for shape in shapes {
            shape.accept(visitor: visitor)
        }
    }
}

// Client code.
let os = ObjectsStructure()
os.addShape(Rectangle(x: 6, y: 7, width: 8, height: 9))
os.addShape(Circle(x: 6, y: 7, radius: 8))

os.accept(visitor: XMLVisitor())
os.accept(visitor: TextVisitor())

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