// Subsystem1
class Subsystem1 {
    operation1() {
        console.log("Subsystem1 operation1");
    }

    operation2() {
        console.log("Subsystem1 operation2");
    }
}

// Subsystem2
class Subsystem2 {
    operation1() {
        console.log("Subsystem2 operation1");
    }

    operation2() {
        console.log("Subsystem2 operation2");
    }
}

// SystemManagerFacade
class SystemManagerFacade {
    constructor() {
        this.subsystem1 = new Subsystem1();
        this.subsystem2 = new Subsystem2();
    }

    operation() {
        this.subsystem1.operation1();
        this.subsystem1.operation2();
        this.subsystem2.operation1();
        this.subsystem2.operation2();
    }
}

// Client code
const facade = new SystemManagerFacade();
facade.operation();

/*
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
*/
