using System;

// Animal interface
interface IAnimal
{
    void Voice();
}

// Concrete Animal classes
class Dog : IAnimal
{
    public void Voice()
    {
        Console.WriteLine("Bhow Bhow!!");
    }
}

class Cat : IAnimal
{
    public void Voice()
    {
        Console.WriteLine("Meow Meow!!");
    }
}

// AnimalFactory interface
interface IAnimalFactory
{
    IAnimal GetAnimal();
}

// Concrete AnimalFactory classes
class CatFactory : IAnimalFactory
{
    public IAnimal GetAnimal()
    {
        return new Cat();
    }
}

class DogFactory : IAnimalFactory
{
    public IAnimal GetAnimal()
    {
        return new Dog();
    }
}

// Client code
class FactoryMethodAnimal
{
    static void Main(string[] args)
    {
        IAnimalFactory dogFactory = new DogFactory();
        dogFactory.GetAnimal().Voice();

        IAnimalFactory catFactory = new CatFactory();
        catFactory.GetAnimal().Voice();

        // Client code for Cow
        IAnimalFactory cowFactory = new CowFactory();
        cowFactory.GetAnimal().Voice();
    }
}
/*
Bhow Bhow!!
Meow Meow!!
Gooaa Gooaa!!
*/

// Future changes to include cow type of objects.
class Cow : IAnimal
{
    public void Voice()
    {
        Console.WriteLine("Gooaa Gooaa!!");
    }
}

class CowFactory : IAnimalFactory
{
    public IAnimal GetAnimal()
    {
        return new Cow();
    }
}


