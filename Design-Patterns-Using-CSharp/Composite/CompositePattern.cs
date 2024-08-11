using System;
using System.Collections.Generic;

// Component
abstract class Component
{
    public abstract void Operation();
}

// Composite
class Composite : Component
{
    private List<Component> children = new List<Component>();

    public override void Operation()
    {
        Console.WriteLine("Composite Operation");
        foreach (Component child in children)
        {
            child.Operation();
        }
    }

    public void Add(Component component)
    {
        children.Add(component);
    }

    public void Remove(Component component)
    {
        children.Remove(component);
    }
}

// Leaf
class Leaf : Component
{
    public override void Operation()
    {
        Console.WriteLine("Leaf Operation");
    }
}

// Client code
class CompositePattern
{
    static void Main(string[] args)
    {
        Composite composite = new Composite();
        composite.Add(new Leaf());

        Composite composite2 = new Composite();
        composite2.Add(new Leaf());

        composite.Add(composite2);
        composite.Operation();
    }
}

/*
Composite Operation
Leaf Operation
Composite Operation
Leaf Operation
*/