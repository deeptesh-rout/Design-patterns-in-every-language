import Foundation

// Model
class Model {
    private var data: String

    init() {
        self.data = "Hello"
    }

    func setData(_ data: String) {
        print("Model: Set data: \(data)")
        self.data = data
    }

    func getData() -> String {
        print("Model: Get data: \(data)")
        return data
    }
}

// View
class View {
    func getUserInput() -> String {
        print("View: getUserInput")
        print("View: Enter user input: ", terminator: "")
        // let userInput = readLine()
        let userInput =  "Hello, World!"
        print(userInput)
        return userInput
    }

    func displayData(_ data: String) {
        print("View: Display Result: \(data)")
    }
}

// Presenter
class Presenter {
    private var model: Model
    private var view: View

    init(model: Model, view: View) {
        self.model = model
        self.view = view
    }

    func onButtonClick() {
        print("Presenter: onButtonClick.")
        let data = view.getUserInput()
        model.setData(data)
        let newData = model.getData()
        view.displayData(newData)
    }
}

// Client Code
let model = Model()
let view = View()
let presenter = Presenter(model: model, view: view)
presenter.onButtonClick()

/*
Presenter: onButtonClick.
View: getUserInput
View: Enter user input: Hello, World!
Model: Set data: Hello, World!
Model: Get data: Hello, World!
View: Display Result: Hello, World!
*/