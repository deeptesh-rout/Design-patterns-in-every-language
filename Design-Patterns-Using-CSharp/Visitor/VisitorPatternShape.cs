using System;
using System.Collections.Generic;

// Abstract Shape class
abstract class Shape
{
    public abstract void Accept(Visitor visitor);
}

// Circle class
class Circle : Shape
{
    private int x, y, radius;

    public Circle(int x, int y, int radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public override void Accept(Visitor visitor)
    {
        visitor.VisitCircle(this);
    }

    public int GetX()
    {
        return x;
    }

    public int GetY()
    {
        return y;
    }

    public int GetRadius()
    {
        return radius;
    }
}

// Rectangle class
class Rectangle : Shape
{
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public override void Accept(Visitor visitor)
    {
        visitor.VisitRectangle(this);
    }

    public int GetX()
    {
        return x;
    }

    public int GetY()
    {
        return y;
    }

    public int GetWidth()
    {
        return width;
    }

    public int GetHeight()
    {
        return height;
    }
}

// Abstract Visitor class
abstract class Visitor
{
    public abstract void VisitCircle(Circle circle);
    public abstract void VisitRectangle(Rectangle rectangle);
}

// XMLVisitor class
class XMLVisitor : Visitor
{
    public override void VisitCircle(Circle circle)
    {
        Console.WriteLine($"<circle>\n  <x>{circle.GetX()}</x>\n  <y>{circle.GetY()}</y>\n  <radius>{circle.GetRadius()}</radius>\n</circle>");
    }

    public override void VisitRectangle(Rectangle rectangle)
    {
        Console.WriteLine($"<rectangle>\n  <x>{rectangle.GetX()}</x>\n  <y>{rectangle.GetY()}</y>\n  <width>{rectangle.GetWidth()}</width>\n  <height>{rectangle.GetHeight()}</height>\n</rectangle>");
    }
}

// TextVisitor class
class TextVisitor : Visitor
{
    public override void VisitCircle(Circle circle)
    {
        Console.WriteLine($"Circle ( (x : {circle.GetX()}, y : {circle.GetY()}), radius : {circle.GetRadius()})");
    }

    public override void VisitRectangle(Rectangle rectangle)
    {
        Console.WriteLine($"Rectangle ( (x : {rectangle.GetX()}, y : {rectangle.GetY()}), width : {rectangle.GetWidth()}, height : {rectangle.GetHeight()})");
    }
}

// ObjectsStructure class
class ObjectsStructure
{
    private List<Shape> shapes = new List<Shape>();
    private Visitor visitor;

    public void AddShape(Shape shape)
    {
        shapes.Add(shape);
    }

    public void SetVisitor(Visitor visitor)
    {
        this.visitor = visitor;
    }

    public void Accept()
    {
        foreach (var shape in shapes)
        {
            shape.Accept(visitor);
        }
    }
}

// Client code
class VisitorPatternShape
{
    static void Main(string[] args)
    {
        ObjectsStructure os = new ObjectsStructure();
        os.AddShape(new Rectangle(6, 7, 8, 9));
        os.AddShape(new Circle(6, 7, 8));

        os.SetVisitor(new XMLVisitor());
        os.Accept();

        os.SetVisitor(new TextVisitor());
        os.Accept();
    }
}
