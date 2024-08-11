

class Context {
    private State currentState;

    Context(State state) {
        this.currentState = state;
    }

    void changeState(State state) {
        this.currentState = state;
    }

    void request() {
        this.currentState.handle(this);
    }
}

interface State {
    void handle(Context context);
}

class ConcreteState1 implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteState1 handle");
        context.changeState(new ConcreteState2());
    }
}

class ConcreteState2 implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteState2 handle");
        context.changeState(new ConcreteState1());
    }
}

// Client code.
public class StatePattern2 {
    public static void main(String[] args) {
        State state1 = new ConcreteState1();
        Context context = new Context(state1);
        context.request();
        context.request();
    }
}

/* 
ConcreteState1 handle
ConcreteState2 handle 
*/
