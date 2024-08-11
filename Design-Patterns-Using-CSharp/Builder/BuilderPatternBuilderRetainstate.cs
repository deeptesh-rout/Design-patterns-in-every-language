using System;

class Product
{
    private string partA;
    private string partB;

    public Product(string A, string B)
    {
        this.partA = A;
        this.partB = B;
    }

    public override string ToString()
    {
        return $"Product: ({partA}, {partB})";
    }
}

abstract class Builder
{
    public abstract Builder SetPartA(string A);
    public abstract Builder SetPartB(string B);
    public abstract Product GetProduct();
}

class ConcreteBuilder : Builder
{
    private string partA;
    private string partB;

    public override Builder SetPartA(string A)
    {
        this.partA = A;
        return this; // Returning this helps in chaining calls.
    }

    public override Builder SetPartB(string B)
    {
        this.partB = B;
        return this;
    }

    public override Product GetProduct()
    {
        return new Product(partA, partB);
    }
}

class Director
{
    private Builder builder;

    public Director(Builder builder)
    {
        this.builder = builder;
    }

    public Product Construct()
    {
        return builder.SetPartA("A1").SetPartB("B1").GetProduct(); // Chaining calls
    }

    public Product Construct2()
    {
        builder.SetPartA("A2");
        builder.SetPartB("B2");
        return builder.GetProduct();
    }
}

// Client code
public class BuilderPatternBuilderRetainState
{
    public static void Main(string[] args)
    {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);

        Product product = director.Construct();
        Console.WriteLine(product);

        Product product2 = director.Construct2();
        Console.WriteLine(product2);
    }
}
