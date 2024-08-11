import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    abstract void accept(Visitor visitor);
}

class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

abstract class Visitor {
    abstract void visitCircle(Circle circle);
    abstract void visitRectangle(Rectangle rectangle);
}

class XMLVisitor extends Visitor {
    @Override
    void visitCircle(Circle circle) {
        System.out.printf("<circle>\n  <x>%d</x>\n  <y>%d</y>\n  <radius>%d</radius>\n</circle>%n",
                          circle.getX(), circle.getY(), circle.getRadius());
    }

    @Override
    void visitRectangle(Rectangle rectangle) {
        System.out.printf("<rectangle>\n  <x>%d</x>\n  <y>%d</y>\n  <width>%d</width>\n  <height>%d</height>\n</rectangle>%n",
                          rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}

class TextVisitor extends Visitor {
    @Override
    void visitCircle(Circle circle) {
        System.out.printf("Circle ( (x : %d, y : %d), radius : %d) %n", circle.getX(), circle.getY(), circle.getRadius());
    }

    @Override
    void visitRectangle(Rectangle rectangle) {
        System.out.printf("Rectangle ( (x : %d, y : %d), width : %d, height : %d) %n",
                          rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}

class ObjectsStructure {
    private List<Shape> shapes = new ArrayList<>();
    private Visitor visitor;

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void accept() {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}

public class VisitorPatternShape {
    public static void main(String[] args) {
        ObjectsStructure os = new ObjectsStructure();
        os.addShape(new Rectangle(6, 7, 8, 9));
        os.addShape(new Circle(6, 7, 8));

        os.setVisitor(new XMLVisitor());
        os.accept();

        os.setVisitor(new TextVisitor());
        os.accept();
    }
}

/*
<rectangle>
  <x>6</x>
  <y>7</y>
  <width>8</width>
  <height>9</height>
</rectangle>
<circle>
  <x>6</x>
  <y>7</y>
  <radius>8</radius>
</circle>
Rectangle ( (x : 6, y : 7), width : 8, height : 9) 
Circle ( (x : 6, y : 7), radius : 8) 
*/