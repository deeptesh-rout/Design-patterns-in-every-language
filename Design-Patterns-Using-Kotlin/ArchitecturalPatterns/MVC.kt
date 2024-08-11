import java.util.*

// Model
class Model {
    private var data: String? = null
    private val observers: MutableList<View> = ArrayList()

    fun setData(data: String) {
        println("Model : Set data.")
        this.data = data
        notifyObservers()
    }

    fun getData(): String? {
        println("Model : Get data.")
        return data
    }

    fun addObserver(observer: View) {
        observers.add(observer)
    }

    fun removeObserver(observer: View) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        println("Model : Notify observers.")
        for (observer in observers) {
            observer.update()
        }
    }
}

// View
class View(private val model: Model, private val controller: Controller) {
    init {
        model.addObserver(this)
    }
    fun update() {
        println("View : Update.")
        val data = model.getData()
        println("Data: $data")
    }

    fun getUserInput() {
        //val scanner = Scanner(System.`in`)
        print("View : Enter user input: ")
        //val userInput = scanner.nextLine()
        val userInput = "hello, world!";
        println(userInput);
        controller.handleUserInput(userInput)
    }
}

// Controller
class Controller(private val model: Model) {
    private lateinit var view: View

    fun handleUserInput(userInput: String) {
        println("Controller : Handle user input.")
        model.setData(userInput)
        // Can inform view about action.
    }

    fun setView(view: View) {
        this.view = view
    }
}

// Client code.
fun main() {
    val model = Model()
    val controller = Controller(model)  // The Controller sets itself as the observer in this case
    val view = View(model, controller)
    controller.setView(view)
    view.getUserInput()
}

/*
View : Enter user input: hello, world!
Controller : Handle user input.
Model : Set data.
Model : Notify observers.
View : Update.
Model : Get data.
Data: hello, world!
*/