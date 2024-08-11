abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }
}

abstract class Bird extends Animal {
    int flightHeight;

    Bird(String name) {
        super(name);
        this.flightHeight = 0;
    }

    abstract void fly();
}

class Sparrow extends Bird {
    Sparrow(String name) {
        super(name);
    }

    void fly() {
        System.out.println("The sparrow is fluttering its wings.");
        flightHeight = 100;
    }
}

class Penguin extends Bird {
    Penguin(String name) {
        super(name);
    }

    void fly() {
        System.out.println("The penguin cannot fly.");
    }

    void slide() {
        System.out.println("The penguin is sliding on its belly!");
    }

    void swim() {
        System.out.println("The penguin is swimming in the water!");
    }
}

class Dodo extends Bird {
    Dodo(String name) {
        super(name);
    }

    void fly() {
        System.out.println("The dodo is extinct and cannot fly.");
    }
}

public class LiskovSubstitutionPrinciple2 {
    static void test(Bird bird) {
        bird.fly();
        if (bird.flightHeight > 0) {
            System.out.println("Bird is flying at a positive height.");
        } else {
            System.out.println("Error: fly() method called; flight height is still zero.");
        }
    }

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow("Sparrow");
        test(sparrow);

        Penguin penguin = new Penguin("Penguin");
        test(penguin);

        Dodo dodo = new Dodo("Dodo");
        test(dodo);
    }
}

/*
The sparrow is fluttering its wings.
Bird is flying at a positive height.
The penguin cannot fly.
Error: fly() method called; flight height is still zero.
The dodo is extinct and cannot fly.
Error: fly() method called; flight height is still zero.
*/