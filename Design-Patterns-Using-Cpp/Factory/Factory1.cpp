#include <iostream>

// Product interface
class Product {
public:
    virtual void operation() = 0;
};

// Concrete Product classes
class ConcreteProduct1 : public Product {
public:
    void operation() override {
        std::cout << "Concrete Product1 Operation!" << std::endl;
    }
};

class ConcreteProduct2 : public Product {
public:
    void operation() override {
        std::cout << "Concrete Product2 Operation!" << std::endl;
    }
};

// Creator abstract class
class Factory {
public:
    virtual Product* createProduct() = 0;
};

// Concrete Creator classes
class ConcreteFactory1 : public Factory {
public:
    Product* createProduct() override {
        return new ConcreteProduct1();
    }
};

class ConcreteFactory2 : public Factory {
public:
    Product* createProduct() override {
        return new ConcreteProduct2();
    }
};

// Client code
int main() {
    Factory* factory1 = new ConcreteFactory1();
    Product* product1 = factory1->createProduct();
    product1->operation();

    Factory* factory2 = new ConcreteFactory2();
    Product* product2 = factory2->createProduct();
    product2->operation();

    delete product1;
    delete product2;
    delete factory1;
    delete factory2;

    return 0;
}

/*
Concrete Product1 Operation!
Concrete Product2 Operation!
*/