using System;

// Handler abstract class
abstract class Handler
{
    protected Handler successor;

    public Handler(Handler successor)
    {
        this.successor = successor;
    }

    public abstract void HandleRequest(string request);
}

// ConcreteHandler1 class
class ConcreteHandler1 : Handler
{
    public ConcreteHandler1(Handler successor) : base(successor) { }

    public override void HandleRequest(string request)
    {
        if (request == "request1")
        {
            Console.WriteLine("ConcreteHandler1 handles the request1.");
        }
        else if (successor != null)
        {
            successor.HandleRequest(request);
        }
    }
}

// ConcreteHandler2 class
class ConcreteHandler2 : Handler
{
    public ConcreteHandler2(Handler successor) : base(successor) { }

    public override void HandleRequest(string request)
    {
        if (request == "request2")
        {
            Console.WriteLine("ConcreteHandler2 handles the request2.");
        }
        else if (successor != null)
        {
            successor.HandleRequest(request);
        }
    }
}

// ConcreteHandler3 class
class ConcreteHandler3 : Handler
{
    public ConcreteHandler3(Handler successor) : base(successor) { }

    public override void HandleRequest(string request)
    {
        if (request == "request3")
        {
            Console.WriteLine("ConcreteHandler3 handles the request3.");
        }
        else if (successor != null)
        {
            successor.HandleRequest(request);
        }
    }
}

// Client code
class ChainOfResponsibility
{
    static void Main(string[] args)
    {
        ConcreteHandler1 ch1 = new ConcreteHandler1(null);
        ConcreteHandler2 ch2 = new ConcreteHandler2(ch1);
        ConcreteHandler3 ch3 = new ConcreteHandler3(ch2);

        ch3.HandleRequest("request1");
        ch3.HandleRequest("request2");
        ch3.HandleRequest("request3");
        ch3.HandleRequest("request4");
    }
}

/*
ConcreteHandler1 handles the request1.
ConcreteHandler2 handles the request2.
ConcreteHandler3 handles the request3.
*/
