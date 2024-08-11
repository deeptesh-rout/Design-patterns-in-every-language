// Agent (Invoker)
class Agent {
    public void placeOrder(Order command) {
        command.execute();
    }
}

// Order (Command)
abstract class Order {
    public abstract void execute();
}

// BuyStockOrder (ConcreteCommand)
class BuyStockOrder extends Order {
    private ReceiverStockTrade stock;

    public BuyStockOrder(ReceiverStockTrade stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

// SellStockOrder (ConcreteCommand)
class SellStockOrder extends Order {
    private ReceiverStockTrade stock;

    public SellStockOrder(ReceiverStockTrade stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}

// Receiver
class ReceiverStockTrade {
    public void buy() {
        System.out.println("Buy stocks");
    }

    public void sell() {
        System.out.println("Sell stocks");
    }
}

// Client code
public class CommandPatternStock {
    public static void main(String[] args) {
        ReceiverStockTrade trader = new ReceiverStockTrade();
        BuyStockOrder buyStock = new BuyStockOrder(trader);
        SellStockOrder sellStock = new SellStockOrder(trader);

        Agent agent = new Agent();
        agent.placeOrder(buyStock);
        agent.placeOrder(sellStock);
    }
}

/* 
Buy stocks
Sell stocks 
*/
