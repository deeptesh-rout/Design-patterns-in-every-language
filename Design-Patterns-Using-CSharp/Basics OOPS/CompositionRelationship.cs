using System;
using System.Collections.Generic;

class Tyre
{
    private string type;

    public Tyre(string type)
    {
        this.type = type;
    }

    public string GetType()
    {
        return type;
    }
}

class Car
{
    private string model;
    private List<Tyre> tyres;

    public Car(string model)
    {
        this.model = model;
        this.tyres = new List<Tyre>();
        for (int i = 0; i < 4; i++)
        {
            this.tyres.Add(new Tyre("MRF"));
        }
    }

    public void Display()
    {
        Console.WriteLine("Car: " + model + ", Tyre: " + tyres[0].GetType());
    }
}

public class CompositionRelationship
{
    public static void Main(string[] args)
    {
        Car car = new Car("BMW");
        car.Display();
    }
}
