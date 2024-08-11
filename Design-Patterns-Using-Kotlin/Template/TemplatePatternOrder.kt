abstract class OrderPackingTemplate {
    fun packProduct() { // Final
        getProduct()
        addProductToBox()
        delivery()
    }

    open fun getProduct() {
        println("Get the product from the shelf.")
    }

    open fun addProductToBox() {
        println("Put the product inside the box.")
    }

    abstract fun delivery()
}

class OnlineOrderPacking : OrderPackingTemplate() {
    override fun delivery() {
        println("Add delivery address slip and ship.")
    }
}

class StoreOrderPacking : OrderPackingTemplate() {
    override fun delivery() {
        println("Add thanks message to the box and deliver to the customer.")
    }
}

// Client code
fun main() {
    val onlineOrder = OnlineOrderPacking()
    onlineOrder.packProduct()
    println()

    val storeOrder = StoreOrderPacking()
    storeOrder.packProduct()
}

/*
Get the product from the shelf.
Put the product inside the box.
Add delivery address slip and ship.

Get the product from the shelf.
Put the product inside the box.
Add thanks message to the box and deliver to the customer.
*/