abstract class AbstractClass {
    final void templateMethod() {
        operation1();
        operation2();
    }

    abstract void operation1();
    abstract void operation2();
}

class ConcreteClass1 extends AbstractClass {
    @Override
    void operation1() {
        System.out.println("Concrete Class 1 : Operation 1");
    }

    @Override
    void operation2() {
        System.out.println("Concrete Class 1 : Operation 2");
    }
}

class ConcreteClass2 extends AbstractClass {
    @Override
    void operation1() {
        System.out.println("Concrete Class 2 : Operation 1");
    }

    @Override
    void operation2() {
        System.out.println("Concrete Class 2 : Operation 2");
    }
}

public class TemplatePattern {
    public static void main(String[] args) {
        AbstractClass concreteClass = new ConcreteClass1();
        concreteClass.templateMethod();
    }
}

/*
Concrete Class 1 : Operation 1
Concrete Class 1 : Operation 2
*/