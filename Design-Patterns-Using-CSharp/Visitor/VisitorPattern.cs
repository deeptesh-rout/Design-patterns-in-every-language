using System;

// Element interface
interface Element
{
    void Accept(Visitor visitor);
}

// ConcreteElementA class
class ConcreteElementA : Element
{
    public void Accept(Visitor visitor)
    {
        visitor.VisitElementA(this);
    }
}

// ConcreteElementB class
class ConcreteElementB : Element
{
    public void Accept(Visitor visitor)
    {
        visitor.VisitElementB(this);
    }
}

// Visitor interface
interface Visitor
{
    void VisitElementA(ConcreteElementA elementA);
    void VisitElementB(ConcreteElementB elementB);
}

// ConcreteVisitor1 class
class ConcreteVisitor1 : Visitor
{
    public void VisitElementA(ConcreteElementA elementA)
    {
        Console.WriteLine("ConcreteVisitor1 VisitElementA() method called.");
    }

    public void VisitElementB(ConcreteElementB elementB)
    {
        Console.WriteLine("ConcreteVisitor1 VisitElementB() method called.");
    }
}

// ConcreteVisitor2 class
class ConcreteVisitor2 : Visitor
{
    public void VisitElementA(ConcreteElementA elementA)
    {
        Console.WriteLine("ConcreteVisitor2 VisitElementA() method called.");
    }

    public void VisitElementB(ConcreteElementB elementB)
    {
        Console.WriteLine("ConcreteVisitor2 VisitElementB() method called.");
    }
}

// Client code
class VisitorPattern
{
    static void Main(string[] args)
    {
        Visitor visitor1 = new ConcreteVisitor1();
        Element elementA = new ConcreteElementA();
        elementA.Accept(visitor1);

        Element elementB = new ConcreteElementB();
        elementB.Accept(visitor1);
    }
}
