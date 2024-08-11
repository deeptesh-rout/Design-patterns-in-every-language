// Desired Interface
protocol DesiredInterface {
    func operation()
}

// Adapter class
class Adapter: DesiredInterface {
    private var adaptee: Adaptee
    
    init() {
        self.adaptee = Adaptee()
    }
    
    func operation() {
        adaptee.someOperation()
    }
}

// Adaptee class
class Adaptee {
    func someOperation() {
        print("Adaptee someOperation() function called.")
    }
}

// Client Code
let adapter: DesiredInterface = Adapter()
adapter.operation()

/*
Adaptee someOperation() function called.
*/
