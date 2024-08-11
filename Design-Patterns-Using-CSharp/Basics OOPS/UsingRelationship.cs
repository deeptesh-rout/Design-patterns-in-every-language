using System;

class A
{
    public A()
    {
        Console.WriteLine("A created");
    }

    public void Fun1()
    {
        Console.WriteLine("fun1");
    }
}

class B
{
    public B()
    {
        Console.WriteLine("B created");
    }

    public void Fun2()
    {
        Console.WriteLine("fun2 start");
        new A().Fun1();
        Console.WriteLine("fun2 end");
    }
}

public class UsingRelationship
{
    public static void Main(string[] args)
    {
        B b = new B();
        b.Fun2();
    }
}
