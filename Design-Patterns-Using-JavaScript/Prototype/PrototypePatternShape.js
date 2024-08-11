class Shape {
    constructor() {
        this.color = '';
    }

    toString() {
        throw new Error('toString method must be implemented');
    }

    cloneShape() {
        throw new Error('cloneShape method must be implemented');
    }

    clone() {
        return Object.assign(Object.create(Object.getPrototypeOf(this)), this);
    }
}

class Rectangle extends Shape {
    toString() {
        return 'Rectangle.';
    }

    cloneShape() {
        return this.clone();
    }
}

class Circle extends Shape {
    toString() {
        return 'Circle.';
    }

    cloneShape() {
        return this.clone();
    }
}

class ShapeRegistry {
    static addShape(key, value) {
        if(!ShapeRegistry.shapes)
        ShapeRegistry.shapes = new Map();

        ShapeRegistry.shapes.set(key, value);
    }

    static getShape(key) {
        if (ShapeRegistry.shapes.has(key)) {
            return ShapeRegistry.shapes.get(key).cloneShape();
        }
        return null;
    }

    static load() {
        ShapeRegistry.addShape('circle', new Circle());
        ShapeRegistry.addShape('rectangle', new Rectangle());
    }
}

// Client code
ShapeRegistry.load();
const c = ShapeRegistry.getShape('circle');
const r = ShapeRegistry.getShape('rectangle');
console.log(c.toString(), r.toString());

/*
Circle. Rectangle.
*/