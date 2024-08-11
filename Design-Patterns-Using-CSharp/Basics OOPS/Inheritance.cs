using System;

class Person
{
    protected string name;
    protected int age;
    protected string gender;

    public Person(string name, int age, string gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public override string ToString()
    {
        return string.Format("Person: {0} is a {1} and {2} years old.", name, gender, age);
    }

    public string GetGender()
    {
        return gender;
    }
}

class Citizen : Person
{
    private int id;

    public Citizen(string name, int age, int id, string gender) : base(name, age, gender)
    {
        this.id = id;
    }

    public int GetVoterId()
    {
        return id;
    }

    public override string ToString()
    {
        return string.Format("Citizen: {0} is a {1} and {2} years old with voter id {3}.", name, gender, age, id);
    }
}

public class Inheritance
{
    public static void Main(string[] args)
    {
        Person p = new Person("John", 32, "Male");
        Console.WriteLine(p);

        Citizen c = new Citizen("Smith", 31, 1234, "Male");
        Console.WriteLine(c);
    }
}
