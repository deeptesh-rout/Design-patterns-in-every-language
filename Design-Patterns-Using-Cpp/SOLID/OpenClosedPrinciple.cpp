#include <iostream>
#include <string>

class Animal {
protected:
    std::string name;

public:
    Animal(const std::string& name) : name(name) {}
};

class Bird : public Animal {
public:
    Bird(const std::string& name) : Animal(name) {}

    virtual void fly() = 0;
};

class Dodo : public Bird {
public:
    Dodo() : Bird("Dodo") {}

    void fly() override {
        std::cout << "The dodo is extinct and cannot fly." << std::endl;
    }
};

class Penguin : public Bird {
public:
    Penguin() : Bird("Penguin") {}

    void fly() override {
        std::cout << "The penguin cannot fly." << std::endl;
    }

    void slide() {
        std::cout << "The penguin is sliding on its belly!" << std::endl;
    }

    void swim() {
        std::cout << "The penguin is swimming in the water!" << std::endl;
    }
};

class Eagle : public Bird {
public:
    Eagle() : Bird("Eagle") {}

    void fly() override {
        std::cout << "The eagle is soaring through the sky!" << std::endl;
    }
};

class Sparrow : public Bird {
public:
    Sparrow() : Bird("Sparrow") {}

    void fly() override {
        std::cout << "The sparrow is fluttering its wings!" << std::endl;
    }
};

class Pigeon : public Bird {
public:
    Pigeon() : Bird("Pigeon") {}

    void makeCooingSound() {
        std::cout << "The pigeon is making a cooing sound." << std::endl;
    }

    void fly() override {
        std::cout << "The pigeon is fluttering its wings!" << std::endl;
    }
};

// Client code
int main() {
    Bird* bird1 = new Eagle();
    bird1->fly();

    Bird* bird2 = new Dodo();
    bird2->fly();

    Bird* bird3 = new Pigeon();
    bird3->fly();

    delete bird1;
    delete bird2;
    delete bird3;

    return 0;
}

