using System;
using System.Collections.Generic;

// Abstract Element class
abstract class Element
{
    public abstract double Accept(Visitor visitor);
    public abstract double Price();
}

// Book class
class Book : Element
{
    private double price;
    private int isbn;

    public Book(double price, int isbn)
    {
        this.price = price;
        this.isbn = isbn;
    }

    public override double Price()
    {
        return price;
    }

    public override double Accept(Visitor visitor)
    {
        return visitor.VisitBook(this);
    }
}

// Fruit class
class Fruit : Element
{
    private double price;
    private int quantity;
    private string type;

    public Fruit(double price, int quantity, string type)
    {
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public override double Price()
    {
        return price;
    }

    public override double Accept(Visitor visitor)
    {
        return visitor.VisitFruit(this) * quantity;
    }
}

// Abstract Visitor class
abstract class Visitor
{
    public abstract double VisitBook(Book book);
    public abstract double VisitFruit(Fruit fruit);
}

// SundayDiscount class
class SundayDiscount : Visitor
{
    public override double VisitBook(Book book)
    {
        return book.Price() - 50;
    }

    public override double VisitFruit(Fruit fruit)
    {
        return fruit.Price() - 5;
    }
}

// SaleDiscount class
class SaleDiscount : Visitor
{
    public override double VisitBook(Book book)
    {
        return book.Price() / 2;
    }

    public override double VisitFruit(Fruit fruit)
    {
        return fruit.Price() / 2;
    }
}

// ShoppingCart class
class ShoppingCart
{
    private List<Element> list = new List<Element>();
    private Visitor visitor;

    public void Add(Element element)
    {
        list.Add(element);
    }

    public void SetDiscountVisitor(Visitor discount)
    {
        this.visitor = discount;
    }

    public void Accept()
    {
        double cost = 0;
        foreach (Element element in list)
        {
            cost += element.Accept(visitor);
        }
        Console.WriteLine("Total cost: " + cost);
    }
}

// Client code
class VisitorShopping
{
    static void Main(string[] args)
    {
        ShoppingCart cart = new ShoppingCart();
        cart.Add(new Fruit(100, 10, "Apple"));
        cart.Add(new Book(100, 12345));

        cart.SetDiscountVisitor(new SundayDiscount());
        cart.Accept();

        cart.SetDiscountVisitor(new SaleDiscount());
        cart.Accept();
    }
}
