// Handler abstract class
abstract class Handler(val successor: Handler?) {
    abstract fun handleRequest(request: String)
}

// ConcreteHandler1 class
class ConcreteHandler1(successor: Handler?) : Handler(successor) {
    override fun handleRequest(request: String) {
        if ("request1" == request) {
            println("ConcreteHandler1 handles the request1.")
        } else {
            successor?.handleRequest(request)
        }
    }
}

// ConcreteHandler2 class
class ConcreteHandler2(successor: Handler?) : Handler(successor) {
    override fun handleRequest(request: String) {
        if ("request2" == request) {
            println("ConcreteHandler2 handles the request2.")
        } else {
            successor?.handleRequest(request)
        }
    }
}

// ConcreteHandler3 class
class ConcreteHandler3(successor: Handler?) : Handler(successor) {
    override fun handleRequest(request: String) {
        if ("request3" == request) {
            println("ConcreteHandler3 handles the request3.")
        } else {
            successor?.handleRequest(request)
        }
    }
}

// Client code
fun main() {
    val ch1 = ConcreteHandler1(null)
    val ch2 = ConcreteHandler2(ch1)
    val ch3 = ConcreteHandler3(ch2)

    ch3.handleRequest("request1")
    ch3.handleRequest("request2")
    ch3.handleRequest("request3")
    ch3.handleRequest("request4")
}


/*
ConcreteHandler1 handles the request1.
ConcreteHandler2 handles the request2.
ConcreteHandler3 handles the request3.
*/