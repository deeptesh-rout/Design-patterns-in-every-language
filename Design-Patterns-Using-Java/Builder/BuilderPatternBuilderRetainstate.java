class Product {
    private String partA;
    private String partB;

    public Product(String A, String B) {
        this.partA = A;
        this.partB = B;
    }

    @Override
    public String toString() {
        return "Product : (" + partA + ", " + partB + ")";
    }
}

abstract class Builder {
    public abstract Builder setPartA(String A);
    public abstract Builder setPartB(String B);
    public abstract Product getProduct();
}

class ConcreteBuilder extends Builder {
    private String partA;
    private String partB;

    @Override
    public ConcreteBuilder setPartA(String A) {
        this.partA = A;
        return this; // Returning self helps in chaining calls.
    }

    @Override
    public ConcreteBuilder setPartB(String B) {
        this.partB = B;
        return this;
    }

    @Override
    public Product getProduct() {
        return new Product(partA, partB);
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        return builder.setPartA("A1").setPartB("B1").getProduct(); // Chaining calls
    }

    public Product construct2() {
        builder.setPartA("A2");
        builder.setPartB("B2");
        return builder.getProduct();
    }
}

// Client code
public class BuilderPatternBuilderRetainstate {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);

        Product product = director.construct();
        System.out.println(product);

        Product product2 = director.construct2();
        System.out.println(product2);
    }
}

/* 
Product : (A1, B1)
Product : (A2, B2)
 */