
class BulbControl {
    private BulbState current;

    BulbControl() {
        this.current = new Off();
    }

    void setState(BulbState state) {
        this.current = state;
    }

    void flip() {
        this.current.flip(this);
    }

    String toStringState() {
        return this.current.toString();
    }
}

interface BulbState {
    void flip(BulbControl bc);
    String toString();
}

class On implements BulbState {
    @Override
    public void flip(BulbControl bc) {
        bc.setState(new Off());
    }

    @Override
    public String toString() {
        return "On";
    }
}

class Off implements BulbState {
    @Override
    public void flip(BulbControl bc) {
        bc.setState(new On());
    }

    @Override
    public String toString() {
        return "Off";
    }
}

// Client code.
public class StatePattern {
    public static void main(String[] args) {
        BulbControl c = new BulbControl();
        c.flip();
        System.out.println(c.toStringState());
        c.flip();
        System.out.println(c.toStringState());
    }
}

/* 
On
Off
*/