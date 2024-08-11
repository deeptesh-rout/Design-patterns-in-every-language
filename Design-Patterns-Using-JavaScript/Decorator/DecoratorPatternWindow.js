// Window (Component)
class Window {
    draw() {
        throw new Error("Abstract method: draw");
    }
}

// SimpleWindow (ConcreteComponent)
class SimpleWindow extends Window {
    draw() {
        console.log("SimpleWindow draw.");
    }
}

// Decorator (Decorator)
class Decorator extends Window {
    constructor(component) {
        super();
        this.component = component;
    }

    draw() {
        this.component.draw();
    }
}

// VerticalScrollBarDecorator (ConcreteDecorator)
class VerticalScrollBarDecorator extends Decorator {
    constructor(component) {
        super(component);
    }

    draw() {
        super.draw();
        console.log("VerticalScrollBarDecorator draw");
    }
}

// HorizontalScrollBarDecorator (ConcreteDecorator)
class HorizontalScrollBarDecorator extends Decorator {
    constructor(component) {
        super(component);
    }

    draw() {
        super.draw();
        console.log("HorizontalScrollBarDecorator draw");
    }
}

// Client code
const component = new SimpleWindow();
const decorator1 = new VerticalScrollBarDecorator(component);
const decorator2 = new HorizontalScrollBarDecorator(decorator1);
decorator2.draw();

/*
SimpleWindow draw.
VerticalScrollBarDecorator draw
HorizontalScrollBarDecorator draw
*/
