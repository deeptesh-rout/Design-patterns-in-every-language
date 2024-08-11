// Abstraction interface
class Abstraction {
    constructor(imp) {
        this.imp = imp;
    }

    operation() {
        this.imp.operation();
    }
}

// Implementor interface
class Implementor {
    operation() {
        throw new Error("Abstract method: operation");
    }
}

// ConcreteImplementor1 class
class ConcreteImplementor1 extends Implementor {
    operation() {
        console.log("ConcreteImplementor1 operation");
    }
}

// ConcreteImplementor2 class
class ConcreteImplementor2 extends Implementor {
    operation() {
        console.log("ConcreteImplementor2 operation");
    }
}

// Client code
const c1 = new ConcreteImplementor1();
const abstraction = new Abstraction(c1);
abstraction.operation();

/*
ConcreteImplementor1 operation
*/