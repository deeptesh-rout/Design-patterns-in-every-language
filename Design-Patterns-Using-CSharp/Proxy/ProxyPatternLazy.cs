using System;

// BookParser Interface
interface IBookParser
{
    int NumPages();
}

// ConcreteBookParser Class
class ConcreteBookParser : IBookParser
{
    private int numPages;

    public ConcreteBookParser()
    {
        Console.WriteLine("Concrete Book Parser Created");
        // Number of pages calculation heavy operation.
        // Suppose this calculation results in 1000 pages.
        this.numPages = 1000;
    }

    public int NumPages()
    {
        Console.WriteLine("Concrete Book Parser Request Method");
        return this.numPages;
    }
}

// LazyBookParserProxy Class
class LazyBookParserProxy : IBookParser
{
    private ConcreteBookParser subject;

    public int NumPages()
    {
        if (subject == null)
        {
            subject = new ConcreteBookParser();
        }
        return subject.NumPages();
    }
}

// Client code
class ProxyPatternLazy
{
    static void Main(string[] args)
    {
        LazyBookParserProxy proxy = new LazyBookParserProxy();
        Console.WriteLine(proxy.NumPages());
    }
}

/*
Concrete Book Parser Created
Concrete Book Parser Request Method
1000
*/
