// Subsystem1
class Subsystem1 {
    public void operation1() {
        System.out.println("Subsystem1 operation1");
    }

    public void operation2() {
        System.out.println("Subsystem1 operation2");
    }
}

// Subsystem2
class Subsystem2 {
    public void operation1() {
        System.out.println("Subsystem2 operation1");
    }

    public void operation2() {
        System.out.println("Subsystem2 operation2");
    }
}

// SystemManagerFacade
class SystemManagerFacade {
    private Subsystem1 subsystem1;
    private Subsystem2 subsystem2;

    public SystemManagerFacade() {
        this.subsystem1 = new Subsystem1();
        this.subsystem2 = new Subsystem2();
    }

    public void operation() {
        subsystem1.operation1();
        subsystem1.operation2();
        subsystem2.operation1();
        subsystem2.operation2();
    }
}

// Client code
public class Facade {
    public static void main(String[] args) {
        SystemManagerFacade facade = new SystemManagerFacade();
        facade.operation();
    }
}

/*
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
*/