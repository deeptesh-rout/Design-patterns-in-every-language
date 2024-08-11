#include <iostream>
#include <string>
#include <sstream>

class Model {
private:
    std::string data = "Default.";

public:
    void setData(const std::string& data) {
        std::cout << "Model: Set data." << std::endl;
        this->data = data;
    }

    std::string getData() {
        std::cout << "Model: Get data." << std::endl;
        return data;
    }
};

class ViewModel {
private:
    Model* model;

public:
    ViewModel(Model* model) : model(model) {}

    void setData(const std::string& data) {
        std::cout << "ViewModel: Set data." << std::endl;
        model->setData(data);
    }

    std::string getData() {
        std::cout << "ViewModel: Get data." << std::endl;
        return model->getData();
    }
};

class View {
private:
    ViewModel* viewModel;

public:
    View(ViewModel* viewModel) : viewModel(viewModel) {}

    void displayData() {
        std::cout << "Display Data: " << viewModel->getData() << std::endl;
    }

    void getUserInput() {
        std::cout << "View: Enter user input: ";
        std::string userInput;
        userInput = "Hello, World!";
        std::cout << userInput << std::endl;
        // std::getline(std::cin, userInput); // Uncomment for user input
        viewModel->setData(userInput);
    }
};

// Client code
int main() {
    Model model;
    ViewModel viewModel(&model);
    View view(&viewModel);

    // Display initial data
    view.displayData();

    // Get user input and update data
    view.getUserInput();

    // Display updated data
    view.displayData();

    return 0;
}

/*
Display Data: ViewModel: Get data.
Model: Get data.
Default.
View: Enter user input: Hello, World!
ViewModel: Set data.
Model: Set data.
Display Data: ViewModel: Get data.
Model: Get data.
Hello, World!
*/