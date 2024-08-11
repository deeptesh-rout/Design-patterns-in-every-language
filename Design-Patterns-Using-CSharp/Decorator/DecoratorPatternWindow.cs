using System;

// Window (Component)
interface IWindow
{
    void Draw();
}

// SimpleWindow (ConcreteComponent)
class SimpleWindow : IWindow
{
    public void Draw()
    {
        Console.WriteLine("SimpleWindow draw.");
    }
}

// Decorator (Decorator)
abstract class Decorator : IWindow
{
    protected IWindow Component;

    public Decorator(IWindow component)
    {
        Component = component;
    }

    public virtual void Draw()
    {
        Component.Draw();
    }
}

// VerticalScrollBarDecorator (ConcreteDecorator)
class VerticalScrollBarDecorator : Decorator
{
    public VerticalScrollBarDecorator(IWindow component) : base(component)
    {
    }

    public override void Draw()
    {
        base.Draw();
        Console.WriteLine("VerticalScrollBarDecorator draw");
    }
}

// HorizontalScrollBarDecorator (ConcreteDecorator)
class HorizontalScrollBarDecorator : Decorator
{
    public HorizontalScrollBarDecorator(IWindow component) : base(component)
    {
    }

    public override void Draw()
    {
        base.Draw();
        Console.WriteLine("HorizontalScrollBarDecorator draw");
    }
}

// Client code
class DecoratorPatternWindow
{
    static void Main(string[] args)
    {
        IWindow component = new SimpleWindow();
        IWindow decorator1 = new VerticalScrollBarDecorator(component);
        IWindow decorator2 = new HorizontalScrollBarDecorator(decorator1);
        decorator2.Draw();
    }
}

/*
SimpleWindow draw.
VerticalScrollBarDecorator draw
HorizontalScrollBarDecorator draw
*/