// Desired Interface
class Shape {
    draw() {
        throw new Error("Abstract method: draw");
    }
}

// Circle class
class Circle extends Shape {
    constructor(x, y, radius) {
        super();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    draw() {
        console.log("Draw the Circle.");
    }
}

// Rectangle class (Adaptee)
class Rectangle {
    constructor(x, y, length, width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    oldDraw() {
        console.log("Drawing Rectangle.");
    }
}

// RectangleAdapter class
class RectangleAdapter extends Shape {
    constructor(x, y, length, width) {
        super();
        this.adaptee = new Rectangle(x, y, length, width);
    }

    draw() {
        this.adaptee.oldDraw();
    }
}

// Client Code
const adapter = new RectangleAdapter(1, 2, 3, 4);
adapter.draw();

/*
Drawing Rectangle.
*/