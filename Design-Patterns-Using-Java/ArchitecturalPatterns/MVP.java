import java.util.Scanner;

// Model
class Model {
    private String data;

    public Model() {
        this.data = "Hello";
    }

    public void setData(String data) {
        System.out.println("Model: Set data: " + data);
        this.data = data;
    }

    public String getData() {
        System.out.println("Model: Get data: " + this.data);
        return this.data;
    }
}

// View
class View {
    public String getUserInput() {
        System.out.println("View: getUserInput");
        Scanner scanner = new Scanner(System.in);
        System.out.print("View: Enter user input: ");
        String userInput = "Hello, World!";
        System.out.println(userInput);
        //String userInput = scanner.nextLine();
        return userInput;
    }

    public void displayData(String data) {
        System.out.println("View: Display Result: " + data);
    }
}

// Presenter
class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void onButtonClick() {
        System.out.println("Presenter: onButtonClick.");
        String data = this.view.getUserInput();
        this.model.setData(data);
        data = this.model.getData();
        this.view.displayData(data);
    }
}

// Main class
public class MVP {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(model, view);
        presenter.onButtonClick();
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