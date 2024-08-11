// Flyweight interface
class Flyweight {
    constructor(intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    // Common operation for all flyweight instances
    operation(extrinsicState) {
        console.log(`Operation inside concrete flyweight with intrinsic state: ${this.intrinsicState}`);
    }
}

// FlyweightFactory class
class FlyweightFactory {
    constructor() {
        this.flyweights = new Map();
    }

    getFlyweight(key) {
        if (!this.flyweights.has(key)) {
            this.flyweights.set(key, new Flyweight(key));
            console.log(`Creating a new flyweight with key: ${key}`);
        } else {
            console.log(`Reusing existing flyweight with key: ${key}`);
        }
        return this.flyweights.get(key);
    }

    getCount() {
        return this.flyweights.size;
    }
}

// Client code
// Create a flyweight factory
const factory = new FlyweightFactory();

// Obtain flyweight instances
const flyweight1 = factory.getFlyweight("key");
const flyweight2 = factory.getFlyweight("key");

// Perform operations on flyweights
flyweight1.operation("fw1");

// Display flyweight instances and count
console.log(`Flyweight instances: ${flyweight1.intrinsicState}, ${flyweight2.intrinsicState}`);
console.log("Object count: " + factory.getCount());

/* 
Creating a new flyweight with key: key
Reusing existing flyweight with key: key
Operation inside concrete flyweight with intrinsic state: key
Flyweight instances: key, key
Object count: 1
*/