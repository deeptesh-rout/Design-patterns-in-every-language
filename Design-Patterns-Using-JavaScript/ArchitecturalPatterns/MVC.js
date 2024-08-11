// Model
class Model {
    constructor() {
        this.data = '';
        this.observers = [];
    }

    setData(data) {
        console.log("Model : Set data.");
        this.data = data;
        this.notifyObservers();
    }

    getData() {
        console.log("Model : Get data.");
        return this.data;
    }

    addObserver(observer) {
        this.observers.push(observer);
    }

    removeObserver(observer) {
        this.observers = this.observers.filter(obs => obs !== observer);
    }

    notifyObservers() {
        console.log("Model : Notify observers.");
        this.observers.forEach(observer => observer.update());
    }
}

// View
class View {
    constructor(model, controller) {
        this.model = model;
        this.controller = controller;
        this.model.addObserver(this);
    }

    update() {
        console.log("View : Update.");
        const data = this.model.getData();
        console.log("Data: " + data);
    }

    getUserInput() {
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });

        readline.question('View : Enter user input: ', userInput => {
            this.controller.handleUserInput(userInput);
            readline.close();
        });
    }
}

// Controller
class Controller {
    constructor(model) {
        this.model = model;
    }

    handleUserInput(userInput) {
        console.log("Controller : Handle user input.");
        this.model.setData(userInput);
    }

    setView(view) {
        this.view = view;
    }
}

// Client code
const model = new Model();
const controller = new Controller(model);
const view = new View(model, controller);
controller.setView(view);
view.getUserInput();
