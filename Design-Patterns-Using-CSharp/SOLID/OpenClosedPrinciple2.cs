using System;

class Animal
{
    protected string name;

    public Animal(string name)
    {
        this.name = name;
    }
}

class Bird : Animal
{
    public Bird(string name) : base(name)
    {
    }

    public void Fly()
    {
        if (name.Equals("Dodo", StringComparison.OrdinalIgnoreCase))
        {
            Console.WriteLine("The dodo is extinct and cannot fly.");
        }
        else if (name.Equals("Penguin", StringComparison.OrdinalIgnoreCase))
        {
            Console.WriteLine("The penguin cannot fly.");
        }
        else if (name.Equals("Eagle", StringComparison.OrdinalIgnoreCase))
        {
            Console.WriteLine("The eagle is soaring through the sky!");
        }
        else if (name.Equals("Sparrow", StringComparison.OrdinalIgnoreCase))
        {
            Console.WriteLine("The sparrow is fluttering its wings!");
        }
    }
}

// Client code
public class OpenClosedPrinciple2
{
    public static void Main(string[] args)
    {
        Bird bird1 = new Bird("Eagle");
        bird1.Fly();

        Bird bird2 = new Bird("Dodo");
        bird2.Fly();
    }
}

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
*/
