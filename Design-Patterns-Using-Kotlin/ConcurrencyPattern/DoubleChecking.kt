class Database private constructor() {
    init {
        println("Database created")
    }

    fun addData(data: String) {
        println(data)
    }

    companion object {
        @Volatile
        private var instance: Database? = null

        fun getInstance(): Database {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Database()
                    }
                }
            }
            return instance!!
        }
    }
}

// Client code.
fun main() {
    val s1 = Database.getInstance()
    val s2 = Database.getInstance()

    println(s1)
    println(s2)

    s2.addData("Hello, world!")
}

/*
Database created
Database@6bc7c054
Database@6bc7c054
Hello, world!
*/