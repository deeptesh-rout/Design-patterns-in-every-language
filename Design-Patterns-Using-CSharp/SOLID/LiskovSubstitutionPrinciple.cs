using System;

abstract class Animal
{
    protected string name;

    public Animal(string name)
    {
        this.name = name;
    }

    public virtual void MakeSound()
    {
        Console.WriteLine("Animal sound");
    }
}

class Dog : Animal
{
    public Dog(string name) : base(name)
    {
    }

    public override void MakeSound()
    {
        Console.WriteLine("woof woof!");
    }
}

class Cat : Animal
{
    public Cat(string name) : base(name)
    {
    }

    public override void MakeSound()
    {
        Console.WriteLine("meow!");
    }
}

class Rectangle
{
    private int height;
    private int width;

    public Rectangle(int l, int w)
    {
        this.height = l;
        this.width = w;
    }

    public virtual void SetWidth(int w)
    {
        this.width = w;
    }

    public virtual void SetHeight(int h)
    {
        this.height = h;
    }

    public int GetWidth()
    {
        return this.width;
    }

    public int GetHeight()
    {
        return this.height;
    }
}

class Square : Rectangle
{
    public Square(int l) : base(l, l)
    {
    }

    public override void SetWidth(int w)
    {
        base.SetWidth(w);
        base.SetHeight(w);
    }

    public override void SetHeight(int h)
    {
        base.SetWidth(h);
        base.SetHeight(h);
    }
}

public class LiskovSubstitutionPrinciple
{
    private static void TestRect(Rectangle rect)
    {
        rect.SetHeight(10);
        rect.SetWidth(20);
        if (200 == rect.GetHeight() * rect.GetWidth())
            Console.WriteLine("success");
        else
            Console.WriteLine("failure");
    }

    public static void Main(string[] args)
    {
        Rectangle r = new Rectangle(10, 20);
        TestRect(r);
        Square s = new Square(10);
        TestRect(s);
    }
}

/*
success
failure
*/