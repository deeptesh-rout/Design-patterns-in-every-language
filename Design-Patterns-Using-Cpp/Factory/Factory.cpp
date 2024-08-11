#include <iostream>

// Product interface
class Animal {
public:
    virtual void speak() = 0;
};

// Concrete Product classes
class Dog : public Animal {
public:
    void speak() override {
        std::cout << "Woof!" << std::endl;
    }
};

class Cat : public Animal {
public:
    void speak() override {
        std::cout << "Meow!" << std::endl;
    }
};

// Creator abstract class
class AnimalFactory {
public:
    virtual Animal* createAnimal() = 0;
};

// Concrete Creator classes
class DogFactory : public AnimalFactory {
public:
    Animal* createAnimal() override {
        return new Dog();
    }
};

class CatFactory : public AnimalFactory {
public:
    Animal* createAnimal() override {
        return new Cat();
    }
};

// Client code
int main() {
    AnimalFactory* dogFactory = new DogFactory();
    Animal* dog = dogFactory->createAnimal();
    dog->speak();

    AnimalFactory* catFactory = new CatFactory();
    Animal* cat = catFactory->createAnimal();
    cat->speak();

    delete dog;
    delete cat;
    delete dogFactory;
    delete catFactory;

    return 0;
}

/*
Woof!
Meow!
*/