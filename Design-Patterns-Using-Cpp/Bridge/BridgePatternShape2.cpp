#include <iostream>

// Implementation
class DrawingAPI {
public:
    virtual void drawSquare() = 0;
    virtual void drawCircle() = 0;
    virtual ~DrawingAPI() {} // Virtual destructor for proper cleanup
};

// Concrete Implementation
class WindowsAPI : public DrawingAPI {
public:
    void drawSquare() override {
        std::cout << "Drawing a square on Windows." << std::endl;
    }

    void drawCircle() override {
        std::cout << "Drawing a circle on Windows." << std::endl;
    }
};

class MacAPI : public DrawingAPI {
public:
    void drawSquare() override {
        std::cout << "Drawing a square on Mac." << std::endl;
    }

    void drawCircle() override {
        std::cout << "Drawing a circle on Mac." << std::endl;
    }
};

// Abstraction
class Shape {
protected:
    DrawingAPI* implementation;

public:
    Shape(DrawingAPI* implementation) : implementation(implementation) {}

    virtual void draw() = 0;
    virtual ~Shape() {} // Virtual destructor for proper cleanup
};

// Concrete Abstraction
class Square : public Shape {
public:
    Square(DrawingAPI* implementation) : Shape(implementation) {}

    void draw() override {
        implementation->drawSquare();
    }
};

class Circle : public Shape {
public:
    Circle(DrawingAPI* implementation) : Shape(implementation) {}

    void draw() override {
        implementation->drawCircle();
    }
};

// Client code
int main() {
    DrawingAPI* windowsAPI = new WindowsAPI();
    DrawingAPI* macAPI = new MacAPI();

    Shape* square = new Square(windowsAPI);
    square->draw(); // Output: Drawing a square on Windows.

    Shape* circle = new Circle(macAPI);
    circle->draw(); // Output: Drawing a circle on Mac.

    // Clean up memory
    delete windowsAPI;
    delete macAPI;
    delete square;
    delete circle;

    return 0;
}

/*
Drawing a square on Windows.
Drawing a circle on Mac.
*/