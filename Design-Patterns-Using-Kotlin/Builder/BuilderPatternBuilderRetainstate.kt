open class Product(private val partA: String, private val partB: String) {
    override fun toString(): String {
        return "Product : ($partA, $partB)"
    }
}

abstract class Builder {
    abstract fun setPartA(A: String): Builder
    abstract fun setPartB(B: String): Builder
    abstract fun getProduct(): Product
}

class ConcreteBuilder : Builder() {
    private var partA: String = "A default"
    private var partB: String = "B default"

    override fun setPartA(A: String): ConcreteBuilder {
        this.partA = A
        return this // Returning self helps in chaining calls.
    }

    override fun setPartB(B: String): ConcreteBuilder {
        this.partB = B
        return this
    }

    override fun getProduct(): Product {
        return Product(partA, partB)
    }
}

class Director(private val builder: Builder) {
    fun construct(): Product {
        return builder.setPartA("A1").setPartB("B1").getProduct() // Chaining calls
    }

    fun construct2(): Product {
        builder.setPartA("A2")
        builder.setPartB("B2")
        return builder.getProduct()
    }
}

// Client code
fun main() {
    val builder = ConcreteBuilder()
    val director = Director(builder)
    val product = director.construct()
    println(product)

    val product2 = director.construct2()
    println(product2)
}

/*
Product : (A1, B1)
Product : (A2, B2)
*/