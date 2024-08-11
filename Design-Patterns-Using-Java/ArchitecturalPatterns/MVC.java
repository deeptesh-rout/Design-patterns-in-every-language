import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Model
class Model {
    private String data;
    private List<View> observers;

    public Model() {
        this.observers = new ArrayList<>();
    }

    public void setData(String data) {
        System.out.println("Model : Set data.");
        this.data = data;
        notifyObservers();
    }

    public String getData() {
        System.out.println("Model : Get data.");
        return this.data;
    }

    public void addObserver(View observer) {
        this.observers.add(observer);
    }

    public void removeObserver(View observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        System.out.println("Model : Notify observers.");
        for (View observer : observers) {
            observer.update();
        }
    }
}

// View
class View {
    private Controller controller;
    private Model model;

    public View(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
        this.model.addObserver(this);
    }

    public void update() {
        System.out.println("View : Update.");
        String data = model.getData();
        System.out.println("Data: " + data);
    }

    public void getUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("View : Enter user input: ");
            //String userInput = "hello, world!";
            //System.out.println(userInput);
            String userInput = scanner.nextLine();
            controller.handleUserInput(userInput);
        }
    }
}

// Controller
class Controller {
    private Model model;
    private View view;

    public Controller(Model m) {
        this.model = m;
    }

    public void handleUserInput(String userInput) {
        System.out.println("Controller : Handle user input.");
        model.setData(userInput);
        // Can inform view about action.
    }

    public void setView(View v) {
        this.view = v;
    }
}

// Main class
public class MVC {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);  // The Controller sets itself as the observer in this case
        View view = new View(model, controller);
        controller.setView(view);
        view.getUserInput();
    }
}

/*
View : Enter user input: hello, world!
Controller : Handle user input.
Model : Set data.
Model : Notify observers.
View : Update.
Model : Get data.
Data: hello, world!
 */