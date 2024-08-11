using System;

// Abstraction abstract class
abstract class Abstraction
{
    protected Implementor imp;

    public Abstraction(Implementor imp)
    {
        this.imp = imp;
    }

    public abstract void Operation();
}

// Implementor abstract class
abstract class Implementor
{
    public abstract void Operation();
}

// ConcreteAbstraction class
class ConcreteAbstraction : Abstraction
{
    public ConcreteAbstraction(Implementor imp) : base(imp)
    {
    }

    public override void Operation()
    {
        imp.Operation();
    }
}

// ConcreteImplementor1 class
class ConcreteImplementor1 : Implementor
{
    public override void Operation()
    {
        Console.WriteLine("ConcreteImplementor1 operation");
    }
}

// ConcreteImplementor2 class
class ConcreteImplementor2 : Implementor
{
    public override void Operation()
    {
        Console.WriteLine("ConcreteImplementor2 operation");
    }
}

// Client code
class BridgePattern
{
    static void Main(string[] args)
    {
        Implementor c1 = new ConcreteImplementor1();
        Abstraction abstraction = new ConcreteAbstraction(c1);
        abstraction.Operation();
    }
}

/*
ConcreteImplementor1 operation
*/