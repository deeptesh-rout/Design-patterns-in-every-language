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

    public Proxy()
    {
        this.realSubject = new RealSubject();
    }

    public void Request()
    {
        realSubject.Request();
    }
}

// Client code
class ProxyTest
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