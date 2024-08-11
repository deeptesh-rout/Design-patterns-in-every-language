using System;
using System.Collections.Generic;

abstract class Shape : ICloneable
{
    protected string color;

    public Shape()
    {
        this.color = "Black";
    }

    public abstract override string ToString();

    public object Clone()
    {
        return MemberwiseClone();
    }

    public abstract Shape CloneShape();
}

class Rectangle : Shape
{
    public override string ToString()
    {
        return "Rectangle of colour " + color;
    }

    public override Shape CloneShape()
    {
        try
        {
            return (Shape)Clone();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.StackTrace);
            return null;
        }
    }
}

class Circle : Shape
{
    public override string ToString()
    {
        return "Circle of colour " + color;
    }

    public override Shape CloneShape()
    {
        try
        {
            return (Shape)Clone();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.StackTrace);
            return null;
        }
    }
}

class ShapeRegistry
{
    private static readonly Dictionary<string, Shape> Shapes = new Dictionary<string, Shape>();

    static ShapeRegistry()
    {
        Load();
    }

    public static void AddShape(string key, Shape value)
    {
        Shapes[key] = value;
    }

    public static Shape GetShape(string key)
    {
        if (Shapes.ContainsKey(key))
        {
            return Shapes[key].CloneShape();
        }
        return null;
    }

    public static void Load()
    {
        AddShape("circle", new Circle());
        AddShape("rectangle", new Rectangle());
    }
}

// Client code

public class PrototypePatternShape
{
    public static void Main(string[] args)
    {
        ShapeRegistry.Load();
        Shape c = ShapeRegistry.GetShape("circle");
        Shape r = ShapeRegistry.GetShape("rectangle");
        Console.WriteLine(c);
        Console.WriteLine(r);
    }
}

/*
Circle of colour Black
Rectangle of colour Black
 */
