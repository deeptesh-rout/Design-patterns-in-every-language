#include <iostream>
#include <unordered_map>

class Shape {
protected:
    std::string color;

public:
    Shape() : color("") {}

    virtual ~Shape() {}

    virtual std::string toString() const = 0;

    virtual Shape* clone() const = 0;
};

class Rectangle : public Shape {
public:
    std::string toString() const override {
        return "Rectangle.";
    }

    Shape* clone() const override {
        return new Rectangle(*this);
    }
};

class Circle : public Shape {
public:
    std::string toString() const override {
        return "Circle.";
    }

    Shape* clone() const override {
        return new Circle(*this);
    }
};

class ShapeRegistry {
private:
    static std::unordered_map<std::string, Shape*> shapes;

public:
    static void addShape(const std::string& key, Shape* value) {
        shapes[key] = value;
    }

    static Shape* getShape(const std::string& key) {
        if (shapes.find(key) != shapes.end()) {
            return shapes[key]->clone();
        }
        return nullptr;
    }

    static void load() {
        addShape("circle", new Circle());
        addShape("rectangle", new Rectangle());
    }
};

std::unordered_map<std::string, Shape*> ShapeRegistry::shapes;

// Client code
int main() {
    ShapeRegistry::load();

    Shape* c = ShapeRegistry::getShape("circle");
    Shape* r = ShapeRegistry::getShape("rectangle");

    if (c && r) {
        std::cout << c->toString() << " " << r->toString() << std::endl;

        delete c;
        delete r;
    }

    return 0;
}

/*
Circle. Rectangle.
*/