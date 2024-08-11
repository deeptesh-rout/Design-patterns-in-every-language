import java.util.ArrayList;
import java.util.List;

abstract class Element {
    abstract double accept(Visitor visitor);
    abstract double price();
}

class Book extends Element {
    private double price;
    private int isbn;

    public Book(double price, int isbn) {
        this.price = price;
        this.isbn = isbn;
    }

    @Override
    double price(){
        return price;
    }

    @Override
    double accept(Visitor visitor) {
        return visitor.visitBook(this);
    }
}

class Fruit extends Element {
    private double price;
    private int quantity;
    private String type;

    public Fruit(double price, int quantity, String type) {
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    @Override
    double price(){
        return price;
    }

    @Override
    double accept(Visitor visitor) {
        return visitor.visitFruit(this) * quantity;
    }
}

abstract class Visitor {
    abstract double visitBook(Book book);
    abstract double visitFruit(Fruit fruit);
}

class SundayDiscount extends Visitor {
    @Override
    double visitBook(Book book) {
        return book.price() - 50;
    }

    @Override
    double visitFruit(Fruit fruit) {
        return fruit.price() - 5;
    }
}

class SaleDiscount extends Visitor {
    @Override
    double visitBook(Book book) {
        return book.price() / 2;
    }

    @Override
    double visitFruit(Fruit fruit) {
        return fruit.price() / 2;
    }
}

class ShoppingCart {
    private List<Element> list = new ArrayList<>();
    private Visitor visitor;

    public void add(Element element) {
        list.add(element);
    }

    public void setDiscountVisitor(Visitor discount) {
        this.visitor = discount;
    }

    public void accept() {
        double cost = 0;
        for (Element element : list) {
            cost += element.accept(visitor);
        }
        System.out.println("Total cost: " + cost);
    }
}

public class VisitorShopping {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Fruit(100, 10, "Apple"));
        cart.add(new Book(100, 12345));

        cart.setDiscountVisitor(new SundayDiscount());
        cart.accept();

        cart.setDiscountVisitor(new SaleDiscount());
        cart.accept();
    }
}

/* 
Total cost: 1000.0
Total cost: 550.0
*/