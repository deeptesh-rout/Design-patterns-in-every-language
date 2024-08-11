#include <iostream>
#include <sstream>

// Define the Product class with two parts
class Product {
private:
    std::string partA;
    std::string partB;

public:
    Product(const std::string& A, const std::string& B) : partA(A), partB(B) {}

    void setPartA(const std::string& A){
        this->partA = A;
    }

    void setPartB(const std::string& B){
        this->partB = B;
    }

    friend std::ostream& operator<<(std::ostream& os, const Product& product) {
        os << "Product: (" << product.partA << ", " << product.partB << ")";
        return os;
    }
};

// Define an abstract class called Builder
class Builder {
protected:
    Product product;

public:
    Builder() : product("A default", "B default") {}

    virtual Builder* setPartA(const std::string& A) = 0;
    virtual Builder* setPartB(const std::string& B) = 0;

    Product getProduct() {
        Product temp = this->product;
        this->product = Product("A default", "B default"); // assign new product.
        return temp;
    }
};

// Define a ConcreteBuilder class that extends Builder
class ConcreteBuilder : public Builder {
public:
    Builder* setPartA(const std::string& A) override {
        this->product.setPartA(A);
        return this;
    }

    Builder* setPartB(const std::string& B) override {
        this->product.setPartB(B);
        return this;
    }
};

// Define a Director class that takes a builder object as a parameter
class Director {
private:
    Builder* builder;

public:
    Director(Builder* builder) : builder(builder) {}

    Product construct() {
        return this->builder->setPartA("A1")->setPartB("B1")->getProduct();
    }

    Product construct2() {
        this->builder->setPartA("A2");
        this->builder->setPartB("B2");
        return this->builder->getProduct();
    }

    Product construct3() {
        return this->builder->setPartA("A3")->getProduct();
    }
};

// Client code
int main() {
    Builder* builder = new ConcreteBuilder();
    Director director(builder);

    Product product = director.construct();
    std::cout << product << std::endl;

    Product product2 = director.construct2();
    std::cout << product2 << std::endl;

    Product product3 = director.construct3();
    std::cout << product3 << std::endl;

    // Clean up memory
    delete builder;

    return 0;
}

/*
Product: (A1, B1)
Product: (A2, B2)
Product: (A3, B default)
*/