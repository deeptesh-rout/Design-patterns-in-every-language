class ChatRoom {
    constructor() {
        this.participants = new Map();
    }

    addParticipant(participant) {
        this.participants.set(participant.getName(), participant);
    }

    broadcast(message, origin) {
        console.log(`ChatRoom broadcast Message : ${message}`);
        for (const [name, participant] of this.participants) {
            if (name !== origin) {
                participant.receive(message);
            }
        }
    }

    sendMessage(message, to) {
        this.participants.get(to).receive(message);
    }
}

class Participant {
    constructor(name, chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
        chatRoom.addParticipant(this);
    }

    getName() {
        return this.name;
    }

    broadcast(message) {
        console.log(`${this.name} broadcast Message : ${message}`);
        this.chatRoom.broadcast(message, this.name);
    }

    send(message, to) {
        console.log(`${this.name} sent Message : ${message}`);
        this.chatRoom.sendMessage(message, to);
    }

    receive(message) {
        console.log(`${this.name} received Message : ${message}`);
    }
}

// Client code
const chatRoom = new ChatRoom();
const james = new Participant("James", chatRoom);
const michael = new Participant("Michael", chatRoom);
const robert = new Participant("Robert", chatRoom);

michael.send("Good Morning.", "James");
james.broadcast("Hello, World!");

/*
Michael sent Message : Good Morning.
James received Message : Good Morning.
James broadcast Message : Hello, World!
ChatRoom broadcast Message : Hello, World!
Michael received Message : Hello, World!
Robert received Message : Hello, World!
*/