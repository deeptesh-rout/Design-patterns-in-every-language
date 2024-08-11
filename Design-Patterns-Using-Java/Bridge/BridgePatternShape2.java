// Abstraction
abstract class Shape {
    protected DrawingAPI implementation;

    public Shape(DrawingAPI implementation) {
        this.implementation = implementation;
    }

    public abstract void draw();
}

// Concrete Abstraction
class Square extends Shape {
    public Square(DrawingAPI implementation) {
        super(implementation);
    }

    @Override
    public void draw() {
        implementation.drawSquare();
    }
}

class Circle extends Shape {
    public Circle(DrawingAPI implementation) {
        super(implementation);
    }

    @Override
    public void draw() {
        implementation.drawCircle();
    }
}

// Implementation
interface DrawingAPI {
    void drawSquare();
    void drawCircle();
}

// Concrete Implementation
class WindowsAPI implements DrawingAPI {
    @Override
    public void drawSquare() {
        System.out.println("Drawing a square on Windows.");
    }

    @Override
    public void drawCircle() {
        System.out.println("Drawing a circle on Windows.");
    }
}

class MacAPI implements DrawingAPI {
    @Override
    public void drawSquare() {
        System.out.println("Drawing a square on Mac.");
    }

    @Override
    public void drawCircle() {
        System.out.println("Drawing a circle on Mac.");
    }
}

// Usage
public class BridgePatternShape2 {
    public static void main(String[] args) {
        DrawingAPI windowsAPI = new WindowsAPI();
        DrawingAPI macAPI = new MacAPI();

        Shape square = new Square(windowsAPI);
        square.draw();  

        Shape circle = new Circle(macAPI);
        circle.draw();  
    }
}
/* 
Drawing a square on Windows.
Drawing a circle on Mac. 
*/