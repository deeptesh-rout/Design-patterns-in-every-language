// Agent (Invoker)
class Agent {
    fun placeOrder(command: Order) {
        command.execute()
    }
}

// Order (Command)
abstract class Order {
    abstract fun execute()
}

// BuyStockOrder (ConcreteCommand)
class BuyStockOrder(private val stock: ReceiverStockTrade) : Order() {
    override fun execute() {
        stock.buy()
    }
}

// SellStockOrder (ConcreteCommand)
class SellStockOrder(private val stock: ReceiverStockTrade) : Order() {
    override fun execute() {
        stock.sell()
    }
}

// Receiver
class ReceiverStockTrade {
    fun buy() {
        println("Buy stocks")
    }

    fun sell() {
        println("Sell stocks")
    }
}

// Client code
fun main() {
    val trader = ReceiverStockTrade()
    val buyStock = BuyStockOrder(trader)
    val sellStock = SellStockOrder(trader)

    val agent = Agent()
    agent.placeOrder(buyStock)
    agent.placeOrder(sellStock)
}

/*
Buy stocks
Sell stocks
*/