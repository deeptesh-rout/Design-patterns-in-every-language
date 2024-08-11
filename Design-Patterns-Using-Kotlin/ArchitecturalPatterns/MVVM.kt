import java.util.Scanner

// Model
class Model {
    var dataValue: String = "Default."

    fun setData(data: String) {
        println("Model: Set data.")
        this.dataValue = data
    }

    fun getData(): String {
        println("Model: Get data.")
        return dataValue
    }
}

// ViewModel
class ViewModel(private val model: Model) {
    fun setData(data: String) {
        println("ViewModel: Set data.")
        model.setData(data)
    }

    fun getData(): String {
        println("ViewModel: Get data.")
        return model.getData()
    }
}

// View
class View(private val viewModel: ViewModel) {
    fun displayData() {
        println("Display Data: " + viewModel.getData())
    }

    fun getUserInput() {
        //val scanner = Scanner(System.`in`)
        print("View: Enter user input: ")
        //val userInput = scanner.nextLine()
        val userInput = "Hello, World!"
        println(userInput)
        viewModel.setData(userInput)
    }
}

// Client code
fun main() {
    val model = Model()
    val viewModel = ViewModel(model)
    val view = View(viewModel)

    // Display initial data
    view.displayData()

    // Get user input and update data
    view.getUserInput()

    // Display updated data
    view.displayData()
}

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