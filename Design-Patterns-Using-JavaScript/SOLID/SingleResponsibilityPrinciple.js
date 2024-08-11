class Animal {
    constructor(name) {
        this.name = name;
    }

    eat() {
        console.log(this.name + " is eating.");
    }

    sleep() {
        console.log(this.name + " is sleeping.");
    }

    makeSound() {
        console.log(this.name + " is making a sound.");
    }
}

class Mammal extends Animal {
    constructor(name) {
        super(name);
    }

    giveBirth() {
        console.log(this.name + " is giving birth to live young.");
    }
}

class Reptile extends Animal {
    constructor(name) {
        super(name);
    }

    layEggs() {
        console.log(this.name + " is laying eggs.");
    }
}

class Bird extends Animal {
    constructor(name) {
        super(name);
    }

    fly() {
        console.log(this.name + " is flying.");
    }

    layEggs() {
        console.log(this.name + " is laying eggs.");
    }
}

// Client code.
const animal1 = new Mammal("Cat");
animal1.giveBirth();
animal1.makeSound();

const animal2 = new Reptile("Snake");
animal2.layEggs();
animal2.eat();

const animal3 = new Bird("Eagle");
animal3.layEggs();
animal3.fly();

/*
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is laying eggs.
Eagle is flying.
*/