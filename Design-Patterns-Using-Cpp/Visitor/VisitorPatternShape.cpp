#include <iostream>
#include <vector>

class Visitor; // Forward declaration

// Abstract base class for shapes
class Shape {
public:
    virtual void accept(Visitor& visitor) = 0;
    virtual ~Shape() {}
};

// Concrete Circle class
class Circle : public Shape {
private:
    int x, y, radius;

public:
    Circle(int x, int y, int radius) : x(x), y(y), radius(radius) {}

    void accept(Visitor& visitor) override;
    int getX() const { return x; }
    int getY() const { return y; }
    int getRadius() const { return radius; }
};

// Concrete Rectangle class
class Rectangle : public Shape {
private:
    int x, y, width, height;

public:
    Rectangle(int x, int y, int width, int height) : x(x), y(y), width(width), height(height) {}

    void accept(Visitor& visitor) override;
    int getX() const { return x; }
    int getY() const { return y; }
    int getWidth() const { return width; }
    int getHeight() const { return height; }
};

// Abstract Visitor class
class Visitor {
public:
    virtual void visitCircle(const Circle& circle) = 0;
    virtual void visitRectangle(const Rectangle& rectangle) = 0;
    virtual ~Visitor() {}
};

// Concrete XMLVisitor class
class XMLVisitor : public Visitor {
public:
    void visitCircle(const Circle& circle) override;
    void visitRectangle(const Rectangle& rectangle) override;
};

// Concrete TextVisitor class
class TextVisitor : public Visitor {
public:
    void visitCircle(const Circle& circle) override;
    void visitRectangle(const Rectangle& rectangle) override;
};

// Implementation of accept for Circle
void Circle::accept(Visitor& visitor) {
    visitor.visitCircle(*this);
}

// Implementation of accept for Rectangle
void Rectangle::accept(Visitor& visitor) {
    visitor.visitRectangle(*this);
}

// Implementation of visitCircle for XMLVisitor
void XMLVisitor::visitCircle(const Circle& circle) {
    std::cout << "<circle>\n  <x>" << circle.getX() << "</x>\n  <y>" << circle.getY() << "</y>\n  <radius>" << circle.getRadius() << "</radius>\n</circle>\n";
}

// Implementation of visitRectangle for XMLVisitor
void XMLVisitor::visitRectangle(const Rectangle& rectangle) {
    std::cout << "<rectangle>\n  <x>" << rectangle.getX() << "</x>\n  <y>" << rectangle.getY() << "</y>\n  <width>" << rectangle.getWidth() << "</width>\n  <height>" << rectangle.getHeight() << "</height>\n</rectangle>\n";
}

// Implementation of visitCircle for TextVisitor
void TextVisitor::visitCircle(const Circle& circle) {
    std::cout << "Circle ( (x : " << circle.getX() << ", y : " << circle.getY() << "), radius : " << circle.getRadius() << ") \n";
}

// Implementation of visitRectangle for TextVisitor
void TextVisitor::visitRectangle(const Rectangle& rectangle) {
    std::cout << "Rectangle ( (x : " << rectangle.getX() << ", y : " << rectangle.getY() << "), width : " << rectangle.getWidth() << ", height : " << rectangle.getHeight() << ") \n";
}

// ObjectsStructure class
class ObjectsStructure {
private:
    std::vector<Shape*> shapes;
    Visitor* visitor;

public:
    void addShape(Shape* shape) {
        shapes.push_back(shape);
    }

    void setVisitor(Visitor* visitor) {
        this->visitor = visitor;
    }

    void accept() {
        for (Shape* shape : shapes) {
            shape->accept(*visitor);
        }
    }
};

// Client code
int main() {
    ObjectsStructure os;
    os.addShape(new Rectangle(6, 7, 8, 9));
    os.addShape(new Circle(6, 7, 8));

    os.setVisitor(new XMLVisitor());
    os.accept();

    os.setVisitor(new TextVisitor());
    os.accept();

    return 0;
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
