// Model
class Model {
    constructor() {
        this.data = "Default.";
    }

    setData(data) {
        console.log("Model: Set data.");
        this.data = data;
    }

    getData() {
        console.log("Model: Get data.");
        return this.data;
    }
}

// ViewModel
class ViewModel {
    constructor(model) {
        this.model = model;
    }

    setData(data) {
        console.log("ViewModel: Set data.");
        this.model.setData(data);
    }

    getData() {
        console.log("ViewModel: Get data.");
        return this.model.getData();
    }
}

// View
class View {
    constructor(viewModel) {
        this.viewModel = viewModel;
    }

    displayData() {
        console.log("Display Data: " + this.viewModel.getData());
    }

    getUserInput() {
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });

        readline.question('View : Enter user input: ', userInput => {
            this.viewModel.setData(userInput);
            readline.close();
        });
    }
}

// Client code
const model = new Model();
const viewModel = new ViewModel(model);
const view = new View(viewModel);

// Display initial data
view.displayData();

// Get user input and update data
view.getUserInput();

// Display updated data
view.displayData();
