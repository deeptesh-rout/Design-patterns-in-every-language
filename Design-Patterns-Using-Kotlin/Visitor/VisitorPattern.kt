interface Element {
    fun accept(visitor: Visitor)
}

class ConcreteElementA : Element {
    override fun accept(visitor: Visitor) {
        visitor.visitElementA(this)
    }
}

class ConcreteElementB : Element {
    override fun accept(visitor: Visitor) {
        visitor.visitElementB(this)
    }
}

interface Visitor {
    fun visitElementA(elementA: ConcreteElementA)
    fun visitElementB(elementB: ConcreteElementB)
}

class ConcreteVisitor1 : Visitor {
    override fun visitElementA(elementA: ConcreteElementA) {
        println("ConcreteVisitor1 visitElementA() method called.")
    }

    override fun visitElementB(elementB: ConcreteElementB) {
        println("ConcreteVisitor1 visitElementB() method called.")
    }
}

class ConcreteVisitor2 : Visitor {
    override fun visitElementA(elementA: ConcreteElementA) {
        println("ConcreteVisitor2 visitElementA() method called.")
    }

    override fun visitElementB(elementB: ConcreteElementB) {
        println("ConcreteVisitor2 visitElementB() method called.")
    }
}

// Client code
fun main() {
    val visitor1: Visitor = ConcreteVisitor1()
    val elementA: Element = ConcreteElementA()
    elementA.accept(visitor1)

    val elementB: Element = ConcreteElementB()
    elementB.accept(visitor1)
}

/*
ConcreteVisitor1 visitElementA() method called.
ConcreteVisitor1 visitElementB() method called.
*/