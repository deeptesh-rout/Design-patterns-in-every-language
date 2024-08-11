class Memento {
    constructor(state) {
        this.state = state;
    }

    getState() {
        return this.state;
    }
}

class Originator {
    setState(state) {
        this.state = state;
    }

    getState() {
        return { state: this.state };
    }

    createMemento() {
        return new Memento({ state: this.state });
    }

    setMemento(m) {
        console.log(m.state);
        this.state = m.state;
    }
}

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
            this.history[this.top] = JSON.parse(JSON.stringify(m));
        } else {
            this.history.push(JSON.parse(JSON.stringify(m)));
        }
    }

    getMemento(index) {
        return this.history[index];
    }

    undo() {
        console.log("Undoing state.");
        if (this.top <= 0) {
            return JSON.parse(JSON.stringify(this.getMemento(0)));
        }

        this.top -= 1;
        return JSON.parse(JSON.stringify(this.getMemento(this.top)));
    }

    redo() {
        console.log("Redoing state.");
        if (this.top >= this.history.length - 1 || this.top >= this.max) {
            return JSON.parse(JSON.stringify(this.getMemento(this.top)));
        }

        this.top += 1;
        return JSON.parse(JSON.stringify(this.getMemento(this.top)));
    }

    getStatesCount() {
        return this.history.length;
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

originator.setState("State 4");
careTaker.addMemento(originator.createMemento());
console.log(originator.getState());

originator.setMemento(careTaker.redo());
console.log(originator.getState());

originator.setMemento(careTaker.redo());
console.log(originator.getState());

originator.setMemento(careTaker.redo());
console.log(originator.getState());

/*
{ state: 'State 1' }
{ state: 'State 2' }
{ state: 'State 3' }
Undoing state.
{ state: 'State 2' }
{ state: { state: 'State 2' } }
Undoing state.
{ state: 'State 1' }
{ state: { state: 'State 1' } }
{ state: 'State 4' }
Redoing state.
{ state: 'State 4' }
{ state: { state: 'State 4' } }
Redoing state.
{ state: 'State 4' }
{ state: { state: 'State 4' } }
Redoing state.
{ state: 'State 4' }
{ state: { state: 'State 4' } }
*/