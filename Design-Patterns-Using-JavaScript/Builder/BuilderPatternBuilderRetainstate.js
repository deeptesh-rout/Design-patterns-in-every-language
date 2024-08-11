class Product {
    constructor(A, B) {
        this.partA = A;
        this.partB = B;
    }

    toString() {
        return `Product : (${this.partA}, ${this.partB})`;
    }
}

class Builder {
    setPartA(A) {
        throw new Error("Abstract method: setPartA");
    }

    setPartB(B) {
        throw new Error("Abstract method: setPartB");
    }

    getProduct() {
        throw new Error("Abstract method: getProduct");
    }
}

class ConcreteBuilder extends Builder {
    constructor() {
        super();
        this.partA = "";
        this.partB = "";
    }

    setPartA(A) {
        this.partA = A;
        return this; // Returning self helps in chaining calls.
    }

    setPartB(B) {
        this.partB = B;
        return this;
    }

    getProduct() {
        return new Product(this.partA, this.partB);
    }
}

class Director {
    constructor(builder) {
        this.builder = builder;
    }

    construct() {
        return this.builder.setPartA("A1").setPartB("B1").getProduct(); // Chaining calls
    }

    construct2() {
        this.builder.setPartA("A2");
        this.builder.setPartB("B2");
        return this.builder.getProduct();
    }
}

// Client code
const builder = new ConcreteBuilder();
const director = new Director(builder);

const product = director.construct();
console.log(product.toString());

const product2 = director.construct2();
console.log(product2.toString());

/*
Product : (A1, B1)
Product : (A2, B2)
*/