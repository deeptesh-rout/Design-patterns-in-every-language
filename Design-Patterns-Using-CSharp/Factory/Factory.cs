using System;

// Product interface
interface IAnimal
{
    void Speak();
}

// Concrete Product classes
class Dog : IAnimal
{
    public void Speak()
    {
        Console.WriteLine("Woof!");
    }
}

class Cat : IAnimal
{
    public void Speak()
    {
        Console.WriteLine("Meow!");
    }
}

// Creator abstract class
abstract class AnimalFactory
{
    public abstract IAnimal CreateAnimal();
}

// Concrete Creator classes
class DogFactory : AnimalFactory
{
    public override IAnimal CreateAnimal()
    {
        return new Dog();
    }
}

class CatFactory : AnimalFactory
{
    public override IAnimal CreateAnimal()
    {
        return new Cat();
    }
}

// Client code
class Factory
{
    static void Main(string[] args)
    {
        AnimalFactory dogFactory = new DogFactory();
        IAnimal dog = dogFactory.CreateAnimal();
        dog.Speak();

        AnimalFactory catFactory = new CatFactory();
        IAnimal cat = catFactory.CreateAnimal();
        cat.Speak();
    }
}

/*
Woof!
Meow!
*/