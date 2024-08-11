import java.util.ArrayList

// Data Access Layer
class DataAccessLayer {
    private val products: MutableList<String> = ArrayList()

    fun getData(): List<String> {
        return products
    }

    fun addData(product: String) {
        products.add(product)
    }
}

// Business Logic Layer
class BusinessLogicLayer(private val dataAccess: DataAccessLayer) {
    fun getAllProducts(): List<String> {
        return dataAccess.getData()
    }

    fun addProduct(product: String) {
        dataAccess.addData(product)
    }
}

// Presentation Layer
class PresentationLayer(private val businessLogic: BusinessLogicLayer) {
    fun displayProducts() {
        val products = businessLogic.getAllProducts()
        products.forEachIndexed { index, product ->
            println("${index + 1}. $product")
        }
    }

    fun addProduct(product: String) {
        businessLogic.addProduct(product)
    }
}

// Client code.
fun main() {
    val dataAccess = DataAccessLayer()
    val businessLogic = BusinessLogicLayer(dataAccess)
    val presentationLayer = PresentationLayer(businessLogic)

    presentationLayer.addProduct("Apple")
    presentationLayer.addProduct("Banana")
    presentationLayer.addProduct("Mango")
    presentationLayer.displayProducts()
}


/*
1. Apple
2. Banana
3. Mango
*/