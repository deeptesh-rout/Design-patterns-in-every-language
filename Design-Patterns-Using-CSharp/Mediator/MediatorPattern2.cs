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
    protected string id;
    protected IMediator mediator;

    public Colleague(string id, IMediator mediator)
    {
        this.id = id;
        this.mediator = mediator;
    }

    public abstract void Send(string message, string to);

    public abstract void Receive(string message);

    public string GetId()
    {
        return id;
    }
}

class ConcreteColleague : Colleague
{
    public ConcreteColleague(string id, IMediator mediator) : base(id, mediator) { }

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

public class MediatorPattern2
{
    public static void Main(string[] args)
    {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague first = new ConcreteColleague("First", mediator);
        mediator.AddColleague(first);

        ConcreteColleague second = new ConcreteColleague("Second", mediator);
        mediator.AddColleague(second);

        first.Send("Hello, World!", "Second");
        second.Send("Hi, World!", "First");
    }
}

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
Second Sent Message : Hi, World!
Mediator pass Message : Hi, World!
First Received Message Hi, World!
*/