using System;

class BulbControl
{
    private IBulbState current;

    public BulbControl()
    {
        this.current = new Off();
    }

    public void SetState(IBulbState state)
    {
        this.current = state;
    }

    public void Flip()
    {
        this.current.Flip(this);
    }

    public string ToStringState()
    {
        return this.current.ToString();
    }
}

interface IBulbState
{
    void Flip(BulbControl bc);
    string ToString();
}

class On : IBulbState
{
    public void Flip(BulbControl bc)
    {
        bc.SetState(new Off());
    }

    public override string ToString()
    {
        return "On";
    }
}

class Off : IBulbState
{
    public void Flip(BulbControl bc)
    {
        bc.SetState(new On());
    }

    public override string ToString()
    {
        return "Off";
    }
}

// Client code.
public class StatePattern
{
    public static void Main(string[] args)
    {
        BulbControl c = new BulbControl();
        c.Flip();
        Console.WriteLine(c.ToStringState());
        c.Flip();
        Console.WriteLine(c.ToStringState());
    }
}
