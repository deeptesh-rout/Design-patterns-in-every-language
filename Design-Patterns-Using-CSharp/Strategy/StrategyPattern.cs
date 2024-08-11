using System;

interface IStrategy
{
    void Execute(int data);
}

class ConcreteStrategy1 : IStrategy
{
    public void Execute(int data)
    {
        Console.WriteLine("ConcreteStrategy1 execute");
    }
}

class ConcreteStrategy2 : IStrategy
{
    public void Execute(int data)
    {
        Console.WriteLine("ConcreteStrategy2 execute");
    }
}

class Context
{
    private IStrategy strategy;

    public Context(IStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void SetStrategy(IStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void Execute()
    {
        int data = 1;
        this.strategy.Execute(data);
    }
}

// Client code
public class StrategyPattern
{
    public static void Main(string[] args)
    {
        Context context = new Context(new ConcreteStrategy1());
        context.Execute();

        context.SetStrategy(new ConcreteStrategy2());
        context.Execute();
    }
}
