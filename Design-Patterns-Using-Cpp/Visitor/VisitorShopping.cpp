#include <iostream>
#include <vector>

class Visitor; // Forward declaration

// Abstract base class for elements
class Element {
public:
    virtual double accept(Visitor& visitor) = 0;
    virtual double price() = 0;
    virtual ~Element() {}
};

// Concrete Book class
class Book : public Element {
private:
    double priceVar;
    int isbn;

public:
    Book(double price, int isbn) : priceVar(price), isbn(isbn) {}

    double price() override {
        return priceVar;
    }

    double accept(Visitor& visitor) override;
};

// Concrete Fruit class
class Fruit : public Element {
private:
    double priceVar;
    int quantity;
    std::string type;

public:
    Fruit(double price, int quantity, const std::string& type) : priceVar(price), quantity(quantity), type(type) {}

    double price() override {
        return priceVar;
    }

    double accept(Visitor& visitor) override;
};

// Abstract Visitor class
class Visitor {
public:
    virtual double visitBook(Book& book) = 0;
    virtual double visitFruit(Fruit& fruit) = 0;
    virtual ~Visitor() {}
};

// Concrete SundayDiscount class
class SundayDiscount : public Visitor {
public:
    double visitBook(Book& book) override {
        return book.price() - 50;
    }

    double visitFruit(Fruit& fruit) override {
        return fruit.price() - 5;
    }
};

// Concrete SaleDiscount class
class SaleDiscount : public Visitor {
public:
    double visitBook(Book& book) override {
        return book.price() / 2;
    }

    double visitFruit(Fruit& fruit) override {
        return fruit.price() / 2;
    }
};

// Implementation of accept for Book
double Book::accept(Visitor& visitor) {
    return visitor.visitBook(*this);
}

// Implementation of accept for Fruit
double Fruit::accept(Visitor& visitor) {
    return visitor.visitFruit(*this) * quantity;
}

// ShoppingCart class
class ShoppingCart {
private:
    std::vector<Element*> list;
    Visitor* visitor;

public:
    void add(Element* element) {
        list.push_back(element);
    }

    void setDiscountVisitor(Visitor* discount) {
        this->visitor = discount;
    }

    void accept() {
        double cost = 0;
        for (Element* element : list) {
            cost += element->accept(*visitor);
        }
        std::cout << "Total cost: " << cost << std::endl;
    }
};

// Client code
int main() {
    ShoppingCart cart;
    cart.add(new Fruit(100, 10, "Apple"));
    cart.add(new Book(100, 12345));

    cart.setDiscountVisitor(new SundayDiscount());
    cart.accept();

    cart.setDiscountVisitor(new SaleDiscount());
    cart.accept();

    return 0;
}

/*
Total cost: 1000
Total cost: 550
*/