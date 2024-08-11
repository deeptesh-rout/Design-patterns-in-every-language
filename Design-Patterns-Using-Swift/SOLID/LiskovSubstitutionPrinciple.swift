
// Animal class
class Animal {
    var name: String
    
    init(name: String) {
        self.name = name
    }
    
    func makeSound() {
        print("Animal sound")
    }
}

// Dog class
class Dog: Animal {
    override func makeSound() {
        print("woof woof!")
    }
}

// Cat class
class Cat: Animal {
    override func makeSound() {
        print("meow!")
    }
}

class Rectangle {
    private var height: Int
    private var width: Int

    init(height: Int, width: Int) {
        self.height = height
        self.width = width
    }

    func setWidth(_ width: Int) {
        self.width = width
    }

    func setHeight(_ height: Int) {
        self.height = height
    }

    func getWidth() -> Int {
        return width
    }

    func getHeight() -> Int {
        return height
    }
}

class Square: Rectangle {
    init(sideLength: Int) {
        super.init(height: sideLength, width: sideLength)
    }

    override func setWidth(_ width: Int) {
        super.setWidth(width)
        super.setHeight(width)
    }

    override func setHeight(_ height: Int) {
        super.setWidth(height)
        super.setHeight(height)
    }
}

func testRect(rect: Rectangle) {
    rect.setHeight(10)
    rect.setWidth(20)
    if 200 == rect.getHeight() * rect.getWidth() {
        print("success")
    } else {
        print("failure")
    }
}

// Client Code
let r = Rectangle(height: 10, width: 20)
testRect(rect: r)
let s = Square(sideLength: 10)
testRect(rect: s)

/*
success
failure
*/