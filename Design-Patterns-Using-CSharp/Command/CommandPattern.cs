using System;
using System.Collections.Generic;

// Invoker
class Invoker
{
    private List<Command> commands = new List<Command>();

    public void SetCommand(Command command)
    {
        commands.Add(command);
    }

    public void ExecuteCommands()
    {
        foreach (Command command in commands)
        {
            command.Execute();
        }
    }

    public void UnexecuteCommands()
    {
        foreach (Command command in commands)
        {
            command.Unexecute();
        }
    }
}

// Command
abstract class Command
{
    public abstract void Execute();
    public abstract void Unexecute();
}

// ConcreteCommand
class ConcreteCommand : Command
{
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }

    public override void Execute()
    {
        receiver.Action("Action 1");
    }

    public override void Unexecute()
    {
        receiver.Action("Action 2");
    }
}

// Receiver
class Receiver
{
    public void Action(string action)
    {
        Console.WriteLine(action);
    }
}

// Client Code
class CommandPattern
{
    static void Main(string[] args)
    {
        Receiver receiver = new Receiver();
        ConcreteCommand concreteCommand = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();

        invoker.SetCommand(concreteCommand);
        invoker.ExecuteCommands();
        invoker.UnexecuteCommands();
    }
}

/*
Action 1
Action 2
*/
