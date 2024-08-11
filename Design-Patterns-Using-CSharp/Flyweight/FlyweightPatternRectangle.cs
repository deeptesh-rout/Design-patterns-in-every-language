using System;
using System.Collections.Generic;

// Shape abstract class
abstract class Shape
{
    protected int colour; // Intrinsic State

    public Shape(int colour)
    {
        this.colour = colour;
    }

    public abstract void Draw(int x1, int y1, int x2, int y2); // Extrinsic State
}

// Rectangle class
class Rectangle : Shape
{
    public Rectangle(int colour) : base(colour)
    {
    }

    public override void Draw(int x1, int y1, int x2, int y2)
    {
        Console.WriteLine($"Draw Rectangle colour:{colour} topleft: ({x1},{y1}) rightBottom: ({x2},{y2})");
    }
}

// RectangleFactory class
class RectangleFactory
{
    private Dictionary<int, Shape> shapes = new Dictionary<int, Shape>();

    public Shape GetRectangle(int colour)
    {
        if (!shapes.ContainsKey(colour))
        {
            shapes[colour] = new Rectangle(colour);
        }
        return shapes[colour];
    }

    public int GetCount()
    {
        return shapes.Count;
    }
}

// Client code
class FlyweightPatternRectangle
{
    static void Main(string[] args)
    {
        RectangleFactory factory = new RectangleFactory();
        Random random = new Random();

        for (int i = 0; i < 1000; i++)
        {
            Shape rect = factory.GetRectangle(random.Next(1000));
            rect.Draw(random.Next(100), random.Next(100), random.Next(100), random.Next(100));
        }

        Console.WriteLine(factory.GetCount());
    }
}
