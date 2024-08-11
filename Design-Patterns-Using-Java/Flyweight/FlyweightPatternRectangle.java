import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Shape abstract class
abstract class Shape {
    protected int colour; // Intrinsic State

    public Shape(int colour) {
        this.colour = colour;
    }

    abstract void draw(int x1, int y1, int x2, int y2); // Extrinsic State
}

// Rectangle class
class Rectangle extends Shape {
    public Rectangle(int colour) {
        super(colour);
    }

    @Override
    void draw(int x1, int y1, int x2, int y2) {
        System.out.printf("Draw Rectangle colour:%d topleft: (%d,%d) rightBottom: (%d,%d)%n", colour, x1, y1, x2, y2);
    }
}

// RectangleFactory class
class RectangleFactory {
    private Map<Integer, Shape> shapes = new HashMap<>();

    public Shape getRectangle(int colour) {
        if (!shapes.containsKey(colour)) {
            shapes.put(colour, new Rectangle(colour));
        }
        return shapes.get(colour);
    }

    public int getCount() {
        return shapes.size();
    }
}

// Client code
public class FlyweightPatternRectangle {
    public static void main(String[] args) {
        RectangleFactory factory = new RectangleFactory();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            Shape rect = factory.getRectangle(random.nextInt(1000));
            rect.draw(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100));
        }

        System.out.println(factory.getCount());
    }
}
