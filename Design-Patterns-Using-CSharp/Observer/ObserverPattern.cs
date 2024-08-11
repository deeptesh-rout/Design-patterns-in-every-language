using System;
using System.Collections.Generic;

// Subject abstract class
abstract class Subject
{
    private List<Observer> observers = new List<Observer>();

    public void Attach(Observer observer)
    {
        observer.SetSubject(this);
        observers.Add(observer);
    }

    public void Detach(Observer observer)
    {
        observer.SetSubject(null);
        observers.Remove(observer);
    }

    public void NotifyObservers()
    {
        foreach (Observer observer in observers)
        {
            observer.Update();
        }
    }
}

// ConcreteSubject class
class ConcreteSubject : Subject
{
    private string state;

    public string GetState()
    {
        return state;
    }

    public void SetState(string state)
    {
        this.state = state;
        NotifyObservers();
    }
}

// Observer abstract class
abstract class Observer
{
    protected Subject subject;

    public void SetSubject(Subject subject)
    {
        this.subject = subject;
    }

    public abstract void Update();
}

// ConcreteObserver1 class
class ConcreteObserver1 : Observer
{
    public ConcreteObserver1(Subject subject)
    {
        SetSubject(subject);
        subject.Attach(this);
    }

    public override void Update()
    {
        Console.WriteLine(subject is ConcreteSubject ?
                ((ConcreteSubject)subject).GetState() + " notified to Observer1" : "");
    }
}

// ConcreteObserver2 class
class ConcreteObserver2 : Observer
{
    public ConcreteObserver2(Subject subject)
    {
        SetSubject(subject);
        subject.Attach(this);
    }

    public override void Update()
    {
        Console.WriteLine(subject is ConcreteSubject ?
                ((ConcreteSubject)subject).GetState() + " notified to Observer2" : "");
    }
}

// Client code
class ObserverPattern
{
    static void Main(string[] args)
    {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver1 observer1 = new ConcreteObserver1(subject);
        ConcreteObserver2 observer2 = new ConcreteObserver2(subject);

        subject.SetState("First state");
        subject.SetState("Second state");
    }
}

/*
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
*/