import java.util.HashSet;
import java.util.Set;

// IShape interface
interface IShape {
    void move(int x, int y);
    String draw();
}

// Rectangle
class Rectangle implements IShape {
    private int x, y, length, breadth;

    public Rectangle(int x, int y, int length, int breadth) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String draw() {
        System.out.println("Draw a Rectangle at (" + x + ", " + y + ").");
        return "<Rectangle>";
    }
}

// Circle
class Circle implements IShape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String draw() {
        System.out.println("Draw a Circle of radius " + radius + " at (" + x + ", " + y + ").");
        return "<Circle>";
    }
}

// CompoundShape
class CompoundShape implements IShape {
    private final Set<IShape> children = new HashSet<>();

    public void add(IShape child) {
        children.add(child);
    }

    public void remove(IShape child) {
        children.remove(child);
    }

    @Override
    public void move(int x, int y) {
        for (IShape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public String draw() {
        StringBuilder st = new StringBuilder("Shapes(");
        for (IShape child : children) {
            st.append(child.draw());
        }
        st.append(")");
        return st.toString();
    }
}

// Client code
public class CompositePatternDraw {
    public static void main(String[] args) {
        CompoundShape all = new CompoundShape();
        all.add(new Rectangle(1, 2, 1, 2));
        all.add(new Circle(5, 3, 10));

        CompoundShape group = new CompoundShape();
        group.add(new Rectangle(5, 7, 1, 2));
        group.add(new Circle(2, 1, 2));
        all.add(group);
        System.out.println(all.draw());
    }
}


/*
Draw a Circle of radius 10 at (5, 3).
Draw a Rectangle at (5, 7).
Draw a Circle of radius 2 at (2, 1).
Draw a Rectangle at (1, 2).
Shapes(<Circle>Shapes(<Rectangle><Circle>)<Rectangle>)
*/
