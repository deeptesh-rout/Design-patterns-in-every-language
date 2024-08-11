#include <iostream>

// Implementor interface
class Color {
public:
    virtual std::string fill() = 0;
    virtual ~Color() {} // Virtual destructor for proper cleanup
};

// Red class
class Red : public Color {
public:
    std::string fill() override {
        return "Red";
    }
};

// Green class
class Green : public Color {
public:
    std::string fill() override {
        return "Green";
    }
};

// Blue class
class Blue : public Color {
public:
    std::string fill() override {
        return "Blue";
    }
};

// Abstraction interface
class Shape {
protected:
    Color* imp;

public:
    Shape(Color* imp) : imp(imp) {}

    virtual void draw() = 0;
    virtual ~Shape() {} // Virtual destructor for proper cleanup
};

// Rectangle class
class Rectangle : public Shape {
public:
    Rectangle(Color* imp) : Shape(imp) {}

    void draw() override {
        std::cout << "Drawing Rectangle with color " << imp->fill() << std::endl;
    }
};

// Circle class
class Circle : public Shape {
public:
    Circle(Color* imp) : Shape(imp) {}

    void draw() override {
        std::cout << "Drawing Circle with color " << imp->fill() << std::endl;
    }
};

// Client code
int main() {
    Color* c1 = new Red();
    Shape* abstraction = new Circle(c1);
    abstraction->draw();

    Color* c2 = new Green();
    Shape* abstraction2 = new Rectangle(c2);
    abstraction2->draw();

    // Clean up memory
    delete c1;
    delete abstraction;
    delete c2;
    delete abstraction2;

    return 0;
}

/*
Drawing Circle with color Red
Drawing Rectangle with color Green
*/
