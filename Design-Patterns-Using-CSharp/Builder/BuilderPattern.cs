using System;

// Define the Product class with two parts
class Product
{
    private string partA;
    private string partB;

    public Product(string A, string B)
    {
        this.partA = A;
        this.partB = B;
    }
    public void SetPartA(string A)
    {
        this.partA = A;
    }

    public void SetPartB(string B)
    {
        this.partB = B;
    }

    public override string ToString()
    {
        return $"Product: ({partA}, {partB})";
    }
}

// Define an abstract class called Builder
abstract class Builder
{
    protected Product product;

    public Builder()
    {
        this.product = new Product("A default", "B default");
    }

    public abstract Builder SetPartA(string A);

    public abstract Builder SetPartB(string B);

    public Product GetProduct()
    {
        Product temp = this.product;
        this.product = new Product("A default", "B default"); // assign new product.
        return temp;
    }
}

// Define a ConcreteBuilder class that extends Builder
class ConcreteBuilder : Builder
{
    public override Builder SetPartA(string A)
    {
        this.product.SetPartA(A);
        return this;
    }

    public override Builder SetPartB(string B)
    {
        this.product.SetPartB(B);
        return this;
    }
}

// Define a Director class that takes a builder object as a parameter
class Director
{
    private Builder builder;

    public Director(Builder builder)
    {
        this.builder = builder;
    }

    public Product Construct()
    {
        return this.builder.SetPartA("A1").SetPartB("B1").GetProduct();
    }

    public Product Construct2()
    {
        this.builder.SetPartA("A2");
        this.builder.SetPartB("B2");
        return this.builder.GetProduct();
    }

    public Product Construct3()
    {
        return this.builder.SetPartA("A3").GetProduct();
    }
}

// Client code
public class BuilderPattern
{
    public static void Main(string[] args)
    {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);

        Product product = director.Construct();
        Console.WriteLine(product);

        Product product2 = director.Construct2();
        Console.WriteLine(product2);

        Product product3 = director.Construct3();
        Console.WriteLine(product3);
    }
}

/*
Product: (A1, B1)
Product: (A2, B2)
Product: (A3, B default)
*/