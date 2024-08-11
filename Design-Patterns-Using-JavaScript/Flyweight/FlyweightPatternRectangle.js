// Shape interface
class Shape {
    draw(x1, y1, x2, y2) {
        //Common operation logic
    }
}

// ColouredShape class implementing Shape
class ColouredShape extends Shape {
    constructor(color) {
        super();
        this.color = color;
    }

    draw(x1, y1, x2, y2) {
        console.log(`Draw ColouredShape color: ${this.color}, topleft: (${x1},${y1}), rightBottom: (${x2},${y2})`);
    }
}

// ColouredShapeFactory class
class ColouredShapeFactory {
    constructor() {
        this.shapes = {};
    }

    getColouredShape(color) {
        if (!this.shapes[color]) {
            this.shapes[color] = new ColouredShape(color);
            console.log("Creating a new ColouredShape with color: " + color);
        } else {
            console.log("Reusing existing ColouredShape with color: " + color);
        }
        return this.shapes[color];
    }

    getCount() {
        return Object.keys(this.shapes).length;
    }
}

// Client code
const factory = new ColouredShapeFactory();
const random = () => Math.floor(Math.random() * 100);

for (let i = 0; i < 100; i++) {
    // Generate a random color for the ColouredShape
    const randomColor = random().toString();

    // Obtain a ColouredShape with the specified color
    const ColouredShape = factory.getColouredShape(randomColor);

    // Generate random coordinates for drawing the ColouredShape
    const x1 = random();
    const y1 = random();
    const x2 = random();
    const y2 = random();

    // Draw the ColouredShape
    ColouredShape.draw(x1, y1, x2, y2);
}

// Display the total number of unique ColouredShapes created
console.log("Total unique ColouredShapes created: " + factory.getCount());
