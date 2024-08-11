using System;

class Context
{
    private IState currentState;

    public Context(IState state)
    {
        this.currentState = state;
    }

    public void ChangeState(IState state)
    {
        this.currentState = state;
    }

    public void Request()
    {
        this.currentState.Handle(this);
    }
}

interface IState
{
    void Handle(Context context);
}

class ConcreteState1 : IState
{
    public void Handle(Context context)
    {
        Console.WriteLine("ConcreteState1 handle");
        context.ChangeState(new ConcreteState2());
    }
}

class ConcreteState2 : IState
{
    public void Handle(Context context)
    {
        Console.WriteLine("ConcreteState2 handle");
        context.ChangeState(new ConcreteState1());
    }
}

// Client code.
class StatePattern2
{
    static void Main(string[] args)
    {
        IState state1 = new ConcreteState1();
        Context context = new Context(state1);
        context.Request();
        context.Request();
    }
}
