#include <iostream>

// Desired Interface
class Shape {
public:
    virtual void draw() = 0;
    virtual ~Shape() {} // Virtual destructor for proper cleanup
};

// Circle class
class Circle : public Shape {
private:
    int x, y, radius;

public:
    Circle(int x, int y, int r) : x(x), y(y), radius(r) {}

    void draw() override {
        std::cout << "Draw the Circle." << std::endl;
    }
};

// Rectangle class (Adaptee)
class Rectangle {
private:
    int x, y, length, width;

public:
    Rectangle(int x, int y, int l, int w) : x(x), y(y), length(l), width(w) {}

    void oldDraw() {
        std::cout << "Drawing Rectangle." << std::endl;
    }
};

// RectangleAdapter class
class RectangleAdapter : public Shape {
private:
    Rectangle adaptee;

public:
    RectangleAdapter(int x, int y, int l, int w) : adaptee(x, y, l, w) {}

    void draw() override {
        adaptee.oldDraw();
    }
};

// Client Code
int main() {
    Shape* adapter = new RectangleAdapter(1, 2, 3, 4);
    adapter->draw();

    // Clean up memory
    delete adapter;

    return 0;
}
/*
Drawing Rectangle.
*/