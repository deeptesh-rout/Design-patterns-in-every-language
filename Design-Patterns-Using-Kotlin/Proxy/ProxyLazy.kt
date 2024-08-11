interface Subject {
    fun request()
}

class RealSubject : Subject {
    override fun request() {
        println("Concrete Subject Request Method")
    }
}

class Proxy : Subject {
    private var realSubject: RealSubject? = null

    override fun request() {
        if (realSubject == null) {
            realSubject = RealSubject() // Lazy Initialization
        }
        realSubject!!.request()
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