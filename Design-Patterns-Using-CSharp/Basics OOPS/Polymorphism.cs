using System;

class Adder
{
    private int sum;

    public Adder()
    {
        this.sum = 0;
    }

    // Overloaded method for incrementing by a specific value
    public void Increment(int a)
    {
        this.sum += a;
    }

    // Overloaded method for incrementing by 1
    public void Increment()
    {
        this.sum += 1;
    }

    public int GetValue()
    {
        return this.sum;
    }
}

public class Polymorphism
{
    public static void Main(string[] args)
    {
        Adder a = new Adder();
        a.Increment(10);
        a.Increment();
        Console.WriteLine(a.GetValue());
    }
}
