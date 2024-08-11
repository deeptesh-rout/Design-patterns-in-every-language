import java.util.ArrayList;
import java.util.List;

// Memento
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// CareTaker
class CareTaker {
    private List<Memento> history;
    private int top;
    private int max;

    public CareTaker() {
        this.history = new ArrayList<>();
        this.top = -1;
        this.max = -1;
    }

    public void addMemento(Memento m) {
        top += 1;
        max = top;
        if (top <= history.size() - 1) {
            history.set(top, m);
        } else {
            history.add(m);
        }
    }

    public Memento getMemento(int index) {
        return history.get(index);
    }

    public Memento undo() {
        System.out.println("Undoing state.");
        if (top <= 0) {
            top = 0;
            return getMemento(0);
        }

        top -= 1;
        return getMemento(top);
    }

    public Memento redo() {
        System.out.println("Redoing state.");
        if (top >= (history.size() - 1) || top >= max) {
            return getMemento(top);
        }

        top += 1;
        return getMemento(top);
    }

    public int getStatesCount() {
        return history.size();
    }
}

// Originator
class Originator {
    private String state;
    private CareTaker careTaker;

    public Originator() {
        this.careTaker = new CareTaker();
    }

    public void setState(String state) {
        this.state = state;
        careTaker.addMemento(createMemento());
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento m) {
        state = m.getState();
    }

    public void undo() {
        setMemento(careTaker.undo());
    }

    public void redo() {
        setMemento(careTaker.redo());
    }
}

// Client code
public class MomentoPatternCopy {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("State 1");
        System.out.println(originator.getState());

        originator.setState("State 2");
        System.out.println(originator.getState());

        originator.setState("State 3");
        System.out.println(originator.getState());

        originator.undo();
        System.out.println(originator.getState());

        originator.undo();
        System.out.println(originator.getState());

        originator.redo();
        System.out.println(originator.getState());

        originator.redo();
        System.out.println(originator.getState());
    }
}

/* 
State 1
State 2
State 3
Undoing state.
State 2
Undoing state.
State 1
Redoing state.
State 2
Redoing state.
State 3
*/