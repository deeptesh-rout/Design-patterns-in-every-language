import Foundation

// Model
class Model {
    private var data: String = ""
    private var observers: [View] = []

    func setData(_ data: String) {
        print("Model : Set data.")
        self.data = data
        notifyObservers()
    }

    func getData() -> String {
        print("Model : Get data.")
        return data
    }

    func addObserver(_ observer: View) {
        observers.append(observer)
    }

    func removeObserver(_ observer: View) {
        if let index = observers.firstIndex(where: { $0 === observer }) {
            observers.remove(at: index)
        }
    }

    private func notifyObservers() {
        print("Model : Notify observers.")
        for observer in observers {
            observer.update()
        }
    }
}

// View
class View {
    private var controller: Controller
    private var model: Model

    init(model: Model, controller: Controller) {
        self.model = model
        self.controller = controller
        self.model.addObserver(self)
    }

    func update() {
        print("View : Update.")
        let data = model.getData()
        print("Data: \(data)")
    }

    func getUserInput() {
        print("View : Enter user input: ")
        //let userInput = readLine()
        let userInput = "Hello, World!" 
        print(userInput)
        controller.handleUserInput(userInput)
    }
}

// Controller
class Controller {
    private var model: Model
    private var view: View?

    init(model: Model) {
        self.model = model
    }

    func handleUserInput(_ userInput: String) {
        print("Controller : Handle user input.")
        model.setData(userInput)
    }

    func setView(_ view: View) {
        self.view = view
    }
}

// Client Code
let model = Model()
let controller = Controller(model: model)
let view = View(model: model, controller: controller)
controller.setView(view)
view.getUserInput()

/*
View : Enter user input: 
Hello, World!
Controller : Handle user input.
Model : Set data.
Model : Notify observers.
View : Update.
Model : Get data.
Data: Hello, World!
*/