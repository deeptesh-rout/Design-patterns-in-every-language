
import java.util.*;

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    void makeSound() {
    	System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("woof woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("meow!");
    }
}

class Rectangle {
    private int height;
    private int width;

    public Rectangle(int l, int w) {
        this.height = l;
        this.width = w;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}

class Square extends Rectangle {
    public Square(int l) {
        super(l, l);
    }

    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);
    }

    @Override
    public void setHeight(int h) {
        super.setWidth(h);
        super.setHeight(h);
    }
}

public class LiskovSubstitutionPrinciple {
    private static void testRect(Rectangle rect) {
        rect.setHeight(10);
        rect.setWidth(20);
        if(200 == rect.getHeight() * rect.getWidth())
            System.out.println("success");
        else
            System.out.println("failure");
    }

    public static void main(String[] args) {
    	Rectangle r = new Rectangle(10, 20);
    	testRect(r);
    	Square s = new Square(10);
    	testRect(s);
    }
}

/*
success
failure
*/