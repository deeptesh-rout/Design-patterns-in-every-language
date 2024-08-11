using System;

public abstract class Printer
{
    public abstract void Print(string document);

    public abstract void Scan();

    public abstract void Fax(string document);
}

public interface Printable
{
    void Print(string document);
}

public interface Scannable
{
    void Scan();
}

public interface Faxable
{
    void Fax(string document);
}

public class BasicInkjetPrinter : Printable
{
    public void Print(string document)
    {
        Console.WriteLine($"Printing {document} using basic inkjet printer");
    }
}

public class HighEndOfficePrinter : Printable, Scannable, Faxable
{
    public void Print(string document)
    {
        Console.WriteLine($"Printing {document} using high end office printer");
    }

    public void Scan()
    {
        Console.WriteLine("Scanning using high end office printer");
    }

    public void Fax(string document)
    {
        Console.WriteLine($"Faxing {document} using high end office printer");
    }
}

// Client code
public class InterfaceSegregationPrinciple
{
    public static void Main(string[] args)
    {
        // BasicInkjetPrinter
        BasicInkjetPrinter basicPrinter = new BasicInkjetPrinter();
        basicPrinter.Print("Sample Document");

        // HighEndOfficePrinter
        HighEndOfficePrinter officePrinter = new HighEndOfficePrinter();
        officePrinter.Print("Important Report");
        officePrinter.Scan();
        officePrinter.Fax("Confidential Memo");
    }
}

/*
Printing Sample Document using basic inkjet printer
Scanning using basic inkjet printer
Printing Important Report using high end office printer
Scanning using high end office printer
Faxing Confidential Memo using high end office printer
*/