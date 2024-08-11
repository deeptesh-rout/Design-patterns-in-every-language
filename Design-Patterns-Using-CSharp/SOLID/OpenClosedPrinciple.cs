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

    public virtual void Fly()
    {
        // Abstract method, to be overridden by subclasses
    }
}

class Dodo : Bird
{
    public Dodo() : base("Dodo")
    {
    }

    public override void Fly()
    {
        Console.WriteLine("The dodo is extinct and cannot fly.");
    }
}

class Penguin : Bird
{
    public Penguin() : base("Penguin")
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

class Eagle : Bird
{
    public Eagle() : base("Eagle")
    {
    }

    public override void Fly()
    {
        Console.WriteLine("The eagle is soaring through the sky!");
    }
}


// Client code
public class OpenClosedPrinciple
{
    public static void Main(string[] args)
    {
        Bird bird1 = new Eagle();
        bird1.Fly();

        Bird bird2 = new Dodo();
        bird2.Fly();

        Bird bird3 = new Pigeon();
        bird3.Fly();
    }
}

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
The pigeon is fluttering its wings!
*/

class Pigeon : Bird
{
    public Pigeon() : base("Pigeon")
    {
    }

    public void MakeCooingSound()
    {
        Console.WriteLine("The pigeon is making a cooing sound.");
    }

    public override void Fly()
    {
        Console.WriteLine("The pigeon is fluttering its wings!");
    }
}
