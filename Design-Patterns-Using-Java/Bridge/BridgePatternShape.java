import java.util.*;

// Abstraction abstract class
abstract class Shape {
    protected Colour imp;

    public Shape(Colour imp) {
        this.imp = imp;
    }

    abstract void draw();
}

// Rectangle class
class Rectangle extends Shape {
    public Rectangle(Colour imp) {
        super(imp);
    }

    @Override
    void draw() {
        System.out.println("Drawing Rectangle with colour " + imp.fill());
    }
}

// Circle class
class Circle extends Shape {
    public Circle(Colour imp) {
        super(imp);
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle with colour " + imp.fill());
    }
}

// Colour abstract class
abstract class Colour {
    abstract String fill();
}

// Red class
class Red extends Colour {
    @Override
    String fill() {
        return "Red";
    }
}

// Green class
class Green extends Colour {
    @Override
    String fill() {
        return "Green";
    }
}

// Blue class
class Blue extends Colour {
    @Override
    String fill() {
        return "Blue";
    }
}

// Client code
public class BridgePatternShape {
    public static void main(String[] args) {
        Colour c1 = new Red();
        Shape abstraction = new Circle(c1);
        abstraction.draw();

        Colour c2 = new Green();
        abstraction = new Rectangle(c2);
        abstraction.draw();
    }
}
