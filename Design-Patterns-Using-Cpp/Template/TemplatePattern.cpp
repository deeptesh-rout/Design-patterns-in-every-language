#include <iostream>

// AbstractClass class
class AbstractClass {
public:
    void templateMethod() {
        operation1();
        operation2();
    }

    virtual ~AbstractClass() {}

private:
    virtual void operation1() = 0;
    virtual void operation2() = 0;
};

// ConcreteClass1 class
class ConcreteClass1 : public AbstractClass {
private:
    void operation1() override {
        std::cout << "Concrete Class 1 : Operation 1" << std::endl;
    }

    void operation2() override {
        std::cout << "Concrete Class 1 : Operation 2" << std::endl;
    }
};

// ConcreteClass2 class
class ConcreteClass2 : public AbstractClass {
private:
    void operation1() override {
        std::cout << "Concrete Class 2 : Operation 1" << std::endl;
    }

    void operation2() override {
        std::cout << "Concrete Class 2 : Operation 2" << std::endl;
    }
};

// Client code
int main() {
    AbstractClass* concreteClass = new ConcreteClass1();
    concreteClass->templateMethod();

    delete concreteClass; // Freeing allocated memory

    return 0;
}

/*
Concrete Class 1 : Operation 1
Concrete Class 1 : Operation 2
*/
