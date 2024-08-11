// Animal interface
class Animal {
    voice() {
        throw new Error("Abstract method 'voice' must be implemented.");
    }
}

// Concrete Animal classes
class Dog extends Animal {
    voice() {
        console.log("Bhow Bhow!!");
    }
}

class Cat extends Animal {
    voice() {
        console.log("Meow Meow!!");
    }
}

// AnimalFactory interface
class AnimalFactory {
    getAnimal() {
        throw new Error("Abstract method 'getAnimal' must be implemented.");
    }
}

// Concrete AnimalFactory classes
class CatFactory extends AnimalFactory {
    getAnimal() {
        return new Cat();
    }
}

class DogFactory extends AnimalFactory {
    getAnimal() {
        return new Dog();
    }
}

// Client code
const dogFactory = new DogFactory();
dogFactory.getAnimal().voice();

const catFactory = new CatFactory();
catFactory.getAnimal().voice();


/*
Bhow Bhow!!
Meow Meow!!
*/


// Future changes to include cow type of objects.
class Cow extends Animal {
    voice() {
        console.log("Gooaa Gooaa!!");
    }
}

class CowFactory extends AnimalFactory {
    getAnimal() {
        return new Cow();
    }
}

// Client code for Cow
const cowFactory = new CowFactory();
cowFactory.getAnimal().voice();

/*
Gooaa Gooaa!!
*/