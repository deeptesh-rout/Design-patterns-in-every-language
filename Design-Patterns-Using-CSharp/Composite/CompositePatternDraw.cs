using System;
using System.Collections.Generic;

// IShape
interface IShape
{
    void Move(int x, int y);
    string Draw();
}

// Rectangle
class Rectangle : IShape
{
    private int x, y, length, breadth;

    public Rectangle(int x, int y, int length, int breadth)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.breadth = breadth;
    }

    public void Move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    public string Draw()
    {
        Console.WriteLine($"Draw a Rectangle at ({x}, {y}) of Length: {length} and Breadth: {breadth}");
        return "<Rectangle>";
    }
}

// Circle
class Circle : IShape
{
    private int x, y, radius;

    public Circle(int x, int y, int radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void Move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    public string Draw()
    {
        Console.WriteLine($"Draw a Circle of radius {radius} at ({x}, {y}).");
        return "<Circle>";
    }
}

// CompoundShape
class CompoundShape : IShape
{
    private List<IShape> children = new List<IShape>();

    public void Add(IShape child)
    {
        children.Add(child);
    }

    public void Remove(IShape child)
    {
        children.Remove(child);
    }

    public void Move(int x, int y)
    {
        foreach (IShape child in children)
        {
            child.Move(x, y);
        }
    }

    public string Draw()
    {
        string st = "Shapes(";
        foreach (IShape child in children)
        {
            st += child.Draw();
        }
        st += ")";
        return st;
    }
}

// Client code
class CompositePatternDraw
{
    static void Main(string[] args)
    {
        CompoundShape all = new CompoundShape();
        all.Add(new Rectangle(1, 2, 1, 2));
        all.Add(new Circle(5, 3, 10));

        CompoundShape group = new CompoundShape();
        group.Add(new Rectangle(5, 7, 1, 2));
        group.Add(new Circle(2, 1, 2));

        all.Add(group);
        Console.WriteLine(all.Draw());
    }
}

/*
Draw a Rectangle at (1, 2) of Length: 1 and Breadth: 2
Draw a Circle of radius 10 at (5, 3).
Draw a Rectangle at (5, 7) of Length: 1 and Breadth: 2
Draw a Circle of radius 2 at (2, 1).
Shapes(<Rectangle><Circle>Shapes(<Rectangle><Circle>))
*/