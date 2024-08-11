import java.util.HashMap;
import java.util.Map;

abstract class Shape implements Cloneable {
    private String color;

    public Shape() {
        this.color = "";
    }

    @Override
    public abstract String toString();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract Shape cloneShape();
}

class Rectangle extends Shape {
    @Override
    public String toString() {
        return "Rectangle.";
    }

    @Override
    public Shape cloneShape() {
        try {
            return (Shape) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle.";
    }

    @Override
    public Shape cloneShape() {
        try {
            return (Shape) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class ShapeRegistry {
    private static final Map<String, Shape> shapes = new HashMap<>();

    static void addShape(String key, Shape value) {
        shapes.put(key, value);
    }

    static Shape getShape(String key) {
        if (shapes.containsKey(key)) {
            return shapes.get(key).cloneShape();
        }
        return null;
    }

    static void load() {
        addShape("circle", new Circle());
        addShape("rectangle", new Rectangle());
    }
}

public class PrototypePatternShape {
    public static void main(String[] args) {
        ShapeRegistry.load();
        Shape c = ShapeRegistry.getShape("circle");
        Shape r = ShapeRegistry.getShape("rectangle");
        System.out.println(c);
        System.out.println(r);
    }
}

/*
 Circle. Rectangle.
 */