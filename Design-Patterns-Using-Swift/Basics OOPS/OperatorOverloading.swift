import Foundation

class Rectangle {
    private var length: Double
    private var breadth: Double

    init(length: Double, breadth: Double) {
        self.length = length
        self.breadth = breadth
    }

    func area() -> Double {
        return length * breadth
    }

    func perimeter() -> Double {
        return 2 * (length + breadth)
    }

    // Overloading + operator
    func add(_ rec: Rectangle) -> Rectangle {
        return Rectangle(length: self.length + rec.length, breadth: self.breadth + rec.breadth)
    }

    // Overloading - operator
    func subtract(_ rec: Rectangle) -> Rectangle {
        return Rectangle(length: abs(self.length - rec.length), breadth: abs(self.breadth - rec.breadth))
    }

    // Overloading == operator
    static func == (lhs: Rectangle, rhs: Rectangle) -> Bool {
        return lhs.length == rhs.length && lhs.breadth == rhs.breadth
    }

    // Overriding description property
    var description: String {
        return "Rectangle length and width: \(length) \(breadth)"
    }
}

let r1 = Rectangle(length: 4, breadth: 6)
let r2 = Rectangle(length: 10, breadth: 6)

print("Is r1 == r2 ? \(r1 == r2)")

let r3 = r1.add(r2)
let r4 = r1.subtract(r2)

print(r1.description)
print(r2.description)
print(r3.description)
print(r4.description)
