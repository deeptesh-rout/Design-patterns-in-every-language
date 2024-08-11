using System;
using System.Collections.Generic;

interface IChatRoom
{
    void AddParticipant(IParticipant participant);
    void Broadcast(string message, string origin);
    void SendMessage(string message, string to);
}

class ChatRoom : IChatRoom
{
    private Dictionary<string, IParticipant> participants = new Dictionary<string, IParticipant>();

    public void AddParticipant(IParticipant participant)
    {
        participants[participant.GetName()] = participant;
    }

    public void Broadcast(string message, string origin)
    {
        Console.WriteLine($"ChatRoom broadcast Message : {message}");
        foreach (var participant in participants.Values)
        {
            if (participant.GetName() != origin)
            {
                participant.Receive(message);
            }
        }
    }

    public void SendMessage(string message, string to)
    {
        participants[to].Receive(message);
    }
}

interface IParticipant
{
    string GetName();
    void Broadcast(string message);
    void Send(string message, string to);
    void Receive(string message);
}

class Participant : IParticipant
{
    private string name;
    private IChatRoom chatRoom;

    public Participant(string name, IChatRoom chatRoom)
    {
        this.name = name;
        this.chatRoom = chatRoom;
        chatRoom.AddParticipant(this);
    }

    public string GetName()
    {
        return name;
    }

    public void Broadcast(string message)
    {
        Console.WriteLine($"{name} broadcast Message : {message}");
        chatRoom.Broadcast(message, name);
    }

    public void Send(string message, string to)
    {
        Console.WriteLine($"{name} sent Message : {message}");
        chatRoom.SendMessage(message, to);
    }

    public void Receive(string message)
    {
        Console.WriteLine($"{name} received Message : {message}");
    }
}

// Client code

class MediatorPattern
{
    static void Main(string[] args)
    {
        ChatRoom chatRoom = new ChatRoom();
        Participant james = new Participant("James", chatRoom);
        Participant michael = new Participant("Michael", chatRoom);
        Participant robert = new Participant("Robert", chatRoom);

        michael.Send("Good Morning.", "James");
        james.Broadcast("Hello, World!");
    }
}

/*
Michael sent Message : Good Morning.
James received Message : Good Morning.
James broadcast Message : Hello, World!
ChatRoom broadcast Message : Hello, World!
Michael received Message : Hello, World!
Robert received Message : Hello, World!
*/