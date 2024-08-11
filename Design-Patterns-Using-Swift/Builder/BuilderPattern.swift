// Define the Product class with two parts
class Product {
    private var partA: String
    private var partB: String

    init(A: String, B: String) {
        self.partA = A
        self.partB = B
    }

    func setPartA(_ A: String) {
        self.partA = A
    }

    func setPartB(_ B: String) {
        self.partB = B
    }

    var description: String {
        return "Product : (\(partA), \(partB))"
    }
}

// Define an abstract class called Builder
class Builder {
    var product: Product

    init() {
        self.product = Product(A: "A default", B: "B default")
    }

    func setPartA(_ A: String) -> Builder {
        fatalError("Abstract method. Subclasses must implement this method.")
    }

    func setPartB(_ B: String) -> Builder {
        fatalError("Abstract method. Subclasses must implement this method.")
    }

    func getProduct() -> Product {
        let temp = self.product
        self.product = Product(A: "A default", B: "B default") // assign new product.
        return temp
    }
}

// Define a ConcreteBuilder class that extends Builder
class ConcreteBuilder: Builder {
    override func setPartA(_ A: String) -> Builder {
        self.product.setPartA(A)
        return self
    }

    override func setPartB(_ B: String) -> Builder {
        self.product.setPartB(B)
        return self
    }
}

// Define a Director class that takes a builder object as a parameter
class Director {
    private var builder: Builder

    init(builder: Builder) {
        self.builder = builder
    }

    func construct() -> Product {
        return self.builder.setPartA("A1").setPartB("B1").getProduct()
    }

    func construct2() -> Product {
        _ = self.builder.setPartA("A2").setPartB("B2")
        return self.builder.getProduct()
    }

    func construct3() -> Product {
        return self.builder.setPartA("A3").getProduct()
    }
}

// Client code
let builder = ConcreteBuilder()
let director = Director(builder: builder)

let product = director.construct()
print(product.description)

let product2 = director.construct2()
print(product2.description)

let product3 = director.construct3()
print(product3.description)

/*
Product : (A1, B1)
Product : (A2, B2)
Product : (A3, B default)
*/