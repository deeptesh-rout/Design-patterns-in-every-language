using System;

// Desired Interface
interface Shape
{
    void Draw();
}

// Circle class
class Circle : Shape
{
    private int x, y, radius;

    public Circle(int x, int y, int r)
    {
        this.x = x;
        this.y = y;
        this.radius = r;
    }

    public void Draw()
    {
        Console.WriteLine("Draw the Circle.");
    }
}

// Rectangle class (Adaptee)
class Rectangle
{
    private int x, y, length, width;

    public Rectangle(int x, int y, int l, int w)
    {
        this.x = x;
        this.y = y;
        this.length = l;
        this.width = w;
    }

    public void OldDraw()
    {
        Console.WriteLine("Drawing Rectangle.");
    }
}

// RectangleAdapter class
class RectangleAdapter : Shape
{
    private Rectangle adaptee;

    public RectangleAdapter(int x, int y, int l, int w)
    {
        this.adaptee = new Rectangle(x, y, l, w);
    }

    public void Draw()
    {
        adaptee.OldDraw();
    }
}

// Client Code
public class AdapterPatternRectangle
{
    public static void Main(string[] args)
    {
        Shape adapter = new RectangleAdapter(1, 2, 3, 4);
        adapter.Draw();
    }
}

/* 
Drawing Rectangle.
*/
