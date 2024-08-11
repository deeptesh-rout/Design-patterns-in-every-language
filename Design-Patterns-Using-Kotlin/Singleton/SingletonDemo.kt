class Database {
    init {
        println("Database created")
    }

    fun addData(data: String?) {
        println(data)
    }
}

class Singleton private constructor() {
    private val db: Database

    init {
        instance = this
        db = Database()
    }

    fun addData(data: String?) {
        db.addData(data)
    }

    companion object {
        private var instance: Singleton? = null
        
        fun getInstance(): Singleton? {
            if (instance == null) {
                Singleton()
            }
            return instance
        }
    }
}

fun main() {
    val s1 = Singleton.getInstance()
    val s2 = Singleton.getInstance()

    println(s1)
    println(s2)

    s2!!.addData("Hello, world!")
}

/*
Database created
Singleton@7344699f
Singleton@7344699f
Hello, world!
 */

