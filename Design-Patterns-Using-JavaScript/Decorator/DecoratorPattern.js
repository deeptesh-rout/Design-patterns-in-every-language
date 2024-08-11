// Component interface
class Component {
    operation() {
        throw new Error("Abstract method: operation");
    }
}

// ConcreteComponent class
class ConcreteComponent extends Component {
    operation() {
        console.log("ConcreteComponent operation.");
    }
}

// Decorator class
class Decorator extends Component {
    constructor(component) {
        super();
        this.component = component;
    }

    operation() {
        this.component.operation();
    }
}

// ConcreteDecorator1 class
class ConcreteDecorator1 extends Decorator {
    constructor(component) {
        super(component);
    }

    operation() {
        console.log("ConcreteDecorator1 operation start.");
        super.operation();
        console.log("ConcreteDecorator1 operation end.");
    }
}

// ConcreteDecorator2 class
class ConcreteDecorator2 extends Decorator {
    constructor(component) {
        super(component);
    }

    operation() {
        console.log("ConcreteDecorator2 operation start.");
        super.operation();
        console.log("ConcreteDecorator2 operation end.");
    }
}

// Client code
const component = new ConcreteComponent();
const decorator1 = new ConcreteDecorator1(component);
const decorator2 = new ConcreteDecorator2(decorator1);
decorator2.operation();


/*
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end.
*/