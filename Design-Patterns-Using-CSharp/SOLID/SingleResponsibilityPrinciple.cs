using System;

class Animal
{
    protected string name;

    public Animal(string name)
    {
        this.name = name;
    }

    public void Eat()
    {
        Console.WriteLine(name + " is eating.");
    }

    public void Sleep()
    {
        Console.WriteLine(name + " is sleeping.");
    }

    public virtual void MakeSound()
    {
        Console.WriteLine(name + " is making a sound.");
    }
}

class Mammal : Animal
{
    public Mammal(string name) : base(name)
    {
    }

    public void GiveBirth()
    {
        Console.WriteLine(name + " is giving birth to live young.");
    }
}

class Reptile : Animal
{
    public Reptile(string name) : base(name)
    {
    }

    public void LayEggs()
    {
        Console.WriteLine(name + " is laying eggs.");
    }
}

class Bird : Animal
{
    public Bird(string name) : base(name)
    {
    }

    public void Fly()
    {
        Console.WriteLine(name + " is flying.");
    }

    public override void MakeSound()
    {
        Console.WriteLine(name + " is making a sound.");
    }

    public void LayEggs()
    {
        Console.WriteLine(name + " is laying eggs.");
    }
}

// Client code.
public class SingleResponsibilityPrinciple
{
    public static void Main(string[] args)
    {
        Mammal animal1 = new Mammal("Cat");
        animal1.GiveBirth();
        animal1.MakeSound();

        Reptile animal2 = new Reptile("Snake");
        animal2.LayEggs();
        animal2.Eat();

        Bird animal3 = new Bird("Eagle");
        animal3.LayEggs();
        animal3.Fly();
    }
}

/*
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is laying eggs.
Eagle is flying.
*/
