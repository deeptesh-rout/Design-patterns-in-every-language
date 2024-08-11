// Abstraction abstract class
abstract class Abstraction {
    protected Implementor imp;

    public Abstraction(Implementor imp) {
        this.imp = imp;
    }

    abstract void operation();
}

// Implementor abstract class
abstract class Implementor {
    abstract void operation();
}

// ConcreteAbstraction class
class ConcreteAbstraction extends Abstraction {
    public ConcreteAbstraction(Implementor imp) {
        super(imp);
    }

    @Override
    void operation() {
        imp.operation();
    }
}

// ConcreteImplementor1 class
class ConcreteImplementor1 extends Implementor {
    @Override
    void operation() {
        System.out.println("ConcreteImplementor1 operation");
    }
}

// ConcreteImplementor2 class
class ConcreteImplementor2 extends Implementor {
    @Override
    void operation() {
        System.out.println("ConcreteImplementor2 operation");
    }
}

// Client code
public class BridgePattern {
    public static void main(String[] args) {
        Implementor c1 = new ConcreteImplementor1();
        Abstraction abstraction = new ConcreteAbstraction(c1);
        abstraction.operation();
    }
}
