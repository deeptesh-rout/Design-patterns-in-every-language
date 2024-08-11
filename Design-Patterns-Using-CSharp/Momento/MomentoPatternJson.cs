using System;
using System.Collections.Generic;

class Memento : ICloneable
{
    private object state;

    public Memento(object state)
    {
        this.state = state;
    }

    public object GetState()
    {
        return state;
    }

    public object Clone()
    {
        return MemberwiseClone();
    }
}

class Originator
{
    private object state;

    public void SetState(object state)
    {
        this.state = state;
    }

    public object GetState()
    {
        return state;
    }

    public Memento CreateMemento()
    {
        return new Memento(state);
    }

    public void SetMemento(Memento m)
    {
        this.state = m.GetState();
    }
}

class CareTaker
{
    private List<Memento> history;
    private int top;
    private int max;

    public CareTaker()
    {
        this.history = new List<Memento>();
        this.top = -1;
        this.max = -1;
    }

    public void AddMemento(Memento m)
    {
        top += 1;
        max = top;
        if (top <= history.Count - 1)
        {
            history[top] = (Memento)m.Clone();
        }
        else
        {
            history.Add((Memento)m.Clone());
        }
    }

    public Memento GetMemento(int index)
    {
        return history[index];
    }

    public Memento Undo()
    {
        Console.WriteLine("Undoing state.");
        if (top <= 0)
        {
            top = 0;
            return history[0];
        }

        top -= 1;
        return history[top];
    }

    public Memento Redo()
    {
        Console.WriteLine("Redoing state.");
        if (top >= (history.Count - 1) || top >= max)
        {
            return history[top];
        }

        top += 1;
        return history[top];
    }

    public int GetStatesCount()
    {
        return history.Count;
    }
}

// Client code

class MomentoPatternJson
{
    static void Main(string[] args)
    {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.SetState("State 1");
        careTaker.AddMemento(originator.CreateMemento());
        Console.WriteLine(originator.GetState());

        originator.SetState("State 2");
        careTaker.AddMemento(originator.CreateMemento());
        Console.WriteLine(originator.GetState());

        originator.SetState("State 3");
        careTaker.AddMemento(originator.CreateMemento());
        Console.WriteLine(originator.GetState());

        originator.SetMemento(careTaker.Undo());
        Console.WriteLine(originator.GetState());

        originator.SetMemento(careTaker.Undo());
        Console.WriteLine(originator.GetState());

        originator.SetState("State 4");
        careTaker.AddMemento(originator.CreateMemento());
        Console.WriteLine(originator.GetState());

        originator.SetMemento(careTaker.Redo());
        Console.WriteLine(originator.GetState());

        originator.SetMemento(careTaker.Redo());
        Console.WriteLine(originator.GetState());

        originator.SetMemento(careTaker.Redo());
        Console.WriteLine(originator.GetState());
    }
}
