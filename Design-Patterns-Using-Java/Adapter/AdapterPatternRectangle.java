// Desired Interface
interface Shape {
    void draw();
}

// Circle class
class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.radius = r;
    }

    @Override
    public void draw() {
        System.out.println("Draw the Circle.");
    }
}

// Rectangle class (Adaptee)
class Rectangle {
    private int x, y, length, width;

    public Rectangle(int x, int y, int l, int w) {
        this.x = x;
        this.y = y;
        this.length = l;
        this.width = w;
    }

    public void oldDraw() {
        System.out.println("Drawing Rectangle.");
    }
}

// RectangleAdapter class
class RectangleAdapter implements Shape {
    private Rectangle adaptee;

    public RectangleAdapter(int x, int y, int l, int w) {
        this.adaptee = new Rectangle(x, y, l, w);
    }

    @Override
    public void draw() {
        adaptee.oldDraw();
    }
}

// Client Code
public class AdapterPatternRectangle {
    public static void main(String[] args) {
        Shape adapter = new RectangleAdapter(1, 2, 3, 4);
        adapter.draw();
    }
}

/* 
Drawing Rectangle.
*/