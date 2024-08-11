// Abstract class representing an ATM handler
class ATMHandlerAbstract {
    var successor: ATMHandlerAbstract?
    var denomination: Int
    
    init(successor: ATMHandlerAbstract?, denomination: Int) {
        self.successor = successor
        self.denomination = denomination
    }
    
    func handleRequest(amount: Int) {
        fatalError("Abstract method. Subclasses must implement this method.")
    }
}

// Concrete class representing an ATM handler
class ATMHandler: ATMHandlerAbstract {
    override func handleRequest(amount: Int) {
        let q = amount / denomination
        let r = amount % denomination

        if q != 0 {
            print("\(q) notes of \(denomination)")
        }

        if r != 0, let successor = successor {
            successor.handleRequest(amount: r)
        }
    }
}

// Client code
let handler = ATMHandler(successor: ATMHandler(successor: ATMHandler(
    successor: ATMHandler(successor: nil, denomination: 10),denomination: 50),
    denomination: 100),denomination: 1000)

handler.handleRequest(amount: 5560)

/*
5 notes of 1000
5 notes of 100
1 notes of 50
1 notes of 10
*/
