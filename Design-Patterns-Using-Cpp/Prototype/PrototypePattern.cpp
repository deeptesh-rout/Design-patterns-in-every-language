#include <iostream>
#include <unordered_map>

class Prototype {
public:
    virtual ~Prototype() {}
    virtual void display() = 0;
    virtual Prototype* clone() const = 0;
};

class ConcretePrototype1 : public Prototype {
public:
    void display() override {
        std::cout << "ConcretePrototype1" << std::endl;
    }

    Prototype* clone() const override {
        return new ConcretePrototype1(*this);
    }
};

class ConcretePrototype2 : public Prototype {
public:
    void display() override {
        std::cout << "ConcretePrototype2" << std::endl;
    }

    Prototype* clone() const override {
        return new ConcretePrototype2(*this);
    }
};

class PrototypeRegistry {
private:
    static std::unordered_map<std::string, Prototype*> prototypes;

public:
    static void addPrototype(const std::string& key, Prototype* value) {
        prototypes[key] = value;
    }

    static Prototype* getPrototype(const std::string& key) {
        if (prototypes.find(key) != prototypes.end()) {
            return prototypes[key]->clone();
        }
        return nullptr;
    }

    static void load() {
        addPrototype("CP1", new ConcretePrototype1());
        addPrototype("CP2", new ConcretePrototype2());
    }
};

std::unordered_map<std::string, Prototype*> PrototypeRegistry::prototypes;

// Client code
int main() {
    PrototypeRegistry::load();

    Prototype* c1 = PrototypeRegistry::getPrototype("CP1");
    Prototype* c2 = PrototypeRegistry::getPrototype("CP2");

    if (c1 && c2) {
        c1->display();
        c2->display();

        delete c1;
        delete c2;
    }

    return 0;
}

/*
ConcretePrototype1
ConcretePrototype2
*/