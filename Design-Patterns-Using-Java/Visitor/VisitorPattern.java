interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }
}

class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }
}

interface Visitor {
    void visitElementA(ConcreteElementA elementA);
    void visitElementB(ConcreteElementB elementB);
}

class ConcreteVisitor1 implements Visitor {
    @Override
    public void visitElementA(ConcreteElementA elementA) {
        System.out.println("ConcreteVisitor1 visitElementA() method called.");
    }

    @Override
    public void visitElementB(ConcreteElementB elementB) {
        System.out.println("ConcreteVisitor1 visitElementB() method called.");
    }
}

class ConcreteVisitor2 implements Visitor {
    @Override
    public void visitElementA(ConcreteElementA elementA) {
        System.out.println("ConcreteVisitor2 visitElementA() method called.");
    }

    @Override
    public void visitElementB(ConcreteElementB elementB) {
        System.out.println("ConcreteVisitor2 visitElementB() method called.");
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Visitor visitor1 = new ConcreteVisitor1();
        Element elementA = new ConcreteElementA();
        elementA.accept(visitor1);

        Element elementB = new ConcreteElementB();
        elementB.accept(visitor1);
    }
}

/* 
ConcreteVisitor1 visitElementA() method called.
ConcreteVisitor1 visitElementB() method called.
*/