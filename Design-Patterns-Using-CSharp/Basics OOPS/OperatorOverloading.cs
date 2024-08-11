using System;

class Rectangle
{
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }

    public double Area()
    {
        return length * breadth;
    }

    public double Perimeter()
    {
        return 2 * (length + breadth);
    }

    // Overloading + operator
    public Rectangle Add(Rectangle rec)
    {
        return new Rectangle(this.length + rec.length, this.breadth + rec.breadth);
    }

    // Overloading - operator
    public Rectangle Subtract(Rectangle rec)
    {
        return new Rectangle(Math.Abs(this.length - rec.length), Math.Abs(this.breadth - rec.breadth));
    }

    // Overloading == operator
    public bool Equals(Rectangle rec)
    {
        return this.length == rec.length && this.breadth == rec.breadth;
    }

    // Overriding ToString method
    public override string ToString()
    {
        return $"Rectangle length and width: {length} {breadth}";
    }
}

public class OperatorOverloading
{
    public static void Main(string[] args)
    {
        Rectangle r1 = new Rectangle(4, 6);
        Rectangle r2 = new Rectangle(10, 6);

        Console.WriteLine($"Is r1 == r2 ? {r1.Equals(r2)}");

        Rectangle r3 = r1.Add(r2);
        Rectangle r4 = r1.Subtract(r2);

        Console.WriteLine(r1);
        Console.WriteLine(r2);
        Console.WriteLine(r3);
        Console.WriteLine(r4);
    }
}
