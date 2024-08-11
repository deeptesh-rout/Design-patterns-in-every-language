using System;

class Person
{
    protected string name;
    protected string oath;

    public Person(string name)
    {
        this.name = name;
    }

    public override string ToString()
    {
        return "Person: " + name + ":" + oath;
    }

    public void SetOath()
    {
        this.oath = "Always tell the truth";
    }
}

class Citizen : Person
{
    private int id;

    public Citizen(string name, int id) : base(name)
    {
        this.id = id;
    }

    public new void SetOath()
    {
        this.oath = "Country comes first";
    }
}

public class FunctionOverriding
{
    public static void Main(string[] args)
    {
        Person p = new Person("John");
        p.SetOath();
        Console.WriteLine(p.ToString());

        Citizen c = new Citizen("Smith", 31);
        c.SetOath();
        Console.WriteLine(c.ToString());
    }
}
