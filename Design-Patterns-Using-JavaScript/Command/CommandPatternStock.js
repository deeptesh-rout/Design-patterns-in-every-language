// Agent (Invoker)
class Agent {
    placeOrder(command) {
        command.execute();
    }
}

// Order (Command)
class Order {
    execute() {
        throw new Error("Abstract method: execute");
    }
}

// BuyStockOrder (ConcreteCommand)
class BuyStockOrder extends Order {
    constructor(stock) {
        super();
        this.stock = stock;
    }

    execute() {
        this.stock.buy();
    }
}

// SellStockOrder (ConcreteCommand)
class SellStockOrder extends Order {
    constructor(stock) {
        super();
        this.stock = stock;
    }

    execute() {
        this.stock.sell();
    }
}

// Receiver
class ReceiverStockTrade {
    buy() {
        console.log("Buy stocks");
    }

    sell() {
        console.log("Sell stocks");
    }
}

// Client code
const trader = new ReceiverStockTrade();
const buyStock = new BuyStockOrder(trader);
const sellStock = new SellStockOrder(trader);

const agent = new Agent();
agent.placeOrder(buyStock);
agent.placeOrder(sellStock);

/*
Buy stocks
Sell stocks
*/