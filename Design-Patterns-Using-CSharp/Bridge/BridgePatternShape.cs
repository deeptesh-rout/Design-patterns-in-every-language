using System;

// Abstraction abstract class
abstract class Shape
{
    protected Colour imp;

    public Shape(Colour imp)
    {
        this.imp = imp;
    }

    public abstract void Draw();
}

// Rectangle class
class Rectangle : Shape
{
    public Rectangle(Colour imp) : base(imp)
    {
    }

    public override void Draw()
    {
        Console.WriteLine("Drawing Rectangle with colour " + imp.Fill());
    }
}

// Circle class
class Circle : Shape
{
    public Circle(Colour imp) : base(imp)
    {
    }

    public override void Draw()
    {
        Console.WriteLine("Drawing Circle with colour " + imp.Fill());
    }
}

// Colour abstract class
abstract class Colour
{
    public abstract string Fill();
}

// Red class
class Red : Colour
{
    public override string Fill()
    {
        return "Red";
    }
}

// Green class
class Green : Colour
{
    public override string Fill()
    {
        return "Green";
    }
}

// Blue class
class Blue : Colour
{
    public override string Fill()
    {
        return "Blue";
    }
}

// Client code
class BridgePatternShape
{
    static void Main(string[] args)
    {
        Colour c1 = new Red();
        Shape abstraction = new Circle(c1);
        abstraction.Draw();

        Colour c2 = new Green();
        abstraction = new Rectangle(c2);
        abstraction.Draw();
    }
}

/*
Drawing Circle with colour Red
Drawing Rectangle with colour Green
*/