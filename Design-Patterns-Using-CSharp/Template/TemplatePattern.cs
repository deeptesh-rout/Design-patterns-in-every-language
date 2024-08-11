using System;

abstract class AbstractClass
{
    // The template method
    public void TemplateMethod()
    {
        Operation1();
        Operation2();
    }

    // Primitive operation 1
    protected abstract void Operation1();

    // Primitive operation 2
    protected abstract void Operation2();
}

class ConcreteClass1 : AbstractClass
{
    protected override void Operation1()
    {
        Console.WriteLine("Concrete Class 1 : Operation 1");
    }

    protected override void Operation2()
    {
        Console.WriteLine("Concrete Class 1 : Operation 2");
    }
}

class ConcreteClass2 : AbstractClass
{
    protected override void Operation1()
    {
        Console.WriteLine("Concrete Class 2 : Operation 1");
    }

    protected override void Operation2()
    {
        Console.WriteLine("Concrete Class 2 : Operation 2");
    }
}

// Client code
class TemplatePattern
{
    public static void Main(string[] args)
    {
        AbstractClass concreteClass = new ConcreteClass1();
        concreteClass.TemplateMethod();
    }
}
