#include <iostream>

// Component
class Component {
public:
    virtual void operation() = 0;
    virtual ~Component() = default;
};

// ConcreteComponent
class ConcreteComponent : public Component {
public:
    void operation() override {
        std::cout << "ConcreteComponent operation." << std::endl;
    }
};

// Decorator
class Decorator : public Component {
private:
    Component* component;

public:
    Decorator(Component* component) : component(component) {}

    void operation() override {
        if (component) {
            component->operation();
        }
    }

    virtual ~Decorator() {
        delete component;
    }
};

// ConcreteDecorator1
class ConcreteDecorator1 : public Decorator {
public:
    ConcreteDecorator1(Component* component) : Decorator(component) {}

    void operation() override {
        std::cout << "ConcreteDecorator1 operation start." << std::endl;
        Decorator::operation();
        std::cout << "ConcreteDecorator1 operation end." << std::endl;
    }
};

// ConcreteDecorator2
class ConcreteDecorator2 : public Decorator {
public:
    ConcreteDecorator2(Component* component) : Decorator(component) {}

    void operation() override {
        std::cout << "ConcreteDecorator2 operation start." << std::endl;
        Decorator::operation();
        std::cout << "ConcreteDecorator2 operation end." << std::endl;
    }
};

// Client code
int main() {
    Component* component = new ConcreteComponent();
    Decorator* decorator1 = new ConcreteDecorator1(component);
    Decorator* decorator2 = new ConcreteDecorator2(decorator1);

    decorator2->operation();

    // Clean up dynamically allocated memory
    delete decorator2;

    return 0;
}

/*
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end.
*/