// Component
class Component {
    operation() {
        throw new Error("Abstract method: operation");
    }
}

// Composite
class Composite extends Component {
    constructor() {
        super();
        this.children = new Set();
    }

    operation() {
        console.log("Composite Operation");
        for (const child of this.children) {
            child.operation();
        }
    }

    add(component) {
        this.children.add(component);
    }

    remove(component) {
        this.children.delete(component);
    }
}

// Leaf
class Leaf extends Component {
    operation() {
        console.log("Leaf Operation");
    }
}

// Client code
const composite = new Composite();
composite.add(new Leaf());

const composite2 = new Composite();
composite2.add(new Leaf());

composite.add(composite2);
composite.operation();

/*
Composite Operation
Leaf Operation
Composite Operation
Leaf Operation
*/