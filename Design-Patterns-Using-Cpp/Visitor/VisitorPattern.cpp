#include <iostream>

class ConcreteElementA;
class ConcreteElementB;

// Visitor interface
class Visitor {
public:
    virtual void visitElementA(ConcreteElementA& elementA) = 0;
    virtual void visitElementB(ConcreteElementB& elementB) = 0;
    virtual ~Visitor() {}
};

// Element interface
class Element {
public:
    virtual void accept(Visitor& visitor) = 0;
    virtual ~Element() {}
};

// ConcreteElementA class
class ConcreteElementA : public Element {
public:
    void accept(Visitor& visitor) override {
        visitor.visitElementA(*this);
    }
};

// ConcreteElementB class
class ConcreteElementB : public Element {
public:
    void accept(Visitor& visitor) override {
        visitor.visitElementB(*this);
    }
};

// ConcreteVisitor1 class
class ConcreteVisitor1 : public Visitor {
public:
    void visitElementA(ConcreteElementA& elementA) override {
        std::cout << "ConcreteVisitor1 visitElementA() method called." << std::endl;
    }

    void visitElementB(ConcreteElementB& elementB) override {
        std::cout << "ConcreteVisitor1 visitElementB() method called." << std::endl;
    }
};

// ConcreteVisitor2 class
class ConcreteVisitor2 : public Visitor {
public:
    void visitElementA(ConcreteElementA& elementA) override {
        std::cout << "ConcreteVisitor2 visitElementA() method called." << std::endl;
    }

    void visitElementB(ConcreteElementB& elementB) override {
        std::cout << "ConcreteVisitor2 visitElementB() method called." << std::endl;
    }
};

// Client code
int main() {
    Visitor* visitor1 = new ConcreteVisitor1();
    Element* elementA = new ConcreteElementA();
    elementA->accept(*visitor1);

    Element* elementB = new ConcreteElementB();
    elementB->accept(*visitor1);

    delete visitor1;  // Freeing allocated memory
    delete elementA;  // Freeing allocated memory
    delete elementB;  // Freeing allocated memory

    return 0;
}

/*
ConcreteVisitor1 visitElementA() method called.
ConcreteVisitor1 visitElementB() method called.
*/