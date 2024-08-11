// Define the Product class with two parts
open class Product(private var partA: String, private var partB: String) {
    fun setPartA(A: String) {
        this.partA = A
    }

    fun setPartB(B: String) {
        this.partB = B
    }

    override fun toString(): String {
        return String.format("Product : (%s, %s)", partA, partB)
    }
}

// Define an abstract class called Builder
abstract class Builder {
    protected var prod: Product = Product("A default", "B default")

    abstract fun setPartA(A: String): Builder

    abstract fun setPartB(B: String): Builder

    open fun getProduct(): Product {
        val temp = this.prod
        this.prod = Product("A default", "B default") // assign new product.
        return temp
    }
}

// Define a ConcreteBuilder class that extends Builder
class ConcreteBuilder : Builder() {
    override fun setPartA(A: String): Builder {
        prod.setPartA(A)
        return this
    }

    override fun setPartB(B: String): Builder {
        prod.setPartB(B)
        return this
    }
}

// Define a Director class that takes a builder object as a parameter
class Director(private val builder: Builder) {
    fun construct(): Product {
        return builder.setPartA("A1").setPartB("B1").getProduct()
    }

    fun construct2(): Product {
        builder.setPartA("A2")
        builder.setPartB("B2")
        return builder.getProduct()
    }

    fun construct3(): Product {
        return builder.setPartA("A3").getProduct()
    }
}

// Client code
fun main() {
    val builder: Builder = ConcreteBuilder()
    val director = Director(builder)

    val product = director.construct()
    println(product)

    val product2 = director.construct2()
    println(product2)

    val product3 = director.construct3()
    println(product3)
}
 
/*
Product : (A1, B1)
Product : (A2, B2)
Product : (A3, B default)
 */

