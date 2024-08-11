// Product interface
interface Product {
    void operation();
}

// Concrete Product classes
class ConcreteProduct1 implements Product {
    @Override
    public void operation() {
        System.out.println("Concrete Product1 Operation!");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void operation() {
        System.out.println("Concrete Product2 Operation!");
    }
}

// Creator abstract class
abstract class Factory {
    public abstract Product createProduct();
}

// Concrete Creator classes
class ConcreteFactory1 extends Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 extends Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct2();
    }
}

// Client code
public class Factory1 {
    public static void main(String[] args) {
        Factory factory1 = new ConcreteFactory1();
        Product product1 = factory1.createProduct();
        product1.operation();

        Factory factory2 = new ConcreteFactory2();
        Product product2 = factory2.createProduct();
        product2.operation();
    }
}


/* 
Concrete Product1 Operation!
Concrete Product2 Operation!
*/
