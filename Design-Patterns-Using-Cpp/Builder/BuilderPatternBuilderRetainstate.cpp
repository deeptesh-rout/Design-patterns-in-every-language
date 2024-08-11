#include <iostream>

class Product {
private:
    std::string partA;
    std::string partB;

public:
    Product(const std::string& A, const std::string& B) : partA(A), partB(B) {}

    friend std::ostream& operator<<(std::ostream& os, const Product& product) {
        os << "Product: (" << product.partA << ", " << product.partB << ")";
        return os;
    }
};

class Builder {
public:
    virtual Builder* setPartA(const std::string& A) = 0;
    virtual Builder* setPartB(const std::string& B) = 0;
    virtual Product getProduct() = 0;
    virtual ~Builder() {} // Virtual destructor for proper cleanup
};

class ConcreteBuilder : public Builder {
private:
    std::string partA;
    std::string partB;

public:
    Builder* setPartA(const std::string& A) override {
        this->partA = A;
        return this; // Returning self helps in chaining calls.
    }

    Builder* setPartB(const std::string& B) override {
        this->partB = B;
        return this;
    }

    Product getProduct() override {
        return Product(partA, partB);
    }
};

class Director {
private:
    Builder* builder;

public:
    Director(Builder* builder) : builder(builder) {}

    Product construct() {
        return builder->setPartA("A1")->setPartB("B1")->getProduct(); // Chaining calls
    }

    Product construct2() {
        builder->setPartA("A2");
        builder->setPartB("B2");
        return builder->getProduct();
    }
};

// Client code
int main() {
    ConcreteBuilder builder;
    Director director(&builder);

    Product product = director.construct();
    std::cout << product << std::endl;

    Product product2 = director.construct2();
    std::cout << product2 << std::endl;

    return 0;
}

/*
Product: (A1, B1)
Product: (A2, B2)
*/