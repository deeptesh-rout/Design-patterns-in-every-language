// Animal Class
class Animal {
    constructor(name) {
        this.name = name;
    }
}

// Bird Class
class Bird extends Animal {
    constructor(name) {
        super(name);
        this.flightHeight = 0;
    }

    fly() {
        throw new Error("You have to implement the method fly!");
    }
}

// Sparrow Class
class Sparrow extends Bird {
    constructor(name) {
        super(name);
    }

    fly() {
        console.log("The sparrow is fluttering its wings.");
        this.flightHeight = 100;
    }
}

// Penguin Class
class Penguin extends Bird {
    constructor(name) {
        super(name);
    }

    fly() {
        console.log("The penguin cannot fly.");
    }

    slide() {
        console.log("The penguin is sliding on its belly!");
    }

    swim() {
        console.log("The penguin is swimming in the water!");
    }
}

// Dodo Class
class Dodo extends Bird {
    constructor(name) {
        super(name);
    }

    fly() {
        console.log("The dodo is extinct and cannot fly.");
    }
}

// Test Function
function test(bird) {
    bird.fly();
    if (bird.flightHeight > 0) {
        console.log("Bird is flying at a positive height.");
    } else {
        console.log("Error: fly() method called; flight height is still zero.");
    }
}

// Client code
const sparrow = new Sparrow("Sparrow");
test(sparrow);

const penguin = new Penguin("Penguin");
test(penguin);

const dodo = new Dodo("Dodo");
test(dodo);

/*
The sparrow is fluttering its wings.
Bird is flying at a positive height.
The penguin cannot fly.
Error: fly() method called; flight height is still zero.
The dodo is extinct and cannot fly.
Error: fly() method called; flight height is still zero.
*/