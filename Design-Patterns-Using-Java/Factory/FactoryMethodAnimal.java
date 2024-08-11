import java.util.*;

// Animal interface
interface Animal {
    void speak();
}

// Concrete Animal classes
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Bhow Bhow!!");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow Meow!!");
    }
}

// AnimalFactory interface
interface AnimalFactory {
    Animal createAnimal();
}

// Concrete AnimalFactory classes
class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

// Client code
public class FactoryMethodAnimal {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.createAnimal().speak();

        AnimalFactory catFactory = new CatFactory();
        catFactory.createAnimal().speak();

        // Future changes to include cow type of objects.
        class Cow implements Animal {
            @Override
            public void speak() {
                System.out.println("Gooaa Gooaa!!");
            }
        }

        class CowFactory implements AnimalFactory {
            @Override
            public Animal createAnimal() {
                return new Cow();
            }
        }

        // Client code for Cow
        AnimalFactory cowFactory = new CowFactory();
        cowFactory.createAnimal().speak();
    }
}
/*
Bhow Bhow!!
Meow Meow!!
Gooaa Gooaa!!
*/
