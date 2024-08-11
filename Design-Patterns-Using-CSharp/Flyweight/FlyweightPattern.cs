using System;
using System.Collections.Generic;

// Flyweight abstract class
abstract class Flyweight
{
    protected string intrinsicState;

    public Flyweight(string intrinsicState)
    {
        this.intrinsicState = intrinsicState;
    }

    public abstract void Operation(object extrinsicState);
}

// Concrete Flyweight class
class ConcreteFlyweight : Flyweight
{
    public ConcreteFlyweight(string intrinsicState) : base(intrinsicState)
    {
    }

    public override void Operation(object extrinsicState)
    {
        Console.WriteLine($"Flyweight: intrinsicState: {intrinsicState} and extrinsicState: {extrinsicState}");

    }
}

// FlyweightFactory class
class FlyweightFactory
{
    private Dictionary<string, Flyweight> flyweights = new Dictionary<string, Flyweight>();

    public Flyweight GetFlyweight(string key)
    {
        if (!flyweights.ContainsKey(key))
        {
            flyweights[key] = new ConcreteFlyweight(key);
        }
        return flyweights[key];
    }

    public int GetCount()
    {
        return flyweights.Count;
    }
}

// Client code
class FlyweightPattern
{
    static void Main(string[] args)
    {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.GetFlyweight("Intr");
        Flyweight flyweight2 = factory.GetFlyweight("Intr");
        flyweight1.Operation("extr");
        Console.WriteLine(flyweight1 + " " + flyweight2);
        Console.WriteLine("Object count: " + factory.GetCount());
    }
}

/*
Flyweight: intrinsicState: Intr and extrinsicState: extr
ConcreteFlyweight ConcreteFlyweight
Object count: 1
*/
