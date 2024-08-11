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
    constructor(mediator, id) {
        this.mediator = mediator;
        this.id = id;
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

class ConcreteColleague1 extends Colleague {
    constructor(mediator) {
        super(mediator, "First");
    }

    send(message, to) {
        console.log(`${this.id} Sent Message : ${message}`);
        this.mediator.sendMessage(message, to);
    }

    receive(message) {
        console.log(`${this.id} Received Message : ${message}`);
    }
}

class ConcreteColleague2 extends Colleague {
    constructor(mediator) {
        super(mediator, "Second");
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
const first = new ConcreteColleague1(mediator);
mediator.addColleague(first);
const second = new ConcreteColleague2(mediator);
mediator.addColleague(second);

first.send("Hello, World!", "Second");

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message : Hello, World!
*/