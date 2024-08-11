class Rectangle {
    constructor(length, breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    area() {
        return this.length * this.breadth;
    }

    perimeter() {
        return 2 * (this.length + this.breadth);
    }

    // Overloading + operator
    add(rectangle) {
        return new Rectangle(this.length + rectangle.length, this.breadth + rectangle.breadth);
    }

    // Overloading - operator
    subtract(rectangle) {
        return new Rectangle(Math.abs(this.length - rectangle.length), Math.abs(this.breadth - rectangle.breadth));
    }

    // Overloading == operator
    equals(rectangle) {
        return this.length === rectangle.length && this.breadth === rectangle.breadth;
    }

    // Overriding toString method
    toString() {
        return `Rectangle length and width: ${this.length} ${this.breadth}`;
    }
}

// Client code
const r1 = new Rectangle(4, 6);
const r2 = new Rectangle(10, 6);

console.log(`Is r1 == r2 ? ${r1.equals(r2)}`);

const r3 = r1.add(r2);
const r4 = r1.subtract(r2);

console.log(r1.toString());
console.log(r2.toString());
console.log(r3.toString());
console.log(r4.toString());

/*
Is r1 == r2 ? false
Rectangle length and width: 4 6
Rectangle length and width: 10 6
Rectangle length and width: 14 12
Rectangle length and width: 6 0
*/