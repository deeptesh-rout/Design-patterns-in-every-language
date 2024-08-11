using System;

abstract class Animal
{
    protected string name;

    protected Animal(string name)
    {
        this.name = name;
    }
}

abstract class Bird : Animal
{
    protected internal int flightHeight;

    protected Bird(string name) : base(name)
    {
        this.flightHeight = 0;
    }

    public abstract void Fly();
}

class Sparrow : Bird
{
    public Sparrow(string name) : base(name)
    {
    }

    public override void Fly()
    {
        Console.WriteLine("The sparrow is fluttering its wings.");
        flightHeight = 100;
    }
}

class Penguin : Bird
{
    public Penguin(string name) : base(name)
    {
    }

    public override void Fly()
    {
        Console.WriteLine("The penguin cannot fly.");
    }

    public void Slide()
    {
        Console.WriteLine("The penguin is sliding on its belly!");
    }

    public void Swim()
    {
        Console.WriteLine("The penguin is swimming in the water!");
    }
}

class Dodo : Bird
{
    public Dodo(string name) : base(name)
    {
    }

    public override void Fly()
    {
        Console.WriteLine("The dodo is extinct and cannot fly.");
    }
}

public class LiskovSubstitutionPrinciple2
{
    static void Test(Bird bird)
    {
        bird.Fly();
        if (bird.flightHeight > 0)
        {
            Console.WriteLine("Bird is flying at a positive height.");
        }
        else
        {
            Console.WriteLine("Error: Fly() method called; flight height is still zero.");
        }
    }

    public static void Main(string[] args)
    {
        Sparrow sparrow = new Sparrow("Sparrow");
        Test(sparrow);

        Penguin penguin = new Penguin("Penguin");
        Test(penguin);

        Dodo dodo = new Dodo("Dodo");
        Test(dodo);
    }
}

/*
The sparrow is fluttering its wings.
Bird is flying at a positive height.
The penguin cannot fly.
Error: Fly() method called; flight height is still zero.
The dodo is extinct and cannot fly.
Error: Fly() method called; flight height is still zero.
*/