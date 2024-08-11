import java.util.ArrayList;
import java.util.List;

class Memento implements Cloneable {
    private Object state;

    public Memento(Object state) {
        this.state = state;
    }

    public Object getState() {
        return state;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Originator {
    private Object state;

    public void setState(Object state) {
        this.state = state;
    }

    public Object getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento m) {
        this.state = m.getState();
    }
}

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
            try {
                history.set(top, (Memento) m.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                history.add((Memento) m.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    public Memento getMemento(int index) {
        return history.get(index);
    }

    public Memento undo() {
        System.out.println("Undoing state.");
        if (top <= 0) {
            top = 0;
            return history.get(0);
        }

        top -= 1;
        return history.get(top);
    }

    public Memento redo() {
        System.out.println("Redoing state.");
        if (top >= (history.size() - 1) || top >= max) {
            return history.get(top);
        }

        top += 1;
        return history.get(top);
    }

    public int getStatesCount() {
        return history.size();
    }
}

public class MomentoPatternJson {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State 1");
        careTaker.addMemento(originator.createMemento());
        System.out.println(originator.getState());

         originator.setState("State 2");
        careTaker.addMemento(originator.createMemento());
        System.out.println(originator.getState());

        originator.setState("State 3");
        careTaker.addMemento(originator.createMemento());
        System.out.println(originator.getState());

        originator.setMemento(careTaker.undo());
        System.out.println(originator.getState());

        originator.setMemento(careTaker.undo());
        System.out.println(originator.getState());

        originator.setState("State 4");
        careTaker.addMemento(originator.createMemento());
        System.out.println(originator.getState());

        originator.setMemento(careTaker.redo());
        System.out.println(originator.getState());

        originator.setMemento(careTaker.redo());
        System.out.println(originator.getState());

        originator.setMemento(careTaker.redo());
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
State 4
Redoing state.
State 4
Redoing state.
State 4
Redoing state.
State 4
*/
