// Abstraction abstract class
class Shape {
    constructor(imp) {
        this.imp = imp;
    }

    draw() {
        throw new Error('Method draw() must be implemented');
    }
}

// Rectangle class
class Rectangle extends Shape {
    constructor(imp) {
        super(imp);
    }

    draw() {
        console.log(`Drawing Rectangle with colour ${this.imp.fill()}`);
    }
}

// Circle class
class Circle extends Shape {
    constructor(imp) {
        super(imp);
    }

    draw() {
        console.log(`Drawing Circle with colour ${this.imp.fill()}`);
    }
}

// Colour abstract class
class Colour {
    fill() {
        throw new Error('Method fill() must be implemented');
    }
}

// Red class
class Red extends Colour {
    fill() {
        return 'Red';
    }
}

// Green class
class Green extends Colour {
    fill() {
        return 'Green';
    }
}

// Blue class
class Blue extends Colour {
    fill() {
        return 'Blue';
    }
}

// Client code
const c1 = new Red();
let abstraction = new Circle(c1);
abstraction.draw();

const c2 = new Green();
abstraction = new Rectangle(c2);
abstraction.draw();



/*
Drawing Circle with color Red
Drawing Rectangle with color Green
*/