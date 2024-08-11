// Coffee (Component)
protocol Coffee {
    var cost: Int { get }
    var ingredients: String { get }
}

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee: Coffee {
    var cost: Int {
        return 10
    }

    var ingredients: String {
        return "Coffee"
    }
}

// CoffeeDecorator (Decorator)
class CoffeeDecorator: Coffee {
    var component: Coffee

    init(_ component: Coffee) {
        self.component = component
    }

    var cost: Int {
        fatalError("Abstract method. Should be overridden by subclasses.")
    }

    var ingredients: String {
        fatalError("Abstract method. Should be overridden by subclasses.")
    }
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator: CoffeeDecorator {
    override var cost: Int {
        return component.cost + 4
    }

    override var ingredients: String {
        return component.ingredients + ", Milk"
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator: CoffeeDecorator {
    override var cost: Int {
        return component.cost + 5
    }

    override var ingredients: String {
        return component.ingredients + ", Espresso"
    }
}

// Client code
let component: Coffee = SimpleCoffee()
let decorator1: Coffee = MilkDecorator(component)
let decorator2: Coffee = EspressoDecorator(decorator1)

print("Coffee cost is :: \(decorator2.cost)")
print("Coffee ingredients are :: \(decorator2.ingredients)")

let latte: Coffee = MilkDecorator(MilkDecorator(SimpleCoffee()))
print("Coffee cost is :: \(latte.cost)")
print("Coffee ingredients are :: \(latte.ingredients)")

/*
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
*/