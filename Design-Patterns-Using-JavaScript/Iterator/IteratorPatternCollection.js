// Concrete Aggregate class
class ConcreteAggregate {
    constructor() {
        this.data = [];
    }

    addData(value) {
        this.data.push(value);
    }

    getIterator() {
        return new ConcreteIterator(this);
    }

    getData() {
        return this.data;
    }
}

// Concrete Iterator class
class ConcreteIterator {
    constructor(aggregate) {
        this.aggregate = aggregate;
        this.index = 0;
    }

    hasNext() {
        return this.index < this.aggregate.getData().length;
    }

    next() {
        if (!this.hasNext()) {
            throw new Error("Index out of bounds");
        }
        const value = this.aggregate.getData()[this.index];
        this.index++;
        return value;
    }
}

// Client code
const aggregate = new ConcreteAggregate();
for (let i = 0; i < 10; i++) {
    aggregate.addData(i);
}

const iterator = aggregate.getIterator();
while (iterator.hasNext()) {
    console.log(iterator.next());
}

/*
0
1
2
3
4
5
6
7
8
9
*/