using System;

// Component
interface IComponent
{
    void Operation();
}

// ConcreteComponent
class ConcreteComponent : IComponent
{
    public void Operation()
    {
        Console.WriteLine("ConcreteComponent operation.");
    }
}

// Decorator
abstract class Decorator : IComponent
{
    private readonly IComponent component;

    public Decorator(IComponent component)
    {
        this.component = component ?? throw new ArgumentNullException(nameof(component));
    }

    public virtual void Operation()
    {
        component.Operation();
    }
}

// ConcreteDecorator1
class ConcreteDecorator1 : Decorator
{
    public ConcreteDecorator1(IComponent component) : base(component)
    {
    }

    public override void Operation()
    {
        Console.WriteLine("ConcreteDecorator1 operation start.");
        base.Operation();
        Console.WriteLine("ConcreteDecorator1 operation end.");
    }
}

// ConcreteDecorator2
class ConcreteDecorator2 : Decorator
{
    public ConcreteDecorator2(IComponent component) : base(component)
    {
    }

    public override void Operation()
    {
        Console.WriteLine("ConcreteDecorator2 operation start.");
        base.Operation();
        Console.WriteLine("ConcreteDecorator2 operation end.");
    }
}

// Client code
class DecoratorPattern
{
    static void Main(string[] args)
    {
        IComponent component = new ConcreteComponent();
        Decorator decorator1 = new ConcreteDecorator1(component);
        Decorator decorator2 = new ConcreteDecorator2(decorator1);
        decorator2.Operation();
    }
}

/*
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end.
*/