class Product {
    private var partA: String
    private var partB: String

    init(A: String, B: String) {
        self.partA = A
        self.partB = B
    }

    var description: String {
        return "Product : (\(partA), \(partB))"
    }
}

class Builder {
    func setPartA(_ A: String) -> Self {
        fatalError("Abstract method. Subclasses must implement this method.")
    }

    func setPartB(_ B: String) -> Self {
        fatalError("Abstract method. Subclasses must implement this method.")
    }

    func getProduct() -> Product {
        fatalError("Abstract method. Subclasses must implement this method.")
    }
}

class ConcreteBuilder: Builder {
    private var partA: String = ""
    private var partB: String = ""

    override func setPartA(_ A: String) -> Self {
        self.partA = A
        return self
    }

    override func setPartB(_ B: String) -> Self {
        self.partB = B
        return self
    }

    override func getProduct() -> Product {
        return Product(A: partA, B: partB)
    }
}

class Director {
    private var builder: Builder

    init(builder: Builder) {
        self.builder = builder
    }

    func construct() -> Product {
        return builder.setPartA("A1").setPartB("B1").getProduct()
    }

    func construct2() -> Product {
        _ = builder.setPartA("A2").setPartB("B2")
        return builder.getProduct()
    }
}

// Client code
let builder = ConcreteBuilder()
let director = Director(builder: builder)

let product = director.construct()
print(product.description)

let product2 = director.construct2()
print(product2.description)

/* 
Product : (A1, B1)
Product : (A2, B2)
*/