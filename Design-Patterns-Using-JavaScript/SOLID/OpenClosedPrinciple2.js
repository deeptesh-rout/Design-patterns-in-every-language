class Animal {
    constructor(name) {
        this.name = name;
    }
}

class Bird extends Animal {
    constructor(name) {
        super(name);
    }

    fly() {
        if (this.name === "Dodo") {
            console.log("The dodo is extinct and cannot fly.");
        } else if (this.name === "Penguin") {
            console.log("The penguin cannot fly.");
        } else if (this.name === "Eagle") {
            console.log("The eagle is soaring through the sky!");
        } else if (this.name === "Sparrow") {
            console.log("The sparrow is fluttering its wings!");
        }
    }
}

// Client code
const bird1 = new Bird("Eagle");
bird1.fly();

const bird2 = new Bird("Dodo");
bird2.fly();

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
*/