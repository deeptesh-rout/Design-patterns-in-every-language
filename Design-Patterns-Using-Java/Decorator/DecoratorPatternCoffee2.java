import java.util.List;
import java.util.ArrayList;

// ICoffee (Component)
interface ICoffee {
    int getCost();
    String getIngredients();
}

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee implements ICoffee {
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
abstract class CoffeeDecorator implements ICoffee {
    protected ICoffee component;
    protected String name;
    protected int cost;

    public CoffeeDecorator(ICoffee component, String name, int cost) {
        this.component = component;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return component.getCost() + cost;
    }

    @Override
    public String getIngredients() {
        return component.getIngredients() + ", " + name;
    }
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(ICoffee component) {
        super(component, "Milk", 4);
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator extends CoffeeDecorator {
    public EspressoDecorator(ICoffee component) {
        super(component, "Espresso", 5);
    }
}

// Client code
public class DecoratorPatternCoffee2 {
    public static void main(String[] args) {
        ICoffee component = new SimpleCoffee();
        ICoffee decorator1 = new MilkDecorator(component);
        ICoffee decorator2 = new EspressoDecorator(decorator1);

        System.out.println("Coffee cost is :: " + decorator2.getCost());
        System.out.println("Coffee ingredients are :: " + decorator2.getIngredients());

        ICoffee latte = new MilkDecorator(new MilkDecorator(new SimpleCoffee()));
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