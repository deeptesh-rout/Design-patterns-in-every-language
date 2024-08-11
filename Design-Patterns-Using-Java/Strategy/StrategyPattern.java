interface Strategy {
    void execute(int data);
}

class ConcreteStrategy1 implements Strategy {
    @Override
    public void execute(int data) {
        System.out.println("ConcreteStrategy1 execute");
    }
}

class ConcreteStrategy2 implements Strategy {
    @Override
    public void execute(int data) {
        System.out.println("ConcreteStrategy2 execute");
    }
}

class Context {
    private Strategy strategy;

    Context(Strategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void execute() {
        int data = 1;
        this.strategy.execute(data);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategy1());
        context.execute();

        context.setStrategy(new ConcreteStrategy2());
        context.execute();
    }
}

/* 
ConcreteStrategy1 execute
ConcreteStrategy2 execute
*/