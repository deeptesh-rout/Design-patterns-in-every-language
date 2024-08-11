using System;
using System.Collections.Generic;

// Memento
class Memento
{
    private string state;

    public Memento(string state)
    {
        this.state = state;
    }

    public string GetState()
    {
        return state;
    }
}

// CareTaker
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
            history[top] = m;
        }
        else
        {
            history.Add(m);
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
            return GetMemento(0);
        }

        top -= 1;
        return GetMemento(top);
    }

    public Memento Redo()
    {
        Console.WriteLine("Redoing state.");
        if (top >= (history.Count - 1) || top >= max)
        {
            return GetMemento(top);
        }

        top += 1;
        return GetMemento(top);
    }

    public int GetStatesCount()
    {
        return history.Count;
    }
}

// Originator
class Originator
{
    private string state;
    private CareTaker careTaker;

    public Originator()
    {
        this.careTaker = new CareTaker();
    }

    public void SetState(string state)
    {
        this.state = state;
        careTaker.AddMemento(CreateMemento());
    }

    public string GetState()
    {
        return state;
    }

    public Memento CreateMemento()
    {
        return new Memento(state);
    }

    public void SetMemento(Memento m)
    {
        state = m.GetState();
    }

    public void Undo()
    {
        SetMemento(careTaker.Undo());
    }

    public void Redo()
    {
        SetMemento(careTaker.Redo());
    }
}

// Client code
class MomentoPatternCopy
{
    static void Main(string[] args)
    {
        Originator originator = new Originator();
        originator.SetState("State 1");
        Console.WriteLine(originator.GetState());

        originator.SetState("State 2");
        Console.WriteLine(originator.GetState());

        originator.SetState("State 3");
        Console.WriteLine(originator.GetState());

        originator.Undo();
        Console.WriteLine(originator.GetState());

        originator.Undo();
        Console.WriteLine(originator.GetState());

        originator.Redo();
        Console.WriteLine(originator.GetState());

        originator.Redo();
        Console.WriteLine(originator.GetState());
    }
}

/*
State 1
State 2
State 3
Undoing state.
State 2
Undoing state.
State 1
Redoing state.
State 2
Redoing state.
State 3
*/