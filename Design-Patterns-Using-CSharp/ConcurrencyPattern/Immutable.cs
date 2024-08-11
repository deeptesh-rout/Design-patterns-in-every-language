using System;

public sealed class ImmutablePerson
{
    public string Name { get; }
    public int Age { get; }
    public string Gender { get; }

    public ImmutablePerson(string name, int age, string gender)
    {
        Name = name;
        Age = age;
        Gender = gender;
    }
}

// Client code

public sealed class Immutable
{
    public static void Main()
    {
        ImmutablePerson person = new ImmutablePerson("John Doe", 30, "Male");
        ImmutablePerson newPerson = new ImmutablePerson("John Doe", 31, "Male");

        Console.WriteLine(person);
        Console.WriteLine(newPerson);

        //person.Age = 32;
        // error CS0200: Property or indexer `ImmutablePerson.Age' cannot be assigned to (it is read-only)
    }
}

/*
ImmutablePerson
ImmutablePerson
*/