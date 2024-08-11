// Model
class Model {
    constructor() {
        this.data = "Hello";
    }

    setData(data) {
        console.log("Model: Set data: " + data);
        this.data = data;
    }

    getData() {
        console.log("Model: Get data: " + this.data);
        return this.data;
    }
}

// View
class View {
    getUserInput() {
        console.log("View: getUserInput");
        console.log("View: Enter user input: ");
        const userInput = "Hello, World!";
        console.log(userInput);
        
        return userInput;
    }

    getUserInput2() {
        console.log("View: getUserInput");
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });

        readline.question('View : Enter user input: ', userInput => {
            this.controller.handleUserInput(userInput);
            readline.close();
        });
    }

    displayData(data) {
        console.log("View: Display Result: " + data);
    }
}

// Presenter
class Presenter {
    constructor(model, view) {
        this.model = model;
        this.view = view;
    }

    onButtonClick() {
        console.log("Presenter: onButtonClick.");
        const data = this.view.getUserInput();
        this.model.setData(data);
        const newData = this.model.getData();
        this.view.displayData(newData);
    }
}

// Client code
const model = new Model();
const view = new View();
const presenter = new Presenter(model, view);
presenter.onButtonClick();
