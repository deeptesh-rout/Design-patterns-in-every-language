interface Subject {
    fun request()
}

class RealSubject : Subject {
    override fun request() {
        println("Concrete Subject Request Method")
    }
}

class Proxy : Subject {
    private val realSubject = RealSubject()

    override fun request() {
        realSubject.request()
    }
}

// Client Code
fun main() {
    val proxy = Proxy()
    proxy.request()
}

/*
Concrete Subject Request Method
*/