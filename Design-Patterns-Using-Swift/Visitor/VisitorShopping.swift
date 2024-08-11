import Foundation

// Element protocol
protocol Element {
    func accept(visitor: Visitor) -> Double
    func price() -> Double
}

// Book class conforming to Element protocol
class Book: Element {
    private var _price: Double
    private var isbn: Int

    init(price: Double, isbn: Int) {
        self._price = price
        self.isbn = isbn
    }

    func price() -> Double {
        return _price
    }

    func accept(visitor: Visitor) -> Double {
        return visitor.visit(book: self)
    }
}

// Fruit class conforming to Element protocol
class Fruit: Element {
    private var _price: Double
    private var quantity: Int
    private var type: String

    init(price: Double, quantity: Int, type: String) {
        self._price = price
        self.quantity = quantity
        self.type = type
    }

    func price() -> Double {
        return _price
    }

    func accept(visitor: Visitor) -> Double {
        return visitor.visit(fruit: self) * Double(quantity)
    }
}

// Visitor protocol
protocol Visitor {
    func visit(book: Book) -> Double
    func visit(fruit: Fruit) -> Double
}

// SundayDiscount class conforming to Visitor protocol
class SundayDiscount: Visitor {
    func visit(book: Book) -> Double {
        return book.price() - 50
    }

    func visit(fruit: Fruit) -> Double {
        return fruit.price() - 5
    }
}

// SaleDiscount class conforming to Visitor protocol
class SaleDiscount: Visitor {
    func visit(book: Book) -> Double {
        return book.price() / 2
    }

    func visit(fruit: Fruit) -> Double {
        return fruit.price() / 2
    }
}

// ShoppingCart class
class ShoppingCart {
    private var list: [Element] = []
    private var visitor: Visitor?

    func add(element: Element) {
        list.append(element)
    }

    func setDiscountVisitor(discount: Visitor) {
        self.visitor = discount
    }

    func accept() {
        guard let visitor = visitor else {
            print("No discount visitor set.")
            return
        }

        var cost: Double = 0
        for element in list {
            cost += element.accept(visitor: visitor)
        }
        print("Total cost: \(cost)")
    }
}

// Client code.
let cart = ShoppingCart()
cart.add(element: Fruit(price: 100, quantity: 10, type: "Apple"))
cart.add(element: Book(price: 100, isbn: 12345))

cart.setDiscountVisitor(discount: SundayDiscount())
cart.accept()

cart.setDiscountVisitor(discount: SaleDiscount())
cart.accept()

/*
Total cost: 1000.0
Total cost: 550.0
*/
