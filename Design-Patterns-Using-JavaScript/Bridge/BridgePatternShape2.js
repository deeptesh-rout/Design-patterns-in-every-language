// Abstraction
class Shape {
    constructor(implementation) {
        this.implementation = implementation;
    }

    draw() {
        throw new Error("Abstract method: draw");
    }
}

// Concrete Abstraction
class Square extends Shape {
    constructor(implementation) {
        super(implementation);
    }

    draw() {
        this.implementation.drawSquare();
    }
}

class Circle extends Shape {
    constructor(implementation) {
        super(implementation);
    }

    draw() {
        this.implementation.drawCircle();
    }
}

// Implementation
class DrawingAPI {
    drawSquare() {
        throw new Error("Abstract method: drawSquare");
    }

    drawCircle() {
        throw new Error("Abstract method: drawCircle");
    }
}

// Concrete Implementation
class WindowsAPI extends DrawingAPI {
    drawSquare() {
        console.log("Drawing a square on Windows.");
    }

    drawCircle() {
        console.log("Drawing a circle on Windows.");
    }
}

class MacAPI extends DrawingAPI {
    drawSquare() {
        console.log("Drawing a square on Mac.");
    }

    drawCircle() {
        console.log("Drawing a circle on Mac.");
    }
}

// Client code
const windowsAPI = new WindowsAPI();
const macAPI = new MacAPI();

const square = new Square(windowsAPI);
square.draw();  // Output: Drawing a square on Windows.

const circle = new Circle(macAPI);
circle.draw();  // Output: Drawing a circle on Mac.

/*
Drawing a square on Windows.
Drawing a circle on Mac.
*/