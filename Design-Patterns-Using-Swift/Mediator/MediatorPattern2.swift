import Foundation

protocol Mediator {
    func addColleague(_ colleague: Colleague)
    func sendMessage(_ message: String, _ colleagueId: String)
}

class ConcreteMediator: Mediator {
    private var colleagues = [String: Colleague]()

    func addColleague(_ colleague: Colleague) {
        colleagues[colleague.getId()] = colleague
    }

    func sendMessage(_ message: String, _ colleagueId: String) {
        print("Mediator pass Message : \(message)")
        colleagues[colleagueId]?.receive(message)
    }
}

class Colleague {
    var id: String
    var mediator: Mediator

    init(id: String, mediator: Mediator) {
        self.id = id
        self.mediator = mediator
    }

    func send(_ message: String, _ to: String) {
        fatalError("Subclasses must override this method.")
    }

    func receive(_ message: String) {
        fatalError("Subclasses must override this method.")
    }

    func getId() -> String {
        return id
    }
}

class ConcreteColleague: Colleague {
    override init(id: String, mediator: Mediator) {
        super.init(id: id, mediator: mediator)
    }

    override func send(_ message: String, _ to: String) {
        print("\(id) Sent Message : \(message)")
        mediator.sendMessage(message, to)
    }

    override func receive(_ message: String) {
        print("\(id) Received Message \(message)")
    }
}

// Client Code
let mediator = ConcreteMediator()
let first = ConcreteColleague(id: "First", mediator: mediator)
mediator.addColleague(first)

let second = ConcreteColleague(id: "Second", mediator: mediator)
mediator.addColleague(second)

first.send("Hello, World!", "Second")
second.send("Hi, World!", "First")

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
Second Sent Message : Hi, World!
Mediator pass Message : Hi, World!
First Received Message Hi, World!
*/