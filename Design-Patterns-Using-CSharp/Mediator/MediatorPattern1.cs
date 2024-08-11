using System;
using System.Collections.Generic;

interface IMediator
{
    void AddColleague(Colleague colleague);
    void SendMessage(string message, string colleagueId);
}

class ConcreteMediator : IMediator
{
    private Dictionary<string, Colleague> colleagues = new Dictionary<string, Colleague>();

    public void AddColleague(Colleague colleague)
    {
        colleagues[colleague.GetId()] = colleague;
    }

    public void SendMessage(string message, string colleagueId)
    {
        Console.WriteLine($"Mediator pass Message : {message}");
        colleagues[colleagueId].Receive(message);
    }
}

abstract class Colleague
{
    protected IMediator mediator;
    protected string id;

    public Colleague(IMediator mediator, string id)
    {
        this.mediator = mediator;
        this.id = id;
    }

    public abstract void Send(string message, string to);

    public abstract void Receive(string message);

    public string GetId()
    {
        return id;
    }
}

class ConcreteColleague1 : Colleague
{
    public ConcreteColleague1(IMediator mediator) : base(mediator, "First") { }

    public override void Send(string message, string to)
    {
        Console.WriteLine($"{id} Sent Message : {message}");
        mediator.SendMessage(message, to);
    }

    public override void Receive(string message)
    {
        Console.WriteLine($"{id} Received Message {message}");
    }
}

class ConcreteColleague2 : Colleague
{
    public ConcreteColleague2(IMediator mediator) : base(mediator, "Second") { }

    public override void Send(string message, string to)
    {
        Console.WriteLine($"{id} Sent Message : {message}");
        mediator.SendMessage(message, to);
    }

    public override void Receive(string message)
    {
        Console.WriteLine($"{id} Received Message {message}");
    }
}

// Client code

public class MediatorPattern1
{
    public static void Main(string[] args)
    {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague1 first = new ConcreteColleague1(mediator);
        mediator.AddColleague(first);
        ConcreteColleague2 second = new ConcreteColleague2(mediator);
        mediator.AddColleague(second);

        first.Send("Hello, World!", "Second");
    }
}

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
*/