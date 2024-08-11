using System;

// Subject Interface
interface ISubject
{
    void Request();
}

// RealSubject Class
class RealSubject : ISubject
{
    public void Request()
    {
        Console.WriteLine("Concrete Subject Request Method");
    }
}

// Proxy Class
class Proxy : ISubject
{
    private RealSubject realSubject;

    public void Request()
    {
        if (realSubject == null)
        {
            realSubject = new RealSubject(); // Lazy Initialization
        }
        realSubject.Request();
    }
}

// Client code
class ProxyLazy
{
    static void Main(string[] args)
    {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}

/*
Concrete Subject Request Method
*/