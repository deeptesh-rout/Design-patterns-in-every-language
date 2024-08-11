#include <iostream>
#include <unordered_set>

// IShape
class IShape {
public:
    virtual void move(int x, int y) = 0;
    virtual std::string draw() = 0;
    virtual ~IShape() = default;
};

// Rectangle
class Rectangle : public IShape {
private:
    int x, y, length, breadth;

public:
    Rectangle(int x, int y, int length, int breadth) : x(x), y(y), length(length), breadth(breadth) {}

    void move(int x, int y) override {
        this->x += x;
        this->y += y;
    }

    std::string draw() override {
        std::cout << "Draw a Rectangle at (" << x << ", " << y << ")." << std::endl;
        return "<Rectangle>";
    }
};

// Circle
class Circle : public IShape {
private:
    int x, y, radius;

public:
    Circle(int x, int y, int radius) : x(x), y(y), radius(radius) {}

    void move(int x, int y) override {
        this->x += x;
        this->y += y;
    }

    std::string draw() override {
        std::cout << "Draw a Circle of radius " << radius << " at (" << x << ", " << y << ")." << std::endl;
        return "<Circle>";
    }
};

// CompoundShape
class CompoundShape : public IShape {
private:
    std::unordered_set<IShape*> children;

public:
    void add(IShape* child) {
        children.insert(child);
    }

    void remove(IShape* child) {
        children.erase(child);
    }

    void move(int x, int y) override {
        for (IShape* child : children) {
            child->move(x, y);
        }
    }

    std::string draw() override {
        std::string st = "Shapes(";
        for (IShape* child : children) {
            st += child->draw();
        }
        st += ")";
        return st;
    }
};

// Client code
int main() {
    CompoundShape all;
    all.add(new Rectangle(1, 2, 1, 2));
    all.add(new Circle(5, 3, 10));

    CompoundShape group;
    group.add(new Rectangle(5, 7, 1, 2));
    group.add(new Circle(2, 1, 2));

    all.add(&group);
    std::cout << all.draw() << std::endl;

    return 0;
}

/*
Draw a Circle of radius 2 at (2, 1).
Draw a Rectangle at (5, 7).
Draw a Circle of radius 10 at (5, 3).
Draw a Rectangle at (1, 2).
Shapes(Shapes(<Circle><Rectangle>)<Circle><Rectangle>)
*/