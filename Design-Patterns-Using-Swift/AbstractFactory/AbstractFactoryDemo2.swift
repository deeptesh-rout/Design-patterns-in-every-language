// Abstract ProductA
protocol ProductA {
    func operationA()
}

// Concrete ProductA1
class ProductA1: ProductA {
    func operationA() {
        print("ProductA1 operationA")
    }
}

// Concrete ProductA2
class ProductA2: ProductA {
    func operationA() {
        print("ProductA2 operationA")
    }
}

// Abstract ProductB
protocol ProductB {
    func operationB()
}

// Concrete ProductB1
class ProductB1: ProductB {
    func operationB() {
        print("ProductB1 operationB")
    }
}

// Concrete ProductB2
class ProductB2: ProductB {
    func operationB() {
        print("ProductB2 operationB")
    }
}

// Abstract Factory
protocol AbstractFactory {
    func createProductA() -> ProductA
    func createProductB() -> ProductB
}

// Concrete Factory1
class ConcreteFactory1: AbstractFactory {
    func createProductA() -> ProductA {
        return ProductA1()
    }

    func createProductB() -> ProductB {
        return ProductB1()
    }
}

// Concrete Factory2
class ConcreteFactory2: AbstractFactory {
    func createProductA() -> ProductA {
        return ProductA2()
    }

    func createProductB() -> ProductB {
        return ProductB2()
    }
}

// Client code
let factory1: AbstractFactory = ConcreteFactory1()
let productA1 = factory1.createProductA()
let productB1 = factory1.createProductB()
productA1.operationA()
productB1.operationB()

let factory2: AbstractFactory = ConcreteFactory2()
let productA2 = factory2.createProductA()
let productB2 = factory2.createProductB()
productA2.operationA()
productB2.operationB()

/*
ProductA1 operationA
ProductB1 operationB
ProductA2 operationA
ProductB2 operationB
*/
