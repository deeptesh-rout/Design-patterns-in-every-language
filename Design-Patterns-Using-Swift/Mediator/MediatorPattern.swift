import Foundation

protocol ChatRoom {
    func addParticipant(_ participant: Participant)
    func broadcast(_ message: String, _ origin: String)
    func sendMessage(_ message: String, _ to: String)
}

class ConcreteChatRoom: ChatRoom {
    private var participants = [String: Participant]()

    func addParticipant(_ participant: Participant) {
        participants[participant.getName()] = participant
    }

    func broadcast(_ message: String, _ origin: String) {
        print("ChatRoom broadcast Message : \(message)")
        participants.values.filter { $0.getName() != origin }.forEach { $0.receive(message) }
    }

    func sendMessage(_ message: String, _ to: String) {
        participants[to]?.receive(message)
    }
}

protocol Participant {
    func getName() -> String
    func broadcast(_ message: String)
    func send(_ message: String, _ to: String)
    func receive(_ message: String)
}

class ConcreteParticipant: Participant {
    private let name: String
    private var chatRoom: ChatRoom

    init(name: String, chatRoom: ChatRoom) {
        self.name = name
        self.chatRoom = chatRoom
        chatRoom.addParticipant(self)
    }

    func getName() -> String {
        return name
    }

    func broadcast(_ message: String) {
        print("\(name) broadcast Message : \(message)")
        chatRoom.broadcast(message, name)
    }

    func send(_ message: String, _ to: String) {
        print("\(name) sent Message : \(message)")
        chatRoom.sendMessage(message, to)
    }

    func receive(_ message: String) {
        print("\(name) received Message : \(message)")
    }
}

// Client Code
let chatRoom = ConcreteChatRoom()
let james = ConcreteParticipant(name: "James", chatRoom: chatRoom)
let michael = ConcreteParticipant(name: "Michael", chatRoom: chatRoom)
_ = ConcreteParticipant(name: "Robert", chatRoom: chatRoom)

michael.send("Good Morning.", "James")
james.broadcast("Hello, World!")

/*
Michael sent Message : Good Morning.
James received Message : Good Morning.
James broadcast Message : Hello, World!
ChatRoom broadcast Message : Hello, World!
Robert received Message : Hello, World!
Michael received Message : Hello, World!
*/