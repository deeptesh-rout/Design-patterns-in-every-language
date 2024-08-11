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
        if (name.equals("Dodo")) {
            System.out.println("The dodo is extinct and cannot fly.");
        } else if (name.equals("Penguin")) {
            System.out.println("The penguin cannot fly.");
        } else if (name.equals("Eagle")) {
            System.out.println("The eagle is soaring through the sky!");
        } else if (name.equals("Sparrow")) {
            System.out.println("The sparrow is fluttering its wings!");
        }
    }
}

// Client code
public class OpenClosedPrinciple2 {
    public static void main(String[] args) {
        Bird bird1 = new Bird("Eagle");
        bird1.fly();

        Bird bird2 = new Bird("Dodo");
        bird2.fly();
    }
}

/*
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
*/