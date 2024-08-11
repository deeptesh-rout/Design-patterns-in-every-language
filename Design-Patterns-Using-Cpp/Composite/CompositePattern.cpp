#include <iostream>
#include <unordered_set>

// Component
class Component {
public:
    virtual void operation() = 0;
    virtual ~Component() = default;
};

// Composite
class Composite : public Component {
private:
    std::unordered_set<Component*> children;

public:
    void operation() override {
        std::cout << "Composite Operation" << std::endl;
        for (Component* child : children) {
            child->operation();
        }
    }

    void add(Component* component) {
        children.insert(component);
    }

    void remove(Component* component) {
        children.erase(component);
    }
};

// Leaf
class Leaf : public Component {
public:
    void operation() override {
        std::cout << "Leaf Operation" << std::endl;
    }
};

// Client code
int main() {
    Composite composite;
    composite.add(new Leaf());

    Composite composite2;
    composite2.add(new Leaf());

    composite.add(&composite2);
    composite.operation();

    return 0;
}

/*
Composite Operation
Composite Operation
Leaf Operation
Leaf Operation
*/