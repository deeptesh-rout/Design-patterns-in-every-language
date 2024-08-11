// Product interface
class Product {
    operation() {
        throw new Error("Abstract method 'operation' must be implemented.");
    }
}

// Concrete Product classes
class ConcreteProduct1 extends Product {
    operation() {
        console.log("Concrete Product1 Operation!");
    }
}

class ConcreteProduct2 extends Product {
    operation() {
        console.log("Concrete Product2 Operation!");
    }
}

// Creator abstract class
class Factory {
    createProduct() {
        throw new Error("Abstract method 'createProduct' must be implemented.");
    }
}

// Concrete Creator classes
class ConcreteFactory1 extends Factory {
    createProduct() {
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 extends Factory {
    createProduct() {
        return new ConcreteProduct2();
    }
}

// Client code
const factory1 = new ConcreteFactory1();
const product1 = factory1.createProduct();
product1.operation();

const factory2 = new ConcreteFactory2();
const product2 = factory2.createProduct();
product2.operation();

/* 
Concrete Product1 Operation!
Concrete Product2 Operation!
*/
