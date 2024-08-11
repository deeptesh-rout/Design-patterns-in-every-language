class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    void fly() {
        // Abstract method, to be overridden by subclasses
    }
}

class Dodo extends Bird {
    public Dodo() {
        super("Dodo");
    }

    @Override
    void fly() {
        System.out.println("The dodo is extinct and cannot fly.");
    }
}

class Penguin extends Bird {
    public Penguin() {
        super("Penguin");
    }

    @Override
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

class Eagle extends Bird {
    public Eagle() {
        super("Eagle");
    }

    @Override
    void fly() {
        System.out.println("The eagle is soaring through the sky!");
    }
}

class Sparrow extends Bird {
    public Sparrow() {
        super("Sparrow");
    }

    @Override
    void fly() {
        System.out.println("The sparrow is fluttering its wings!");
    }
}

// Client code
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Bird bird1 = new Eagle();
        bird1.fly();

        Bird bird2 = new Dodo();
        bird2.fly();

        Bird bird3 = new Pigeon();
        bird3.fly();
    }
}

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
The pigeon is fluttering its wings!
*/

class Pigeon extends Bird {
    public Pigeon() {
        super("Pigeon");
    }

    void makeCooingSound() {
        System.out.println("The pigeon is making a cooing sound.");
    }

    @Override
    void fly() {
        System.out.println("The pigeon is fluttering its wings!");
    }
}
