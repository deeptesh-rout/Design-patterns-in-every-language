// Desired Interface
interface DesiredInterface {
    void operation();
}

// Adapter class
class Adapter implements DesiredInterface {
    private Adaptee adaptee;

    public Adapter() {
        this.adaptee = new Adaptee();
    }

    @Override
    public void operation() {
        adaptee.someOperation();
    }
}

// Adaptee class
class Adaptee {
    public void someOperation() {
        System.out.println("Adaptee someOperation() function called.");
    }
}

// Client Code
public class AdapterPattern {
    public static void main(String[] args) {
        DesiredInterface adapter = new Adapter();
        adapter.operation();
    }
}
/* 
Adaptee someOperation() function called.
*/