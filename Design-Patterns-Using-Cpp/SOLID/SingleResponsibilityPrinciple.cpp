#include <iostream>
#include <string>

class Animal {
protected:
    std::string name;

public:
    Animal(const std::string& name) : name(name) {}

    void eat() {
        std::cout << name << " is eating." << std::endl;
    }

    void sleep() {
        std::cout << name << " is sleeping." << std::endl;
    }

    void makeSound() {
        std::cout << name << " is making a sound." << std::endl;
    }
};

class Mammal : public Animal {
public:
    Mammal(const std::string& name) : Animal(name) {}

    void giveBirth() {
        std::cout << name << " is giving birth to live young." << std::endl;
    }
};

class Reptile : public Animal {
public:
    Reptile(const std::string& name) : Animal(name) {}

    void layEggs() {
        std::cout << name << " is laying eggs." << std::endl;
    }
};

class Bird : public Animal {
public:
    Bird(const std::string& name) : Animal(name) {}

    void fly() {
        std::cout << name << " is flying." << std::endl;
    }

    void layEggs() {
        std::cout << name << " is laying eggs." << std::endl;
    }
};

// Client code
int main() {
    Mammal animal1("Cat");
    animal1.giveBirth();
    animal1.makeSound();

    Reptile animal2("Snake");
    animal2.layEggs();
    animal2.eat();

    Bird animal3("Eagle");
    animal3.layEggs();
    animal3.fly();

    return 0;
}

/*
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is laying eggs.
Eagle is flying.
*/