#include <iostream>

// Implementor interface
class Implementor {
public:
    virtual void operation() = 0;
    virtual ~Implementor() {} // Virtual destructor for proper cleanup
};

// ConcreteImplementor1 class
class ConcreteImplementor1 : public Implementor {
public:
    void operation() override {
        std::cout << "ConcreteImplementor1 operation" << std::endl;
    }
};

// ConcreteImplementor2 class
class ConcreteImplementor2 : public Implementor {
public:
    void operation() override {
        std::cout << "ConcreteImplementor2 operation" << std::endl;
    }
};

// Abstraction interface
class Abstraction {
protected:
    Implementor* imp;

public:
    Abstraction(Implementor* imp) : imp(imp) {}

    virtual void operation() = 0;
    virtual ~Abstraction() {} // Virtual destructor for proper cleanup
};

// ConcreteAbstraction class
class ConcreteAbstraction : public Abstraction {
public:
    ConcreteAbstraction(Implementor* imp) : Abstraction(imp) {}

    void operation() override {
        imp->operation();
    }
};

// Client code
int main() {
    Implementor* c1 = new ConcreteImplementor1();
    Abstraction* abstraction = new ConcreteAbstraction(c1);
    abstraction->operation();

    // Clean up memory
    delete c1;
    delete abstraction;

    return 0;
}
/*
ConcreteImplementor1 operation
*/