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
        // Abstract method, to be overridden by subclasses
    }
}

class Dodo extends Bird {
    constructor() {
        super("Dodo");
    }

    fly() {
        console.log("The dodo is extinct and cannot fly.");
    }
}

class Penguin extends Bird {
    constructor() {
        super("Penguin");
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

class Eagle extends Bird {
    constructor() {
        super("Eagle");
    }

    fly() {
        console.log("The eagle is soaring through the sky!");
    }
}

class Sparrow extends Bird {
    constructor() {
        super("Sparrow");
    }

    fly() {
        console.log("The sparrow is fluttering its wings!");
    }
}

// Client code
const bird1 = new Eagle();
bird1.fly();

const bird2 = new Dodo();
bird2.fly();

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
*/

class Pigeon extends Bird {
    constructor() {
        super("Pigeon");
    }

    makeCooingSound() {
        console.log("The pigeon is making a cooing sound.");
    }

    fly() {
        console.log("The pigeon is fluttering its wings!");
    }
}

// Client code
const bird3 = new Pigeon();
bird3.fly();

/*
The pigeon is fluttering its wings!
*/