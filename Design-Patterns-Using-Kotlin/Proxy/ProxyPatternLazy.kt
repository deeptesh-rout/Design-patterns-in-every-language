interface BookParser {
    fun numPages(): Int
}

class ConcreteBookParser : BookParser {
    private val numPages: Int

    init {
        println("Concrete Book Parser Created")
        // Number of pages calculation heavy operation.
        // Suppose this calculation results in 1000 pages.
        this.numPages = 1000
    }

    override fun numPages(): Int {
        println("Concrete Book Parser Request Method")
        return this.numPages
    }
}

class LazyBookParserProxy : BookParser {
    private var subject: ConcreteBookParser? = null

    override fun numPages(): Int {
        if (subject == null) {
            subject = ConcreteBookParser()
        }
        return subject!!.numPages()
    }
}

// Client Code
fun main() {
    val proxy = LazyBookParserProxy()
    println(proxy.numPages())
}

/*
Concrete Book Parser Created
Concrete Book Parser Request Method
1000
*/