using System;

// Product interface
interface IProduct
{
    void Operation();
}

// Concrete Product classes
class ConcreteProduct1 : IProduct
{
    public void Operation()
    {
        Console.WriteLine("Concrete Product1 Operation!");
    }
}

class ConcreteProduct2 : IProduct
{
    public void Operation()
    {
        Console.WriteLine("Concrete Product2 Operation!");
    }
}

// Creator abstract class
abstract class Factory
{
    public abstract IProduct CreateProduct();
}

// Concrete Creator classes
class ConcreteFactory1 : Factory
{
    public override IProduct CreateProduct()
    {
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 : Factory
{
    public override IProduct CreateProduct()
    {
        return new ConcreteProduct2();
    }
}

// Client code
class Factory1
{
    static void Main(string[] args)
    {
        Factory factory1 = new ConcreteFactory1();
        IProduct product1 = factory1.CreateProduct();
        product1.Operation();

        Factory factory2 = new ConcreteFactory2();
        IProduct product2 = factory2.CreateProduct();
        product2.Operation();
    }
}

/*
Concrete Product1 Operation!
Concrete Product2 Operation!
*/