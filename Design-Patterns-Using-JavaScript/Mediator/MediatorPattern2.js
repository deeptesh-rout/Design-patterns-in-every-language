class Mediator {
    constructor() {
        this.colleagues = new Map();
    }

    addColleague(colleague) {
        this.colleagues.set(colleague.getId(), colleague);
    }

    sendMessage(message, colleagueId) {
        console.log(`Mediator pass Message : ${message}`);
        this.colleagues.get(colleagueId).receive(message);
    }
}

class Colleague {
    constructor(id, mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    send(message, to) {
        console.log(`${this.id} Sent Message : ${message}`);
        this.mediator.sendMessage(message, to);
    }

    receive(message) {
        console.log(`${this.id} Received Message : ${message}`);
    }

    getId() {
        return this.id;
    }
}

class ConcreteColleague extends Colleague {
    constructor(id, mediator) {
        super(id, mediator);
    }

    send(message, to) {
        console.log(`${this.id} Sent Message : ${message}`);
        this.mediator.sendMessage(message, to);
    }

    receive(message) {
        console.log(`${this.id} Received Message : ${message}`);
    }
}

// Client code
const mediator = new Mediator();
const first = new ConcreteColleague("First", mediator);
mediator.addColleague(first);
const second = new ConcreteColleague("Second", mediator);
mediator.addColleague(second);

first.send("Hello, World!", "Second");
second.send("Hi, World!", "First");

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message : Hello, World!
Second Sent Message : Hi, World!
Mediator pass Message : Hi, World!
First Received Message : Hi, World!
*/