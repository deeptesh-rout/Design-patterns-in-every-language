

import java.util.Scanner;

//Model
class Model {
    private String data = "Default.";

    public void setData(String data) {
        System.out.println("Model: Set data.");
        this.data = data;
    }

    public String getData() {
        System.out.println("Model: Get data.");
        return data;
    }
}

//View
class View {
    private ViewModel viewModel;

    public View(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void displayData() {
        System.out.println("Display Data: " + viewModel.getData());
    }

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("View: Enter user input: ");
        String userInput = scanner.nextLine();
        viewModel.setData(userInput);
    }
}

// ViewModel
class ViewModel {
    private Model model;

    public ViewModel(Model model) {
        this.model = model;
    }

    public void setData(String data) {
        System.out.println("ViewModel: Set data.");
        model.setData(data);
    }

    public String getData() {
        System.out.println("ViewModel: Get data.");
        return model.getData();
    }
}

// Client code
public class MVVM {
    public static void main(String[] args) {
        Model model = new Model();
        ViewModel viewModel = new ViewModel(model);
        View view = new View(viewModel);

        // Display initial data
        view.displayData();

        // Get user input and update data
        view.getUserInput();

        // Display updated data
        view.displayData();
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