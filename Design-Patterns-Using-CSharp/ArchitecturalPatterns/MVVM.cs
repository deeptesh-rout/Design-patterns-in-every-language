using System;

// Model
class Model
{
    private string data = "Default.";

    public void SetData(string data)
    {
        Console.WriteLine("Model: Set data.");
        this.data = data;
    }

    public string GetData()
    {
        Console.WriteLine("Model: Get data.");
        return data;
    }
}

// ViewModel
class ViewModel
{
    private Model model;

    public ViewModel(Model model)
    {
        this.model = model;
    }

    public void SetData(string data)
    {
        Console.WriteLine("ViewModel: Set data.");
        model.SetData(data);
    }

    public string GetData()
    {
        Console.WriteLine("ViewModel: Get data.");
        return model.GetData();
    }
}

// View
class View
{
    private ViewModel viewModel;

    public View(ViewModel viewModel)
    {
        this.viewModel = viewModel;
    }

    public void DisplayData()
    {
        Console.WriteLine("Display Data: " + viewModel.GetData());
    }

    public void GetUserInput()
    {
        Console.Write("View: Enter user input: ");
        string userInput = Console.ReadLine();
        viewModel.SetData(userInput);
    }
}

// Client code
class MVVM
{
    public static void Main(string[] args)
    {
        Model model = new Model();
        ViewModel viewModel = new ViewModel(model);
        View view = new View(viewModel);

        // Display initial data
        view.DisplayData();

        // Get user input and update data
        view.GetUserInput();

        // Display updated data
        view.DisplayData();
    }
}

/*
ViewModel: Get data.
Model: Get data.
Display Data: Default.
View: Enter user input: hello, world!
ViewModel: Set data.
Model: Set data.
ViewModel: Get data.
Model: Get data.
Display Data: hello, world!
*/