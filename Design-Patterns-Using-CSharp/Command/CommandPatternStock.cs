using System;

// Agent (Invoker)
class Agent
{
    public void PlaceOrder(Order command)
    {
        command.Execute();
    }
}

// Order (Command)
abstract class Order
{
    public abstract void Execute();
}

// BuyStockOrder (ConcreteCommand)
class BuyStockOrder : Order
{
    private ReceiverStockTrade stock;

    public BuyStockOrder(ReceiverStockTrade stock)
    {
        this.stock = stock;
    }

    public override void Execute()
    {
        stock.Buy();
    }
}

// SellStockOrder (ConcreteCommand)
class SellStockOrder : Order
{
    private ReceiverStockTrade stock;

    public SellStockOrder(ReceiverStockTrade stock)
    {
        this.stock = stock;
    }

    public override void Execute()
    {
        stock.Sell();
    }
}

// Receiver
class ReceiverStockTrade
{
    public void Buy()
    {
        Console.WriteLine("Buy stocks");
    }

    public void Sell()
    {
        Console.WriteLine("Sell stocks");
    }
}

// Client code
class CommandPatternStock
{
    static void Main(string[] args)
    {
        ReceiverStockTrade trader = new ReceiverStockTrade();
        BuyStockOrder buyStock = new BuyStockOrder(trader);
        SellStockOrder sellStock = new SellStockOrder(trader);

        Agent agent = new Agent();
        agent.PlaceOrder(buyStock);
        agent.PlaceOrder(sellStock);
    }
}

/*
Buy stocks
Sell stocks
*/