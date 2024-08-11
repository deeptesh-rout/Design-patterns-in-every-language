class Subject {
    constructor() {
        this.observers = [];
    }

    attach(observer) {
        observer.setSubject(this);
        this.observers.push(observer);
    }

    detach(observer) {
        observer.setSubject(null);
        this.observers = this.observers.filter(obs => obs !== observer);
    }

    notifyObservers() {
        this.observers.forEach(observer => observer.update());
    }
}

class ConcreteSubject extends Subject {
    constructor() {
        super();
        this.state = "";
    }

    getState() {
        return this.state;
    }

    setState(state) {
        this.state = state;
        this.notifyObservers();
    }
}

class Observer {
    setSubject(subject) {
        this.subject = subject;
    }

    update() {
        // To be implemented by concrete observers
    }
}

class ConcreteObserver1 extends Observer {
    constructor(subject) {
        super();
        this.setSubject(subject);
        subject.attach(this);
    }

    update() {
        if (this.subject instanceof ConcreteSubject) {
            console.log(`${this.subject.getState()} notified to Observer1`);
        }
    }
}

class ConcreteObserver2 extends Observer {
    constructor(subject) {
        super();
        this.setSubject(subject);
        subject.attach(this);
    }

    update() {
        if (this.subject instanceof ConcreteSubject) {
            console.log(`${this.subject.getState()} notified to Observer2`);
        }
    }
}

// Client code
const subject = new ConcreteSubject();
const observer1 = new ConcreteObserver1(subject);
const observer2 = new ConcreteObserver2(subject);

subject.setState("First state");
subject.setState("Second state");

/*
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
*/