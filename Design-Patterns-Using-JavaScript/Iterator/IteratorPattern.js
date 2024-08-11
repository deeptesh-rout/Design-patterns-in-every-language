class Aggregate {
    getIterator() {}
}

class ConcreteAggregate extends Aggregate {
    constructor() {
        super();
        this._data = [];
    }

    addData(val) {
        this._data.push(val);
    }

    getIterator() {
        return new ConcreteIterator(this);
    }
}

class Iterator {
    next() {}
    hasNext() {}
}

class ConcreteIterator extends Iterator {
    constructor(aggregate) {
        super();
        this._aggregate = aggregate;
        this._index = 0;
    }

    next() {
        if (this._index >= this._aggregate._data.length) {
            throw new Error("StopIteration");
        }
        const val = this._aggregate._data[this._index];
        this._index++;
        return val;
    }

    hasNext() {
        return this._index < this._aggregate._data.length;
    }
}

// Client code
const aggregate = new ConcreteAggregate();
aggregate.addData("Item 1");
aggregate.addData("Item 2");
aggregate.addData("Item 3");

const iterator = aggregate.getIterator();

while (iterator.hasNext()) {
    console.log(iterator.next());
}
