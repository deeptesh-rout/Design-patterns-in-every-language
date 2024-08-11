
// ProductA interface
interface ProductA {
    fun operationA()
}

// Concrete ProductA1
class ProductA1 : ProductA {
    override fun operationA() {
        println("ProductA1 operationA")
    }
}

// Concrete ProductA2
class ProductA2 : ProductA {
    override fun operationA() {
        println("ProductA2 operationA")
    }
}

// Abstract ProductB
interface ProductB {
    fun operationB()
}

// Concrete ProductB1
class ProductB1 : ProductB {
    override fun operationB() {
        println("ProductB1 operationB")
    }
}

// Concrete ProductB2
class ProductB2 : ProductB {
    override fun operationB() {
        println("ProductB2 operationB")
    }
}

// Abstract Factory
interface AbstractFactory {
    fun createProductA(): ProductA
    fun createProductB(): ProductB
}

// Concrete Factory1
class ConcreteFactory1 : AbstractFactory {
    override fun createProductA(): ProductA {
        return ProductA1()
    }

    override fun createProductB(): ProductB {
        return ProductB1()
    }
}

// Concrete Factory2
class ConcreteFactory2 : AbstractFactory {
    override fun createProductA(): ProductA {
        return ProductA2()
    }

    override fun createProductB(): ProductB {
        return ProductB2()
    }
}

// Client code
fun main() {
    val factory1: AbstractFactory = ConcreteFactory1()
    val productA1: ProductA = factory1.createProductA()
    val productB1: ProductB = factory1.createProductB()
    productA1.operationA()
    productB1.operationB()

    val factory2: AbstractFactory = ConcreteFactory2()
    val productA2: ProductA = factory2.createProductA()
    val productB2: ProductB = factory2.createProductB()
    productA2.operationA()
    productB2.operationB()
}

/*
ProductA1 operationA
ProductB1 operationB
ProductA2 operationA
ProductB2 operationB
*/