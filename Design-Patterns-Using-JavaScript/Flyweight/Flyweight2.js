// Flyweight interface
class Flyweight {
    operation(extrinsicState) {
        // Common operation logic
    }
}

// Concrete Flyweight
class ConcreteFlyweight extends Flyweight {
    constructor(intrinsicState) {
        super();
        this.intrinsicState = intrinsicState;
    }

    operation(extrinsicState) {
        console.log(`Operation with intrinsic state: ${this.intrinsicState}, extrinsic state: ${extrinsicState}`);
    }
}

// Flyweight Factory
class FlyweightFactory {
    constructor() {
        this.flyweights = {};
    }

    getFlyweight(intrinsicState) {
        if (!this.flyweights[intrinsicState]) {
            this.flyweights[intrinsicState] = new ConcreteFlyweight(intrinsicState);
            console.log(`Creating a new flyweight with key: ${intrinsicState}`);

        } else {
            console.log(`Reusing existing flyweight with key: ${intrinsicState}`);
        }
        return this.flyweights[intrinsicState];
    }
}

// Client code
const factory = new FlyweightFactory();

const flyweight1 = factory.getFlyweight("sharedState");
flyweight1.operation("clientState1");

const flyweight2 = factory.getFlyweight("sharedState");
flyweight2.operation("clientState2");

/*
Creating a new flyweight with key: sharedState
Operation with intrinsic state: sharedState, extrinsic state: clientState1
Reusing existing flyweight with key: sharedState
Operation with intrinsic state: sharedState, extrinsic state: clientState2
*/
