class Tyre {
    constructor(type) {
        this.type = type;
    }

    getType() {
        return this.type;
    }
}

class Car {
    constructor(model) {
        this.model = model;
        this.tyres = Array.from({ length: 4 }, () => new Tyre("MRF"));
    }

    display() {
        console.log(`Car: ${this.model}, Tyre: ${this.tyres[0].getType()}`);
    }
}

// Client code
const car = new Car("BMW");
car.display();

/*
Car: BMW, Tyre: MRF
*/