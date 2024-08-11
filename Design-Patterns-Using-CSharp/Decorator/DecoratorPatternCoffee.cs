using System;

// Coffee (Component)
interface ICoffee
{
    int GetCost();
    string GetIngredients();
}

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee : ICoffee
{
    public int GetCost()
    {
        return 10;
    }

    public string GetIngredients()
    {
        return "Coffee";
    }
}

// CoffeeDecorator (Decorator)
abstract class CoffeeDecorator : ICoffee
{
    protected ICoffee Component;

    public CoffeeDecorator(ICoffee component)
    {
        Component = component ?? throw new ArgumentNullException(nameof(component));
    }

    public abstract int GetCost();

    public abstract string GetIngredients();
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator : CoffeeDecorator
{
    public MilkDecorator(ICoffee component) : base(component)
    {
    }

    public override int GetCost()
    {
        return Component.GetCost() + 4;
    }

    public override string GetIngredients()
    {
        return Component.GetIngredients() + ", Milk";
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator : CoffeeDecorator
{
    public EspressoDecorator(ICoffee component) : base(component)
    {
    }

    public override int GetCost()
    {
        return Component.GetCost() + 5;
    }

    public override string GetIngredients()
    {
        return Component.GetIngredients() + ", Espresso";
    }
}

// Client code
class DecoratorPatternCoffee
{
    static void Main(string[] args)
    {
        ICoffee component = new SimpleCoffee();
        ICoffee decorator1 = new MilkDecorator(component);
        ICoffee decorator2 = new EspressoDecorator(decorator1);

        Console.WriteLine("Coffee cost is :: " + decorator2.GetCost());
        Console.WriteLine("Coffee ingredients are :: " + decorator2.GetIngredients());

        ICoffee latte = new MilkDecorator(new MilkDecorator(new SimpleCoffee()));
        Console.WriteLine("Coffee cost is :: " + latte.GetCost());
        Console.WriteLine("Coffee ingredients are :: " + latte.GetIngredients());
    }
}

/*
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
*/