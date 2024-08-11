#include <iostream>
#include <vector>
#include <string>
#include <memory>
#include <sstream>
#include <algorithm>


// Observer interface
class Observer {
public:
    virtual void update() = 0;
};


// Model
class Model {
private:
    std::string data;
    std::vector<Observer*> observers;

public:
    void setData(std::string d) {
        std::cout << "Model : Set data." << std::endl;
        data = d;
        notifyObservers();
    }

    std::string getData() {
        std::cout << "Model : Get data." << std::endl;
        return data;
    }

    void addObserver(Observer* observer) {
        observers.push_back(observer);
    }

    void removeObserver(Observer* observer) {
        observers.erase(std::remove(observers.begin(), observers.end(), observer), observers.end());
    }

    void notifyObservers() {
        std::cout << "Model : Notify observers." << std::endl;
        for (auto observer : observers) {
            observer->update();
        }
    }
};



// View
class View  : public Observer {
private:
    class Controller* controller;
    Model* model;

public:
    View(Model* model, Controller* controller) : model(model), controller(controller) {
        model->addObserver(this);
    }

    void update() {
        std::cout << "View : Update." << std::endl;
        std::string data = model->getData();
        std::cout << "Data: " << data << std::endl;
    }

    void getUserInput() ;
};

// Controller
class Controller {
private:
    Model* model;
    View* view;

public:
    Controller(Model* model) : model(model) {}

    void handleUserInput(std::string userInput) {
        std::cout << "Controller : Handle user input." << std::endl;
        model->setData(userInput);
    }

    void setView(View* v) {
        this->view = v;
    }

    void update() {
        view->update();
    }
};

void View::getUserInput() 
{
    std::cout << "View : Enter user input: ";
    //std::string userInput;
    std::string userInput = "Hello, World!";
    std::cout << userInput << std::endl;
    // std::getline(std::cin, userInput); // Uncomment for user input    
    controller->handleUserInput(userInput);
}

// Client code
int main() {
    Model model;
    Controller controller(&model);
    View view(&model, &controller);
    controller.setView(&view);
    view.getUserInput();
    return 0;
}

/*
View : Enter user input: Hello, World!
Controller : Handle user input.
Model : Set data.
Model : Notify observers.
View : Update.
Model : Get data.
Data: Hello, World!
*/