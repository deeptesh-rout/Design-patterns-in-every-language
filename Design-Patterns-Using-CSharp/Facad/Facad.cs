using System;

// Subsystem1
class Subsystem1
{
    public void Operation1()
    {
        Console.WriteLine("Subsystem1 operation1");
    }

    public void Operation2()
    {
        Console.WriteLine("Subsystem1 operation2");
    }
}

// Subsystem2
class Subsystem2
{
    public void Operation1()
    {
        Console.WriteLine("Subsystem2 operation1");
    }

    public void Operation2()
    {
        Console.WriteLine("Subsystem2 operation2");
    }
}

// SystemManagerFacade
class SystemManagerFacade
{
    private Subsystem1 subsystem1;
    private Subsystem2 subsystem2;

    public SystemManagerFacade()
    {
        this.subsystem1 = new Subsystem1();
        this.subsystem2 = new Subsystem2();
    }

    public void Operation()
    {
        subsystem1.Operation1();
        subsystem1.Operation2();
        subsystem2.Operation1();
        subsystem2.Operation2();
    }
}

// Client code
class Facade
{
    static void Main(string[] args)
    {
        SystemManagerFacade facade = new SystemManagerFacade();
        facade.Operation();
    }
}

/*
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
*/