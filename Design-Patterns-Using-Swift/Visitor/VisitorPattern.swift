protocol Element {
    func accept(visitor: Visitor)
}

class ConcreteElementA: Element {
    func accept(visitor: Visitor) {
        visitor.visitElementA(elementA: self)
    }
}

class ConcreteElementB: Element {
    func accept(visitor: Visitor) {
        visitor.visitElementB(elementB: self)
    }
}

protocol Visitor {
    func visitElementA(elementA: ConcreteElementA)
    func visitElementB(elementB: ConcreteElementB)
}

class ConcreteVisitor1: Visitor {
    func visitElementA(elementA: ConcreteElementA) {
        print("ConcreteVisitor1 visitElementA() method called.")
    }

    func visitElementB(elementB: ConcreteElementB) {
        print("ConcreteVisitor1 visitElementB() method called.")
    }
}

class ConcreteVisitor2: Visitor {
    func visitElementA(elementA: ConcreteElementA) {
        print("ConcreteVisitor2 visitElementA() method called.")
    }

    func visitElementB(elementB: ConcreteElementB) {
        print("ConcreteVisitor2 visitElementB() method called.")
    }
}

// Client code.
let visitor1 = ConcreteVisitor1()
let elementA = ConcreteElementA()
elementA.accept(visitor: visitor1)

let elementB = ConcreteElementB()
elementB.accept(visitor: visitor1)

/* 
ConcreteVisitor1 visitElementA() method called.
ConcreteVisitor1 visitElementB() method called.
*/