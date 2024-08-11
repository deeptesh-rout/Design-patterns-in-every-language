using System;

// Desired Interface
interface DesiredInterface
{
    void Operation();
}

// Adapter class
class Adapter : DesiredInterface
{
    private Adaptee adaptee;

    public Adapter()
    {
        this.adaptee = new Adaptee();
    }

    public void Operation()
    {
        adaptee.SomeOperation();
    }
}

// Adaptee class
class Adaptee
{
    public void SomeOperation()
    {
        Console.WriteLine("Adaptee SomeOperation() function called.");
    }
}

// Client Code
public class AdapterPattern
{
    public static void Main(string[] args)
    {
        DesiredInterface adapter = new Adapter();
        adapter.Operation();
    }
}
/* 
Adaptee someOperation() function called.
*/