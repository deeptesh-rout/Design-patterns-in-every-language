// Component
abstract class Component {
    public abstract void operation();
}

// ConcreteComponent
class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation.");
    }
}

// Decorator
abstract class Decorator extends Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// ConcreteDecorator1
class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteDecorator1 operation start.");
        super.operation();
        System.out.println("ConcreteDecorator1 operation end.");
    }
}

// ConcreteDecorator2
class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteDecorator2 operation start.");
        super.operation();
        System.out.println("ConcreteDecorator2 operation end.");
    }
}

// Client code
public class DecoratorPattern {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator1 = new ConcreteDecorator1(component);
        Decorator decorator2 = new ConcreteDecorator2(decorator1);
        decorator2.operation();
    }
}

/*
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end.
*/