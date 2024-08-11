// Define the Product class with two parts
class Product {
    constructor(A = "A default", B = "B default") {
        this.partA = A;
        this.partB = B;
    }

    setPartA(A) {
        this.partA = A;
    }

    setPartB(B) {
        this.partB = B;
    }

    toString() {
        return `Product : (${this.partA}, ${this.partB})`;
    }
}

// Define an abstract class called Builder
class Builder {
    constructor() {
        this.product = new Product();
    }

    setPartA(A) {
        throw new Error("Abstract method: setPartA");
    }

    setPartB(B) {
        throw new Error("Abstract method: setPartB");
    }

    getProduct() {
        const temp = this.product;
        this.product = new Product(); // assign new product.
        return temp;
    }
}

// Define a ConcreteBuilder class that extends Builder
class ConcreteBuilder extends Builder {
    setPartA(A) {
        this.product.setPartA(A);
        return this;
    }

    setPartB(B) {
        this.product.setPartB(B);
        return this;
    }
}

// Define a Director class that takes a builder object as a parameter
class Director {
    constructor(builder) {
        this.builder = builder;
    }

    construct() {
        return this.builder.setPartA("A1").setPartB("B1").getProduct();
    }

    construct2() {
        this.builder.setPartA("A2");
        this.builder.setPartB("B2");
        return this.builder.getProduct();
    }

    construct3() {
        return this.builder.setPartA("A3").getProduct();
    }
}

// Client code
const builder = new ConcreteBuilder();
const director = new Director(builder);

const product = director.construct();
console.log(product.toString());

const product2 = director.construct2();
console.log(product2.toString());

const product3 = director.construct3();
console.log(product3.toString());

/*
Product : (A1, B1)
Product : (A2, B2)
Product : (A3, B default)
*/