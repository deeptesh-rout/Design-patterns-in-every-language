#include <iostream>
#include <string>

class Model {
private:
    std::string data;

public:
    Model() : data("Hello") {}

    void setData(const std::string& data) {
        std::cout << "Model: Set data: " << data << std::endl;
        this->data = data;
    }

    std::string getData() {
        std::cout << "Model: Get data: " << this->data << std::endl;
        return this->data;
    }
};

class View {
public:
    std::string getUserInput() {
        std::cout << "View: getUserInput" << std::endl;
        std::cout << "View: Enter user input: ";
        std::string userInput = "Hello, World!";
        std::cout << userInput << std::endl;
        // std::getline(std::cin, userInput); // Uncomment for user input
        return userInput;
    }

    void displayData(const std::string& data) {
        std::cout << "View: Display Result: " << data << std::endl;
    }
};

class Presenter {
private:
    Model* model;
    View* view;

public:
    Presenter(Model* model, View* view) : model(model), view(view) {}

    void onButtonClick() {
        std::cout << "Presenter: onButtonClick." << std::endl;
        std::string data = this->view->getUserInput();
        this->model->setData(data);
        data = this->model->getData();
        this->view->displayData(data);
    }
};

// Client code
int main() {
    Model model;
    View view;
    Presenter presenter(&model, &view);
    presenter.onButtonClick();
    return 0;
}

/*
Presenter: onButtonClick.
View: getUserInput
View: Enter user input: Hello, World!
Model: Set data: Hello, World!
Model: Get data: Hello, World!
View: Display Result: Hello, World!
*/