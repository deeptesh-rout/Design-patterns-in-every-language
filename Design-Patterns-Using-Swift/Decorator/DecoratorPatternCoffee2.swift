// ICoffee (Component)
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
    var name: String
    var cost: Int

    init(_ component: Coffee, _ name: String, _ cost: Int) {
        self.component = component
        self.name = name
        self.cost = cost
    }

    var ingredients: String {
        return "\(component.ingredients), \(name)"
    }
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator: CoffeeDecorator {
    init(_ component: Coffee) {
        super.init(component, "Milk", 4)
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator: CoffeeDecorator {
    init(_ component: Coffee) {
        super.init(component, "Espresso", 5)
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
Coffee cost is :: 5
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 4
Coffee ingredients are :: Coffee, Milk, Milk
*/