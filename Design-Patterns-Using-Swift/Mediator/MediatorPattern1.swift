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
    var mediator: Mediator
    var id: String

    init(mediator: Mediator, id: String) {
        self.mediator = mediator
        self.id = id
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

class ConcreteColleague1: Colleague {
    override init(mediator: Mediator, id: String) {
        super.init(mediator: mediator, id: id)
    }

    override func send(_ message: String, _ to: String) {
        print("\(id) Sent Message : \(message)")
        mediator.sendMessage(message, to)
    }

    override func receive(_ message: String) {
        print("\(id) Received Message \(message)")
    }
}

class ConcreteColleague2: Colleague {
    override init(mediator: Mediator, id: String) {
        super.init(mediator: mediator, id: id)
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
let first = ConcreteColleague1(mediator: mediator, id: "First")
mediator.addColleague(first)
let second = ConcreteColleague2(mediator: mediator, id: "Second")
mediator.addColleague(second)

first.send("Hello, World!", "Second")

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
*/