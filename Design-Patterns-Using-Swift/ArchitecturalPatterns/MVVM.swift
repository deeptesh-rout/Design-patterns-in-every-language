import Foundation

// Model
class Model {
    private var data = "Default."

    func setData(_ data: String) {
        print("Model: Set data.")
        self.data = data
    }

    func getData() -> String {
        print("Model: Get data.")
        return data
    }
}

// ViewModel
class ViewModel {
    private let model: Model

    init(model: Model) {
        self.model = model
    }

    func setData(_ data: String) {
        print("ViewModel: Set data.")
        model.setData(data)
    }

    func getData() -> String {
        print("ViewModel: Get data.")
        return model.getData()
    }
}

// View
class View {
    private let viewModel: ViewModel

    init(viewModel: ViewModel) {
        self.viewModel = viewModel
    }

    func displayData() {
        print("Display Data: \(viewModel.getData())")
    }

    func getUserInput() {
        print("View: Enter user input: ", terminator: "")
        //let userInput = readLine()
        let userInput =  "Hello, World!"
        print(userInput)
        viewModel.setData(userInput)
    }
}

// Client Code
let model = Model()
let viewModel = ViewModel(model: model)
let view = View(viewModel: viewModel)

// Display initial data
view.displayData()

// Get user input and update data
view.getUserInput()

// Display updated data
view.displayData()

/*
ViewModel: Get data.
Model: Get data.
Display Data: Default.
View: Enter user input: Hello, World!
ViewModel: Set data.
Model: Set data.
ViewModel: Get data.
Model: Get data.
Display Data: Hello, World!
*/