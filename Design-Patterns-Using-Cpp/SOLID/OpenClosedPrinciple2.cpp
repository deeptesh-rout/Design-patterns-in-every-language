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

    void fly() {
        if (name == "Dodo") {
            std::cout << "The dodo is extinct and cannot fly." << std::endl;
        } else if (name == "Penguin") {
            std::cout << "The penguin cannot fly." << std::endl;
        } else if (name == "Eagle") {
            std::cout << "The eagle is soaring through the sky!" << std::endl;
        } else if (name == "Sparrow") {
            std::cout << "The sparrow is fluttering its wings!" << std::endl;
        }
    }
};

// Client code
int main() {
    Bird bird1("Eagle");
    bird1.fly();

    Bird bird2("Dodo");
    bird2.fly();

    return 0;
}
