import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Database private constructor() {
    private var connection: Connection? = null

    init {
        try {
            println("Database created")
            connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3")
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun createTable() {
        try {
            val statement = connection!!.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);"
            )
            statement.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun addData(id: Int, name: String?) {
        try {
            val statement = connection!!.prepareStatement(
                    "INSERT INTO students (id, name) VALUES (?, ?);"
            )
            statement.setInt(1, id)
            statement.setString(2, name)
            statement.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun display() {
        try {
            val statement = connection!!.prepareStatement("SELECT * FROM students;")
            val resultSet = statement.executeQuery()
            while (resultSet.next()) {
                val id = resultSet.getInt("id")
                val name = resultSet.getString("name")
                println("ID: $id, Name: $name")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    companion object {
        private var instance: Database? = null // Keep instance reference
            
        fun getInstance(): Database? {
            if (instance == null) {
                Database()
            }
            return instance
        }    
    }
}

fun main() {
    val db1 = Database.getInstance()
    val db2 = Database.getInstance()

    println("Database Objects DB1: $db1")
    println("Database Objects DB2: $db2")

    db1?.createTable() // Use safe call operator here
    db1?.addData(1, "john")
    db2?.addData(2, "smith")

    db1?.display()
}