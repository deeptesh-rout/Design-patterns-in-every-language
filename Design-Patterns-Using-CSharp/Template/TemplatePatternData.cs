using System;

abstract class AddDataTemplate
{
    // The template method
    public void AddData()
    {
        Open();
        Add();
        Close();
    }

    // Primitive operation: Open
    protected abstract void Open();

    // Primitive operation: Add
    protected abstract void Add();

    // Primitive operation: Close
    protected abstract void Close();
}

class AddDataToFile : AddDataTemplate
{
    protected override void Open()
    {
        Console.WriteLine("Open file.");
    }

    protected override void Add()
    {
        Console.WriteLine("Add data to file.");
    }

    protected override void Close()
    {
        Console.WriteLine("Close file.");
    }
}

class AddDataToDB : AddDataTemplate
{
    protected override void Open()
    {
        Console.WriteLine("Open Database.");
    }

    protected override void Add()
    {
        Console.WriteLine("Add data to Database.");
    }

    protected override void Close()
    {
        Console.WriteLine("Close Database.");
    }
}

// Client code
class TemplatePatternData
{
    public static void Main(string[] args)
    {
        AddDataTemplate addDataToDB = new AddDataToDB();
        addDataToDB.AddData();
    }
}
