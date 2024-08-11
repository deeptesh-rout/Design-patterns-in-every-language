// Abstract ProductA
class ProductA {
    operationA() {
        console.log("ProductA operationA");
    }
}

// Concrete ProductA1
class ProductA1 extends ProductA {
    operationA() {
        console.log("ProductA1 operationA");
    }

}

// Concrete ProductA2
class ProductA2 extends ProductA {
    operationA() {
        console.log("ProductA2 operationA");
    }
}

// Abstract ProductB
class ProductB {
    operationB() {
        console.log("ProductB operationB");
    }
}

// Concrete ProductB1
class ProductB1 extends ProductB {

    operationB() {
        console.log("ProductB1 operationB");
    }
}

// Concrete ProductB2
class ProductB2 extends ProductB {
    operationB() {
        console.log("ProductB2 operationB");
    }
}

// Abstract Factory
class AbstractFactory {
    createProductA() {
        throw new Error("Abstract method: createProductA");
    }

    createProductB() {
        throw new Error("Abstract method: createProductB");
    }
}

// Concrete Factory1
class ConcreteFactory1 extends AbstractFactory {
    createProductA() {
        return new ProductA1();
    }

    createProductB() {
        return new ProductB1();
    }
}

// Concrete Factory2
class ConcreteFactory2 extends AbstractFactory {
    createProductA() {
        return new ProductA2();
    }

    createProductB() {
        return new ProductB2();
    }
}

// Client code
const factory1 = new ConcreteFactory1();
const productA1 = factory1.createProductA();
const productB1 = factory1.createProductB();
productA1.operationA();
productB1.operationB();

const factory2 = new ConcreteFactory2();
const productA2 = factory2.createProductA();
const productB2 = factory2.createProductB();
productA2.operationA();
productB2.operationB();

/*
ProductA1 operationA
ProductB operationB
ProductA1 operationA
ProductB operationB
*/