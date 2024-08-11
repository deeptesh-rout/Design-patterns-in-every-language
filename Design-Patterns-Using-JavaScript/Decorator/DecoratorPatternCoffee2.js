// ICoffee (Component)
class ICoffee {
    getCost() {
        throw new Error("Abstract method: getCost");
    }

    getIngredients() {
        throw new Error("Abstract method: getIngredients");
    }
}

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee extends ICoffee {
    getCost() {
        return 10;
    }

    getIngredients() {
        return "Coffee";
    }
}

// CoffeeDecorator (Decorator)
class CoffeeDecorator extends ICoffee {
    constructor(component, name, cost) {
        super();
        this.component = component;
        this.name = name;
        this.cost = cost;
    }

    getCost() {
        return this.component.getCost() + this.cost;
    }

    getIngredients() {
        return this.component.getIngredients() + ", " + this.name;
    }
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator extends CoffeeDecorator {
    constructor(component) {
        super(component, "Milk", 4);
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator extends CoffeeDecorator {
    constructor(component) {
        super(component, "Espresso", 5);
    }
}

// Client code
const component = new SimpleCoffee();
const decorator1 = new MilkDecorator(component);
const decorator2 = new EspressoDecorator(decorator1);

console.log("Coffee cost is :: " + decorator2.getCost());
console.log("Coffee ingredients are :: " + decorator2.getIngredients());

const latte = new MilkDecorator(new MilkDecorator(new SimpleCoffee()));
console.log("Coffee cost is :: " + latte.getCost());
console.log("Coffee ingredients are :: " + latte.getIngredients());


/*
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
*/