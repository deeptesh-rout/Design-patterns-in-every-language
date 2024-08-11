using System;

// ICoffee (Component)
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
    protected string Name;
    protected int Cost;

    public CoffeeDecorator(ICoffee component, string name, int cost)
    {
        Component = component ?? throw new ArgumentNullException(nameof(component));
        Name = name ?? throw new ArgumentNullException(nameof(name));
        Cost = cost;
    }

    public int GetCost()
    {
        return Component.GetCost() + Cost;
    }

    public string GetIngredients()
    {
        return Component.GetIngredients() + ", " + Name;
    }
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator : CoffeeDecorator
{
    public MilkDecorator(ICoffee component) : base(component, "Milk", 4)
    {
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator : CoffeeDecorator
{
    public EspressoDecorator(ICoffee component) : base(component, "Espresso", 5)
    {
    }
}

// Client code
public class DecoratorPatternCoffee2
{
    public static void Main(string[] args)
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