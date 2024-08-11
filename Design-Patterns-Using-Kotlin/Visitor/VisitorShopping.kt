import kotlin.math.roundToInt

abstract class Element {
    abstract fun accept(visitor: Visitor): Double
}

class Book(val price: Double, val isbn: Int) : Element() {
    override fun accept(visitor: Visitor): Double {
        return visitor.visitBook(this)
    }
}

class Fruit(val price: Double, val quantity: Int, val type: String) : Element() {
    override fun accept(visitor: Visitor): Double {
        return visitor.visitFruit(this) * quantity
    }
}

abstract class Visitor {
    abstract fun visitBook(element: Book): Double
    abstract fun visitFruit(element: Fruit): Double
}

class SundayDiscount : Visitor() {
    override fun visitBook(element: Book): Double {
        return element.price - 50
    }

    override fun visitFruit(element: Fruit): Double {
        return element.price - 5
    }
}

class SaleDiscount : Visitor() {
    override fun visitBook(element: Book): Double {
        return element.price / 2
    }

    override fun visitFruit(element: Fruit): Double {
        return element.price / 2
    }
}

class ShoppingCart {
    private val list = mutableListOf<Element>()
    private var visitor: Visitor? = null

    fun add(element: Element) {
        list.add(element)
    }

    fun setDiscountVisitor(discount: Visitor) {
        visitor = discount
    }

    fun accept() {
        var cost = 0.0
        for (element in list) {
            cost += element.accept(visitor!!)
        }
        println("Total cost : $cost")
    }
}

// Client Code
fun main() {
    val shoppingCart = ShoppingCart()
    shoppingCart.add(Fruit(100.0, 10, "Apple"))
    shoppingCart.add(Book(100.0, 12345))

    shoppingCart.setDiscountVisitor(SundayDiscount())
    shoppingCart.accept()

    shoppingCart.setDiscountVisitor(SaleDiscount())
    shoppingCart.accept()
}

/* 
Total cost : 1000.0
Total cost : 550.0
*/