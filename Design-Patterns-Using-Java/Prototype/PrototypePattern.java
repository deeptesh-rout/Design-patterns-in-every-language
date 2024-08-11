import java.util.HashMap;
import java.util.Map;

abstract class Prototype implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    abstract void display();
}

class ConcretePrototype1 extends Prototype {
    @Override
    void display() {
        System.out.println("ConcretePrototype1");
    }
}

class ConcretePrototype2 extends Prototype {
    @Override
    void display() {
        System.out.println("ConcretePrototype2");
    }
}

class PrototypeRegistry {
    private static final Map<String, Prototype> prototypes = new HashMap<>();

    static void addPrototype(String key, Prototype value) {
        prototypes.put(key, value);
    }

    static Prototype getPrototype(String key) throws CloneNotSupportedException {
        if (prototypes.containsKey(key)) {
            return (Prototype) prototypes.get(key).clone();
        }
        return null;
    }

    static void load() {
        addPrototype("CP1", new ConcretePrototype1());
        addPrototype("CP2", new ConcretePrototype2());
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeRegistry.load();
        Prototype c1 = PrototypeRegistry.getPrototype("CP1");
        Prototype c2 = PrototypeRegistry.getPrototype("CP2");
        c1.display();
        c2.display();
    }
}

/*
ConcretePrototype1
ConcretePrototype2
*/