// Memento
class Memento {
    constructor(state) {
        this.state = state;
    }

    getState() {
        return this.state;
    }
}

// CareTaker
class CareTaker {
    constructor() {
        this.history = [];
        this.top = -1;
        this.max = -1;
    }

    addMemento(m) {
        this.top += 1;
        this.max = this.top;
        if (this.top <= this.history.length - 1) {
            this.history[this.top] = m;
        } else {
            this.history.push(m);
        }
    }

    getMemento(index) {
        return this.history[index];
    }

    undo() {
        console.log("Undoing state.");
        if (this.top <= 0) {
            this.top = 0;
            return this.getMemento(0);
        }

        this.top -= 1;
        return this.getMemento(this.top);
    }

    redo() {
        console.log("Redoing state.");
        if (this.top >= this.history.length - 1 || this.top >= this.max) {
            return this.getMemento(this.top);
        }

        this.top += 1;
        return this.getMemento(this.top);
    }

    getStatesCount() {
        return this.history.length;
    }
}

// Originator
class Originator {
    setState(state) {
        this.state = state;
    }

    getState() {
        return this.state;
    }

    createMemento() {
        return new Memento(this.state);
    }

    setMemento(m) {
        this.setState(m.getState());
    }
}

// Client code
const originator = new Originator();
const careTaker = new CareTaker();

originator.setState("State 1");
careTaker.addMemento(originator.createMemento());
console.log(originator.getState());

originator.setState("State 2");
careTaker.addMemento(originator.createMemento());
console.log(originator.getState());

originator.setState("State 3");
careTaker.addMemento(originator.createMemento());
console.log(originator.getState());

originator.setMemento(careTaker.undo());
console.log(originator.getState());

originator.setMemento(careTaker.undo());
console.log(originator.getState());

originator.setMemento(careTaker.redo());
console.log(originator.getState());

originator.setMemento(careTaker.redo());
console.log(originator.getState());

/*
State 1
State 2
State 3
Undoing state.
State 2
Undoing state.
State 1
Redoing state.
State 2
Redoing state.
State 3
*/