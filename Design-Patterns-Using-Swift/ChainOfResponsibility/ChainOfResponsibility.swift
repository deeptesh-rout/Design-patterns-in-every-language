// Handler class
class Handler {
    var successor: Handler?

    init(successor: Handler?) {
        self.successor = successor
    }

    func handleRequest(_ request: String) {
        // Abstract method
    }
}

// ConcreteHandler1 class
class ConcreteHandler1: Handler {
    override func handleRequest(_ request: String) {
        if request == "request1" {
            print("ConcreteHandler1 handles the request1.")
        } else {
            successor?.handleRequest(request)
        }
    }
}

// ConcreteHandler2 class
class ConcreteHandler2: Handler {
    override func handleRequest(_ request: String) {
        if request == "request2" {
            print("ConcreteHandler2 handles the request2.")
        } else {
            successor?.handleRequest(request)
        }
    }
}

// ConcreteHandler3 class
class ConcreteHandler3: Handler {
    override func handleRequest(_ request: String) {
        if request == "request3" {
            print("ConcreteHandler3 handles the request3.")
        } else {
            successor?.handleRequest(request)
        }
    }
}

// Client code
let ch1 = ConcreteHandler1(successor: nil)
let ch2 = ConcreteHandler2(successor: ch1)
let ch3 = ConcreteHandler3(successor: ch2)

ch3.handleRequest("request1")
ch3.handleRequest("request2")
ch3.handleRequest("request3")
ch3.handleRequest("request4")

/*
ConcreteHandler1 handles the request1.
ConcreteHandler2 handles the request2.
ConcreteHandler3 handles the request3.
*/