// Define Strategy interface
class Strategy {
    execute(data) {
        throw new Error("execute method must be implemented");
    }
}

// Define ConcreteStrategy1 class implementing Strategy
class ConcreteStrategy1 extends Strategy {
    execute(data) {
        console.log("ConcreteStrategy1 execute");
    }
}

// Define ConcreteStrategy2 class implementing Strategy
class ConcreteStrategy2 extends Strategy {
    execute(data) {
        console.log("ConcreteStrategy2 execute");
    }
}

// Define Context class
class Context {
    constructor(strategy) {
        this.strategy = strategy;
    }

    setStrategy(strategy) {
        this.strategy = strategy;
    }

    execute() {
        const data = 1;
        this.strategy.execute(data);
    }
}

// Client code
const context = new Context(new ConcreteStrategy1());
context.execute();

context.setStrategy(new ConcreteStrategy2());
context.execute();

/*
ConcreteStrategy1 execute
ConcreteStrategy2 execute
*/