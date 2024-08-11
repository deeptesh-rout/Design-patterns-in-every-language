using System;

// Abstraction
abstract class Shape
{
    protected DrawingAPI Implementation;

    public Shape(DrawingAPI implementation)
    {
        Implementation = implementation;
    }

    public abstract void Draw();
}

// Concrete Abstraction
class Square : Shape
{
    public Square(DrawingAPI implementation) : base(implementation)
    {
    }

    public override void Draw()
    {
        Implementation.DrawSquare();
    }
}

class Circle : Shape
{
    public Circle(DrawingAPI implementation) : base(implementation)
    {
    }

    public override void Draw()
    {
        Implementation.DrawCircle();
    }
}

// Implementation
interface DrawingAPI
{
    void DrawSquare();
    void DrawCircle();
}

// Concrete Implementation
class WindowsAPI : DrawingAPI
{
    public void DrawSquare()
    {
        Console.WriteLine("Drawing a square on Windows.");
    }

    public void DrawCircle()
    {
        Console.WriteLine("Drawing a circle on Windows.");
    }
}

class MacAPI : DrawingAPI
{
    public void DrawSquare()
    {
        Console.WriteLine("Drawing a square on Mac.");
    }

    public void DrawCircle()
    {
        Console.WriteLine("Drawing a circle on Mac.");
    }
}

// Client code
public class BridgePatternShape2
{
    public static void Main(string[] args)
    {
        DrawingAPI windowsAPI = new WindowsAPI();
        DrawingAPI macAPI = new MacAPI();

        Shape square = new Square(windowsAPI);
        square.Draw();  // Output: Drawing a square on Windows.

        Shape circle = new Circle(macAPI);
        circle.Draw();  // Output: Drawing a circle on Mac.
    }
}
