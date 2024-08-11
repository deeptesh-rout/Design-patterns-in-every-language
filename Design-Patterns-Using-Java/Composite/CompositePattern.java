import java.util.HashSet;
import java.util.Set;

// Component
abstract class Component {
    public abstract void operation();
}

// Composite
class Composite extends Component {
    private Set<Component> children = new HashSet<>();

    @Override
    public void operation() {
        System.out.println("Composite Operation.");
        for (Component child : children) {
            child.operation();
        }
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }
}

// Leaf
class Leaf extends Component {
    @Override
    public void operation() {
        System.out.println("Leaf Operation.");
    }
}

// Client code
public class CompositePattern {
    public static void main(String[] args) {
        Composite composite = new Composite();
        composite.add(new Leaf());

        Composite composite2 = new Composite();
        composite2.add(new Leaf());

        composite.add(composite2);
        composite.operation();
    }
}
/* 
Composite Operation.
Composite Operation.
Leaf Operation.
Leaf Operation.
*/