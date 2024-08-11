// Coffee (Component)
interface Coffee {
    int getCost();
    String getIngredients();
}

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee implements Coffee {
    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}

// CoffeeDecorator (Decorator)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee component;

    public CoffeeDecorator(Coffee component) {
        this.component = component;
    }

    @Override
    public abstract int getCost();

    @Override
    public abstract String getIngredients();
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee component) {
        super(component);
    }

    @Override
    public int getCost() {
        return component.getCost() + 4;
    }

    @Override
    public String getIngredients() {
        return component.getIngredients() + ", Milk";
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator extends CoffeeDecorator {
    public EspressoDecorator(Coffee component) {
        super(component);
    }

    @Override
    public int getCost() {
        return component.getCost() + 5;
    }

    @Override
    public String getIngredients() {
        return component.getIngredients() + ", Espresso";
    }
}

// Client code
public class DecoratorPatternCoffee {
    public static void main(String[] args) {
        Coffee component = new SimpleCoffee();
        Coffee decorator1 = new MilkDecorator(component);
        Coffee decorator2 = new EspressoDecorator(decorator1);

        System.out.println("Coffee cost is :: " + decorator2.getCost());
        System.out.println("Coffee ingredients are :: " + decorator2.getIngredients());

        Coffee latte = new MilkDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("Coffee cost is :: " + latte.getCost());
        System.out.println("Coffee ingredients are :: " + latte.getIngredients());
    }
}

/*
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
*/