#include <iostream>

// Animal interface
class Animal {
public:
    virtual void voice() = 0;
    virtual ~Animal() {}  // Ensure a virtual destructor for proper cleanup
};

// Concrete Animal classes
class Dog : public Animal {
public:
    void voice() override {
        std::cout << "Bhow Bhow!!" << std::endl;
    }
};

class Cat : public Animal {
public:
    void voice() override {
        std::cout << "Meow Meow!!" << std::endl;
    }
};

// AnimalFactory interface
class AnimalFactory {
public:
    virtual Animal* getAnimal() = 0;
    virtual ~AnimalFactory() {}  // Ensure a virtual destructor for proper cleanup
};

// Concrete AnimalFactory classes
class CatFactory : public AnimalFactory {
public:
    Animal* getAnimal() override {
        return new Cat();
    }
};

class DogFactory : public AnimalFactory {
public:
    Animal* getAnimal() override {
        return new Dog();
    }
};

// Client code
int main() {
    AnimalFactory* dogFactory = new DogFactory();
    dogFactory->getAnimal()->voice();

    AnimalFactory* catFactory = new CatFactory();
    catFactory->getAnimal()->voice();

    // Future changes to include cow type of objects.
    class Cow : public Animal {
    public:
        void voice() override {
            std::cout << "Gooaa Gooaa!!" << std::endl;
        }
    };

    class CowFactory : public AnimalFactory {
    public:
        Animal* getAnimal() override {
            return new Cow();
        }
    };

    // Client code for Cow
    AnimalFactory* cowFactory = new CowFactory();
    cowFactory->getAnimal()->voice();

    // Cleanup
    delete dogFactory->getAnimal();
    delete catFactory->getAnimal();
    delete cowFactory->getAnimal();
    delete dogFactory;
    delete catFactory;
    delete cowFactory;

    return 0;
}

/*
Bhow Bhow!!
Meow Meow!!
Gooaa Gooaa!!
*/