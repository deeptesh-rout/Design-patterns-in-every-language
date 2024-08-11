// Abstract ProductA
interface ProductA {
    void operationA();
}

// Concrete ProductA1
class ProductA1 implements ProductA {
    @Override
    public void operationA() {
        System.out.println("ProductA1 operationA");
    }
}

// Concrete ProductA2
class ProductA2 implements ProductA {
    @Override
    public void operationA() {
        System.out.println("ProductA2 operationA");
    }
}

// Abstract ProductB
interface ProductB {
    void operationB();
}

// Concrete ProductB1
class ProductB1 implements ProductB {
    @Override
    public void operationB() {
        System.out.println("ProductB1 operationB");
    }
}

// Concrete ProductB2
class ProductB2 implements ProductB {
    @Override
    public void operationB() {
        System.out.println("ProductB2 operationB");
    }
}

// Abstract Factory
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Concrete Factory1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
}

// Concrete Factory2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}

// Client code
public class AbstractFactoryDemo2 {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.operationA();
        productB1.operationB();

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.operationA();
        productB2.operationB();
    }
}

/* 
ProductA1 operationA
ProductB1 operationB
ProductA2 operationA
ProductB2 operationB
*/