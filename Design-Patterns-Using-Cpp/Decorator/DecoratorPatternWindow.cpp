#include <iostream>

// Window (Component)
class Window {
public:
    virtual void draw() const {
        std::cout << "SimpleWindow draw." << std::endl;
    }

    virtual ~Window() = default;
};

// SimpleWindow (ConcreteComponent)
class SimpleWindow : public Window {
public:
    void draw() const override {
        std::cout << "SimpleWindow draw." << std::endl;
    }
};

// Decorator (Decorator)
class Decorator : public Window {
protected:
    Window* component;

public:
    Decorator(Window* component) : component(component) {}

    void draw() const override {
        component->draw();
    }

    ~Decorator() override {
        delete component;
    }
};

// VerticalScrollBarDecorator (ConcreteDecorator)
class VerticalScrollBarDecorator : public Decorator {
public:
    VerticalScrollBarDecorator(Window* component) : Decorator(component) {}

    void draw() const override {
        Decorator::draw();
        std::cout << "VerticalScrollBarDecorator draw." << std::endl;
    }
};

// HorizontalScrollBarDecorator (ConcreteDecorator)
class HorizontalScrollBarDecorator : public Decorator {
public:
    HorizontalScrollBarDecorator(Window* component) : Decorator(component) {}

    void draw() const override {
        Decorator::draw();
        std::cout << "HorizontalScrollBarDecorator draw." << std::endl;
    }
};

// Client code
int main() {
    Window* component = new SimpleWindow();
    Window* decorator1 = new VerticalScrollBarDecorator(component);
    Window* decorator2 = new HorizontalScrollBarDecorator(decorator1);

    decorator2->draw();

    // Clean up dynamically allocated memory
    delete decorator2;

    return 0;
}

/*
SimpleWindow draw.
VerticalScrollBarDecorator draw.
HorizontalScrollBarDecorator draw.
*/