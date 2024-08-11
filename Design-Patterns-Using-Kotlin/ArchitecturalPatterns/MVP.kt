import java.util.Scanner

// Model
class Model {
    var dataValue: String = "Hello"

    fun setData(data: String) {
        println("Model: Set data: $data")
        this.dataValue = data
    }

    fun getData(): String {
        println("Model: Get data: $dataValue")
        return dataValue
    }
}

// View
class View {
    fun getUserInput(): String {
        println("View: getUserInput")
        // val scanner = Scanner(System.`in`)
        print("View: Enter user input: ")
        // val userInput = scanner.nextLine()
        val userInput = "Hello, World!"
        println(userInput)
        return userInput
    }

    fun displayData(data: String) {
        println("View: Display Result: $data")
    }
}

// Presenter
class Presenter(private val model: Model, private val view: View) {
    fun onButtonClick() {
        println("Presenter: onButtonClick.")
        val data = view.getUserInput()
        model.setData(data)
        val newData = model.getData()
        view.displayData(newData)
    }
}

// Client code.
fun main() {
    val model = Model()
    val view = View()
    val presenter = Presenter(model, view)
    presenter.onButtonClick()
}

/* 
Presenter: onButtonClick.
View: getUserInput
View: Enter user input: Hello, World!
Model: Set data: Hello, World!
Model: Get data: Hello, World!
View: Display Result: Hello, World!
*/