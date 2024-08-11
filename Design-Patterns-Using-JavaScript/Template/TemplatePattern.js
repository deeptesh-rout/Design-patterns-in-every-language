// Define AbstractClass
class AbstractClass {
    templateMethod() {
        this.operation1();
        this.operation2();
    }

    operation1() {
        throw new Error("operation1 method must be implemented");
    }

    operation2() {
        throw new Error("operation2 method must be implemented");
    }
}

// Define ConcreteClass1 extending AbstractClass
class ConcreteClass1 extends AbstractClass {
    operation1() {
        console.log("Concrete Class 1: Operation 1");
    }

    operation2() {
        console.log("Concrete Class 1: Operation 2");
    }
}

// Define ConcreteClass2 extending AbstractClass
class ConcreteClass2 extends AbstractClass {
    operation1() {
        console.log("Concrete Class 2: Operation 1");
    }

    operation2() {
        console.log("Concrete Class 2: Operation 2");
    }
}

// Client code
const concreteClass = new ConcreteClass1();
concreteClass.templateMethod();

/*
Concrete Class 1: Operation 1
Concrete Class 1: Operation 2
*/