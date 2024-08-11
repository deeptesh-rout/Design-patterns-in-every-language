class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void makeSound() {
        System.out.println(name + " is making a sound.");
    }
}

class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    public void giveBirth() {
        System.out.println(name + " is giving birth to live young.");
    }
}

class Reptile extends Animal {
    public Reptile(String name) {
        super(name);
    }

    public void layEggs() {
        System.out.println(name + " is laying eggs.");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(name + " is flying.");
    }

    public void layEggs() {
        System.out.println(name + " is laying eggs.");
    }
}

// Client code.
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Mammal animal1 = new Mammal("Cat");
        animal1.giveBirth();
        animal1.makeSound();

        Reptile animal2 = new Reptile("Snake");
        animal2.layEggs();
        animal2.eat();

        Bird animal3 = new Bird("Eagle");
        animal3.layEggs();
        animal3.fly();
    }
}

/*
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is laying eggs.
Eagle is flying.
*/