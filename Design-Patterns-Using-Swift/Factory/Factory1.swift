// Product protocol
protocol Product {
    func operation()
}

// Concrete Product classes
class ConcreteProduct1: Product {
    func operation() {
        print("Concrete Product1 Operation!")
    }
}

class ConcreteProduct2: Product {
    func operation() {
        print("Concrete Product2 Operation!")
    }
}

// Creator protocol
protocol Factory {
    func createProduct() -> Product
}

// Concrete Creator classes
class ConcreteFactory1: Factory {
    func createProduct() -> Product {
        return ConcreteProduct1()
    }
}

class ConcreteFactory2: Factory {
    func createProduct() -> Product {
        return ConcreteProduct2()
    }
}

// Client code
let factory1: Factory = ConcreteFactory1()
let product1 = factory1.createProduct()
product1.operation()

let factory2: Factory = ConcreteFactory2()
let product2 = factory2.createProduct()
product2.operation()

/*
Concrete Product1 Operation!
Concrete Product2 Operation!
*/