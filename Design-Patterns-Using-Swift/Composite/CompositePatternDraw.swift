// IShape protocol
class IShape: Hashable {
    func move(x: Int, y: Int){
        fatalError("Operation must be overridden by subclasses")
    }

    func draw() -> String{
        fatalError("Operation must be overridden by subclasses")
    }

    static func == (lhs: IShape, rhs: IShape) -> Bool {
        return ObjectIdentifier(lhs) == ObjectIdentifier(rhs)
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(ObjectIdentifier(self))
    }
}

// Rectangle class
class Rectangle: IShape {
    private var x, y, length, breadth: Int

    init(x: Int, y: Int, length: Int, breadth: Int) {
        self.x = x
        self.y = y
        self.length = length
        self.breadth = breadth
    }

    override func move(x: Int, y: Int) {
        self.x += x
        self.y += y
    }

    override func draw() -> String {
        print("Draw a Rectangle at (\(x), \(y)).")
        return "<Rectangle>"
    }

    static func ==(lhs: Rectangle, rhs: Rectangle) -> Bool {
        return lhs.x == rhs.x && lhs.y == rhs.y && lhs.length == rhs.length && lhs.breadth == rhs.breadth
    }

    override func hash(into hasher: inout Hasher) {
        hasher.combine(x)
        hasher.combine(y)
        hasher.combine(length)
        hasher.combine(breadth)
    }
}

// Circle class
class Circle: IShape {
    private var x, y, radius: Int

    init(x: Int, y: Int, radius: Int) {
        self.x = x
        self.y = y
        self.radius = radius
    }

    override func move(x: Int, y: Int) {
        self.x += x
        self.y += y
    }

    override func draw() -> String {
        print( "Draw a Circle of radius \(radius) at (\(x), \(y)).")
        return "<Circle>"
    }

    static func ==(lhs: Circle, rhs: Circle) -> Bool {
        return lhs.x == rhs.x && lhs.y == rhs.y && lhs.radius == rhs.radius
    }

    override func hash(into hasher: inout Hasher) {
        hasher.combine(x)
        hasher.combine(y)
        hasher.combine(radius)
    }
}

// CompoundShape class
class CompoundShape: IShape {
    private var children = Set<IShape>()

    func add(_ child: IShape) {
        children.insert(child)
    }

    func remove(_ child: IShape) {
        children.remove(child)
    }

    override func move(x: Int, y: Int) {
        for child in children {
            child.move(x: x, y: y)
        }
    }

    override func draw() -> String {
        var result = "Shapes("
        for child in children {
            result += child.draw()
        }
        result += ")"
        return result
    }

    static func ==(lhs: CompoundShape, rhs: CompoundShape) -> Bool {
        return lhs.children == rhs.children
    }

    override func hash(into hasher: inout Hasher) {
        hasher.combine(children)
    }
}

// Client code
let all = CompoundShape()
all.add(Rectangle(x: 1, y: 2, length: 1, breadth: 2))
all.add(Circle(x: 5, y: 3, radius: 10))

let group = CompoundShape()
group.add(Rectangle(x: 5, y: 7, length: 1, breadth: 2))
group.add(Circle(x: 2, y: 1, radius: 2))

all.add(group)
print(all.draw())

/*
Draw a Circle of radius 10 at (5, 3).
Draw a Rectangle at (5, 7).
Draw a Circle of radius 2 at (2, 1).
Draw a Rectangle at (1, 2).
Shapes(<Circle>Shapes(<Rectangle><Circle>)<Rectangle>)
*/