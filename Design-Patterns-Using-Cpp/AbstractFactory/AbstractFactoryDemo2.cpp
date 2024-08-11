#include <iostream>

// Abstract ProductA
class ProductA {
public:
    virtual void operationA() = 0;
    virtual ~ProductA() {} // Virtual destructor for proper cleanup
};

// Concrete ProductA1
class ProductA1 : public ProductA {
public:
    void operationA() override {
        std::cout << "ProductA1 operationA" << std::endl;
    }
};

// Concrete ProductA2
class ProductA2 : public ProductA {
public:
    void operationA() override {
        std::cout << "ProductA2 operationA" << std::endl;
    }
};

// Abstract ProductB
class ProductB {
public:
    virtual void operationB() = 0;
    virtual ~ProductB() {} // Virtual destructor for proper cleanup
};

// Concrete ProductB1
class ProductB1 : public ProductB {
public:
    void operationB() override {
        std::cout << "ProductB1 operationB" << std::endl;
    }
};

// Concrete ProductB2
class ProductB2 : public ProductB {
public:
    void operationB() override {
        std::cout << "ProductB2 operationB" << std::endl;
    }
};

// Abstract Factory
class AbstractFactory {
public:
    virtual ProductA* createProductA() = 0;
    virtual ProductB* createProductB() = 0;
    virtual ~AbstractFactory() {} // Virtual destructor for proper cleanup
};

// Concrete Factory1
class ConcreteFactory1 : public AbstractFactory {
public:
    ProductA* createProductA() override {
        return new ProductA1();
    }

    ProductB* createProductB() override {
        return new ProductB1();
    }
};

// Concrete Factory2
class ConcreteFactory2 : public AbstractFactory {
public:
    ProductA* createProductA() override {
        return new ProductA2();
    }

    ProductB* createProductB() override {
        return new ProductB2();
    }
};

// Client code
int main() {
    AbstractFactory* factory1 = new ConcreteFactory1();
    ProductA* productA1 = factory1->createProductA();
    ProductB* productB1 = factory1->createProductB();
    productA1->operationA();
    productB1->operationB();

    AbstractFactory* factory2 = new ConcreteFactory2();
    ProductA* productA2 = factory2->createProductA();
    ProductB* productB2 = factory2->createProductB();
    productA2->operationA();
    productB2->operationB();

    // Clean up memory
    delete factory1;
    delete productA1;
    delete productB1;

    delete factory2;
    delete productA2;
    delete productB2;

    return 0;
}

/*
ProductA1 operationA
ProductB1 operationB
ProductA2 operationA
ProductB2 operationB
*/