// IShape interface
class IShape {
    move(x, y) {
        throw new Error("Abstract method: move");
    }

    draw() {
        throw new Error("Abstract method: draw");
    }
}

// Rectangle class
class Rectangle extends IShape {
    constructor(x, y, length, breadth) {
        super();
        this.x = x;
        this.y = y;
        this.length = length;
        this.breadth = breadth;
    }

    move(x, y) {
        this.x += x;
        this.y += y;
    }

    draw() {
        console.log(`Draw a Rectangle at (${this.x}, ${this.y}).`);
        return "<Rectangle>";
    }
}

// Circle class
class Circle extends IShape {
    constructor(x, y, radius) {
        super();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    move(x, y) {
        this.x += x;
        this.y += y;
    }

    draw() {
        console.log(`Draw a Circle of radius ${this.radius} at (${this.x}, ${this.y}).`);
        return "<Circle>";
    }
}

// CompoundShape class
class CompoundShape extends IShape {
    constructor() {
        super();
        this.children = new Set();
    }

    add(child) {
        this.children.add(child);
    }

    remove(child) {
        this.children.delete(child);
    }

    move(x, y) {
        for (const child of this.children) {
            child.move(x, y);
        }
    }

    draw() {
        let st = "Shapes(";
        for (const child of this.children) {
            st += child.draw();
        }
        st += ")";
        return st;
    }
}

// Client code
const all = new CompoundShape();
all.add(new Rectangle(1, 2, 1, 2));
all.add(new Circle(5, 3, 10));

const group = new CompoundShape();
group.add(new Rectangle(5, 7, 1, 2));
group.add(new Circle(2, 1, 2));

all.add(group);
console.log(all.draw());

/*
Draw a Rectangle at (1, 2).
Draw a Circle of radius 10 at (5, 3).
Draw a Rectangle at (5, 7).
Draw a Circle of radius 2 at (2, 1).
Shapes(<Rectangle><Circle>Shapes(<Rectangle><Circle>))
*/