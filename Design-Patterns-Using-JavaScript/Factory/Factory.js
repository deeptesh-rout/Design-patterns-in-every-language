// Product interface
class Animal {
    speak() {
        throw new Error("Abstract method 'speak' must be implemented.");
    }
}

// Concrete Product classes
class Dog extends Animal {
    speak() {
        console.log("Woof!");
    }
}

class Cat extends Animal {
    speak() {
        console.log("Meow!");
    }
}

// Creator abstract class
class AnimalFactory {
    createAnimal() {
        throw new Error("Abstract method 'createAnimal' must be implemented.");
    }
}

// Concrete Creator classes
class DogFactory extends AnimalFactory {
    createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    createAnimal() {
        return new Cat();
    }
}

// Client code
const dogFactory = new DogFactory();
const dog = dogFactory.createAnimal();
dog.speak();

const catFactory = new CatFactory();
const cat = catFactory.createAnimal();
cat.speak();

/*
Woof!
Meow!
*/
