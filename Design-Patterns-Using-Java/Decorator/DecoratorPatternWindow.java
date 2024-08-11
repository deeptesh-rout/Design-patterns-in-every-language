import java.util.ArrayList;
import java.util.List;

// Window (Component)
interface Window {
    void draw();
}

// SimpleWindow (ConcreteComponent)
class SimpleWindow implements Window {
    @Override
    public void draw() {
        System.out.println("SimpleWindow draw.");
    }
}

// Decorator (Decorator)
abstract class Decorator implements Window {
    protected Window component;

    public Decorator(Window component) {
        this.component = component;
    }

    @Override
    public void draw() {
        component.draw();
    }
}

// VerticalScrollBarDecorator (ConcreteDecorator)
class VerticalScrollBarDecorator extends Decorator {
    public VerticalScrollBarDecorator(Window component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("VerticalScrollBarDecorator draw");
    }
}

// HorizontalScrollBarDecorator (ConcreteDecorator)
class HorizontalScrollBarDecorator extends Decorator {
    public HorizontalScrollBarDecorator(Window component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("HorizontalScrollBarDecorator draw");
    }
}

// Client code
public class DecoratorPatternWindow {
    public static void main(String[] args) {
        Window component = new SimpleWindow();
        Window decorator1 = new VerticalScrollBarDecorator(component);
        Window decorator2 = new HorizontalScrollBarDecorator(decorator1);
        decorator2.draw();
    }
}
/*
SimpleWindow draw.
VerticalScrollBarDecorator draw
HorizontalScrollBarDecorator draw
 */