using System;

// Model
class Model
{
    private string data;

    public Model()
    {
        this.data = "Hello";
    }

    public void SetData(string data)
    {
        Console.WriteLine("Model: Set data: " + data);
        this.data = data;
    }

    public string GetData()
    {
        Console.WriteLine("Model: Get data: " + this.data);
        return this.data;
    }
}

// View
class View
{
    public string GetUserInput()
    {
        Console.WriteLine("View: getUserInput");
        Console.Write("View: Enter user input: ");
        //string userInput = "Hello, World!";
        //Console.WriteLine(userInput);
        string userInput = Console.ReadLine();
        return userInput;
    }

    public void DisplayData(string data)
    {
        Console.WriteLine("View: Display Result: " + data);
    }
}

// Presenter
class Presenter
{
    private Model model;
    private View view;

    public Presenter(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    public void OnButtonClick()
    {
        Console.WriteLine("Presenter: onButtonClick.");
        string data = this.view.GetUserInput();
        this.model.SetData(data);
        data = this.model.GetData();
        this.view.DisplayData(data);
    }
}

// Main class
class MVP
{
    public static void Main(string[] args)
    {
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(model, view);
        presenter.OnButtonClick();
    }
}

/* 
Presenter: onButtonClick.
View: getUserInput
View: Enter user input: Hello, World!
Model: Set data: Hello, World!
Model: Get data: Hello, World!
View: Display Result: Hello, World!
*/
