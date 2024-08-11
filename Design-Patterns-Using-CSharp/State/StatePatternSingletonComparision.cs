using System;
using System.Diagnostics;

interface IState
{
    void Handle(Context context);
}

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

class ConcreteState1 : IState
{
    private static ConcreteState1 instance;

    private ConcreteState1()
    {
    }

    public static ConcreteState1 GetInstance()
    {
        if (instance == null)
        {
            instance = new ConcreteState1();
        }
        return instance;
    }

    public void Handle(Context context)
    {
        context.ChangeState(ConcreteState2.GetInstance());
    }
}

class ConcreteState2 : IState
{
    private static ConcreteState2 instance;

    private ConcreteState2()
    {
    }

    public static ConcreteState2 GetInstance()
    {
        if (instance == null)
        {
            instance = new ConcreteState2();
        }
        return instance;
    }

    public void Handle(Context context)
    {
        context.ChangeState(ConcreteState3.GetInstance());
    }
}

class ConcreteState3 : IState
{
    private static ConcreteState3 instance;

    private ConcreteState3()
    {
    }

    public static ConcreteState3 GetInstance()
    {
        if (instance == null)
        {
            instance = new ConcreteState3();
        }
        return instance;
    }

    public void Handle(Context context)
    {
        context.ChangeState(ConcreteState4.GetInstance());
    }
}

class ConcreteState4 : IState
{
    private static ConcreteState4 instance;

    private ConcreteState4()
    {
    }

    public static ConcreteState4 GetInstance()
    {
        if (instance == null)
        {
            instance = new ConcreteState4();
        }
        return instance;
    }

    public void Handle(Context context)
    {
        context.ChangeState(ConcreteState1.GetInstance());
    }
}

class StatePatternSingletonComparison
{
    public static void Main(string[] args)
    {
        ConcreteState1 state1 = ConcreteState1.GetInstance();
        Test(state1, 10);

        ConcreteState1 state2 = ConcreteState1.GetInstance();
        Test(state2, 10);
    }

    static void Test(IState state, int count)
    {
        Context context = new Context(state);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.Start();
        for (int i = 0; i < count; i++)
        {
            context.Request();
        }
        stopwatch.Stop();
        Console.WriteLine(stopwatch.Elapsed.TotalSeconds);
    }
}
