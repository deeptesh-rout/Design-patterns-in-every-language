abstract class AddDataTemplate {
    fun addData() {
        open()
        add()
        close()
    }

    abstract fun open()
    abstract fun add()
    abstract fun close()
}

class AddDataToFile : AddDataTemplate() {
    override fun open() {
        println("Open file.")
    }

    override fun add() {
        println("Add data to file.")
    }

    override fun close() {
        println("Close file")
    }
}

class AddDataToDB : AddDataTemplate() {
    override fun open() {
        println("Open Database.")
    }

    override fun add() {
        println("Add data to Database.")
    }

    override fun close() {
        println("Close Database.")
    }
}

// Client code
fun main() {
    val addDataToDB: AddDataTemplate = AddDataToDB()
    addDataToDB.addData()
}

/*
Open Database.
Add data to Database.
Close Database.
*/