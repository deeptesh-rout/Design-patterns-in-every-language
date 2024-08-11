// Define Shape class
class Shape {
    accept(visitor) {
        throw new Error("accept method must be implemented");
    }
}

// Define Circle class extending Shape
class Circle extends Shape {
    constructor(x, y, radius) {
        super();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    accept(visitor) {
        visitor.visitCircle(this);
    }

    getX() {
        return this.x;
    }

    getY() {
        return this.y;
    }

    getRadius() {
        return this.radius;
    }
}

// Define Rectangle class extending Shape
class Rectangle extends Shape {
    constructor(x, y, width, height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    accept(visitor) {
        visitor.visitRectangle(this);
    }

    getX() {
        return this.x;
    }

    getY() {
        return this.y;
    }

    getWidth() {
        return this.width;
    }

    getHeight() {
        return this.height;
    }
}

// Define Visitor class
class Visitor {
    visitCircle(circle) {
        throw new Error("visitCircle method must be implemented");
    }

    visitRectangle(rectangle) {
        throw new Error("visitRectangle method must be implemented");
    }
}

// Define XMLVisitor class extending Visitor
class XMLVisitor extends Visitor {
    visitCircle(circle) {
        console.log(`<circle>\n  <x>${circle.getX()}</x>\n  <y>${circle.getY()}</y>\n  <radius>${circle.getRadius()}</radius>\n</circle>`);
    }

    visitRectangle(rectangle) {
        console.log(`<rectangle>\n  <x>${rectangle.getX()}</x>\n  <y>${rectangle.getY()}</y>\n  <width>${rectangle.getWidth()}</width>\n  <height>${rectangle.getHeight()}</height>\n</rectangle>`);
    }
}

// Define TextVisitor class extending Visitor
class TextVisitor extends Visitor {
    visitCircle(circle) {
        console.log(`Circle ( (x : ${circle.getX()}, y : ${circle.getY()}), radius : ${circle.getRadius()})`);
    }

    visitRectangle(rectangle) {
        console.log(`Rectangle ( (x : ${rectangle.getX()}, y : ${rectangle.getY()}), width : ${rectangle.getWidth()}, height : ${rectangle.getHeight()})`);
    }
}

// Define ObjectsStructure class
class ObjectsStructure {
    constructor() {
        this.shapes = [];
        this.visitor = null;
    }

    addShape(shape) {
        this.shapes.push(shape);
    }

    setVisitor(visitor) {
        this.visitor = visitor;
    }

    accept() {
        for (const shape of this.shapes) {
            shape.accept(this.visitor);
        }
    }
}

// Client code
const os = new ObjectsStructure();
os.addShape(new Rectangle(6, 7, 8, 9));
os.addShape(new Circle(6, 7, 8));

os.setVisitor(new XMLVisitor());
os.accept();

os.setVisitor(new TextVisitor());
os.accept();

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