// Product interface
interface Product {
    fun operation()
}

// Concrete Product classes
class ConcreteProduct1 : Product {
    override fun operation() {
        println("Concrete Product1 Operation!")
    }
}

class ConcreteProduct2 : Product {
    override fun operation() {
        println("Concrete Product2 Operation!")
    }
}

// Creator abstract class
abstract class Factory {
    abstract fun createProduct(): Product
}

// Concrete Creator classes
class ConcreteFactory1 : Factory() {
    override fun createProduct(): Product {
        return ConcreteProduct1()
    }
}

// Concrete Creator classes
class ConcreteFactory2 : Factory() {
    override fun createProduct(): Product {
        return ConcreteProduct2()
    }
}

// Client code
fun main() {
    val factory1: Factory = ConcreteFactory1()
    val product1: Product = factory1.createProduct()
    product1.operation()

    val factory2: Factory = ConcreteFactory2()
    val product2: Product = factory2.createProduct()
    product2.operation()
}

/* 
Concrete Product1 Operation!
Concrete Product2 Operation!
*/