// Define State interface
class State {
    handle(context) {
        throw new Error("handle method must be implemented");
    }
}

// Define Context class
class Context {
    constructor(state) {
        this.currentState = state;
    }

    changeState(state) {
        this.currentState = state;
    }

    request() {
        this.currentState.handle(this);
    }
}

// Define ConcreteState1 class implementing State
class ConcreteState1 extends State {
    handle(context) {
        console.log("ConcreteState1 handle");
        context.changeState(new ConcreteState2());
    }
}

// Define ConcreteState2 class implementing State
class ConcreteState2 extends State {
    handle(context) {
        console.log("ConcreteState2 handle");
        context.changeState(new ConcreteState1());
    }
}

// Client code
const state1 = new ConcreteState1();
const context = new Context(state1);
context.request();
context.request();

/*
ConcreteState1 handle
ConcreteState2 handle
*/