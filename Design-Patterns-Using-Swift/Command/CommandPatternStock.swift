// Agent (Invoker)
class Agent {
    func placeOrder(command: Order) {
        command.execute()
    }
}

// Order (Command)
protocol Order {
    func execute()
}

// BuyStockOrder (ConcreteCommand)
class BuyStockOrder: Order {
    private let stock: ReceiverStockTrade

    init(stock: ReceiverStockTrade) {
        self.stock = stock
    }

    func execute() {
        stock.buy()
    }
}

// SellStockOrder (ConcreteCommand)
class SellStockOrder: Order {
    private let stock: ReceiverStockTrade

    init(stock: ReceiverStockTrade) {
        self.stock = stock
    }

    func execute() {
        stock.sell()
    }
}

// Receiver
class ReceiverStockTrade {
    func buy() {
        print("Buy stocks")
    }

    func sell() {
        print("Sell stocks")
    }
}

// Client Code
let trader = ReceiverStockTrade()
let buyStock = BuyStockOrder(stock: trader)
let sellStock = SellStockOrder(stock: trader)

let agent = Agent()
agent.placeOrder(command: buyStock)
agent.placeOrder(command: sellStock)

/*
Buy stocks
Sell stocks
*/