using System;
using System.Collections.Generic;

abstract class Prototype : ICloneable
{
    public abstract void Display();

    public object Clone()
    {
        return MemberwiseClone();
    }
}

class ConcretePrototype1 : Prototype
{
    public override void Display()
    {
        Console.WriteLine("ConcretePrototype1");
    }
}

class ConcretePrototype2 : Prototype
{
    public override void Display()
    {
        Console.WriteLine("ConcretePrototype2");
    }
}

class PrototypeRegistry
{
    private static readonly Dictionary<string, Prototype> Prototypes = new Dictionary<string, Prototype>();

    static PrototypeRegistry()
    {
        Load();
    }

    public static void AddPrototype(string key, Prototype value)
    {
        Prototypes[key] = value;
    }

    public static Prototype GetPrototype(string key)
    {
        if (Prototypes.ContainsKey(key))
        {
            return (Prototype)Prototypes[key].Clone();
        }
        return null;
    }

    public static void Load()
    {
        AddPrototype("CP1", new ConcretePrototype1());
        AddPrototype("CP2", new ConcretePrototype2());
    }
}

// Client code

class PrototypePattern
{
    static void Main(string[] args)
    {
        PrototypeRegistry.Load();
        Prototype c1 = PrototypeRegistry.GetPrototype("CP1");
        Prototype c2 = PrototypeRegistry.GetPrototype("CP2");
        c1.Display();
        c2.Display();
    }
}

/*
ConcretePrototype1
ConcretePrototype2
*/
