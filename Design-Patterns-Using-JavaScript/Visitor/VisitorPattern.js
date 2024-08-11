// Define Element interface
class Element {
    accept(visitor) {
        throw new Error("accept method must be implemented");
    }
}

// Define ConcreteElementA implementing Element
class ConcreteElementA extends Element {
    accept(visitor) {
        visitor.visitElementA(this);
    }
}

// Define ConcreteElementB implementing Element
class ConcreteElementB extends Element {
    accept(visitor) {
        visitor.visitElementB(this);
    }
}

// Define Visitor interface
class Visitor {
    visitElementA(elementA) {
        throw new Error("visitElementA method must be implemented");
    }

    visitElementB(elementB) {
        throw new Error("visitElementB method must be implemented");
    }
}

// Define ConcreteVisitor1 implementing Visitor
class ConcreteVisitor1 extends Visitor {
    visitElementA(elementA) {
        console.log("ConcreteVisitor1 visitElementA() method called.");
    }

    visitElementB(elementB) {
        console.log("ConcreteVisitor1 visitElementB() method called.");
    }
}

// Define ConcreteVisitor2 implementing Visitor
class ConcreteVisitor2 extends Visitor {
    visitElementA(elementA) {
        console.log("ConcreteVisitor2 visitElementA() method called.");
    }

    visitElementB(elementB) {
        console.log("ConcreteVisitor2 visitElementB() method called.");
    }
}

// Client code
const visitor1 = new ConcreteVisitor1();
const elementA = new ConcreteElementA();
elementA.accept(visitor1);

const elementB = new ConcreteElementB();
elementB.accept(visitor1);

/*
ConcreteVisitor1 visitElementA() method called.
ConcreteVisitor1 visitElementB() method called.
*/