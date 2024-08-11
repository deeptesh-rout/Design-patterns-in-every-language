class Adder {
    constructor() {
        this.sum = 0;
    }

    // Overloaded method for incrementing by a specific value
    incrementN(a) {
        this.sum += a;
    }

    // Overloaded method for incrementing by 1
    increment() {
        this.sum += 1;
    }

    getValue() {
        return this.sum;
    }
}

// Client code
const a = new Adder();
a.incrementN(10);
a.increment();
console.log(a.getValue());

/*
11
*/
