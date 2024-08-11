#include <iostream>
#include <string>

// ICoffee (Component)
class ICoffee {
public:
    virtual int getCost() const = 0;
    virtual std::string getIngredients() const = 0;
    virtual ~ICoffee() = default;
};

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee : public ICoffee {
public:
    int getCost() const override {
        return 10;
    }

    std::string getIngredients() const override {
        return "Coffee";
    }
};

// CoffeeDecorator (Decorator)
class CoffeeDecorator : public ICoffee {
protected:
    ICoffee* component;
    std::string name;
    int cost;

public:
    CoffeeDecorator(ICoffee* component, const std::string& name, int cost)
        : component(component), name(name), cost(cost) {}

    int getCost() const override {
        return component->getCost() + cost;
    }

    std::string getIngredients() const override {
        return component->getIngredients() + ", " + name;
    }

    ~CoffeeDecorator() override {
        delete component;
    }
};

// MilkDecorator (ConcreteDecorator)
class MilkDecorator : public CoffeeDecorator {
public:
    MilkDecorator(ICoffee* component) : CoffeeDecorator(component, "Milk", 4) {}
};

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator : public CoffeeDecorator {
public:
    EspressoDecorator(ICoffee* component) : CoffeeDecorator(component, "Espresso", 5) {}
};

// Client code
int main() {
    ICoffee* component = new SimpleCoffee();
    ICoffee* decorator1 = new MilkDecorator(component);
    ICoffee* decorator2 = new EspressoDecorator(decorator1);

    std::cout << "Coffee cost is :: " << decorator2->getCost() << std::endl;
    std::cout << "Coffee ingredients are :: " << decorator2->getIngredients() << std::endl;

    ICoffee* latte = new MilkDecorator(new MilkDecorator(new SimpleCoffee()));
    std::cout << "Coffee cost is :: " << latte->getCost() << std::endl;
    std::cout << "Coffee ingredients are :: " << latte->getIngredients() << std::endl;

    // Clean up dynamically allocated memory
    delete decorator2;
    delete latte;

    return 0;
}

/*
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
*/