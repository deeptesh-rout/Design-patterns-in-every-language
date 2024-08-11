// Desired Interface
class DesiredInterface {
    operation() {
        throw new Error("Abstract method: operation");
    }
}

// Adapter class
class Adapter extends DesiredInterface {
    constructor() {
        super();
        this.adaptee = new Adaptee();
    }

    operation() {
        this.adaptee.someOperation();
    }
}

// Adaptee class
class Adaptee {
    someOperation() {
        console.log("Adaptee someOperation() function called.");
    }
}

// Client Code
const adapter = new Adapter();
adapter.operation();
/*
Adaptee someOperation() function called.
*/