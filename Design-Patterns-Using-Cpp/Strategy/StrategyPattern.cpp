#include <iostream>

// Abstract Strategy class
class Strategy {
public:
    virtual void execute(int data) = 0;
    virtual ~Strategy() {}
};

// ConcreteStrategy1 class
class ConcreteStrategy1 : public Strategy {
public:
    void execute(int data) override {
        std::cout << "ConcreteStrategy1 execute" << std::endl;
    }
};

// ConcreteStrategy2 class
class ConcreteStrategy2 : public Strategy {
public:
    void execute(int data) override {
        std::cout << "ConcreteStrategy2 execute" << std::endl;
    }
};

// Context class
class Context {
private:
    Strategy* strategy;

public:
    Context(Strategy* strategy) : strategy(strategy) {}

    void setStrategy(Strategy* strategy) {
        this->strategy = strategy;
    }

    void execute() {
        int data = 1;
        this->strategy->execute(data);
    }
};

// Client code
int main() {
    ConcreteStrategy1 strategy1;
    Context context1(&strategy1);
    context1.execute();

    ConcreteStrategy2 strategy2;
    Context context2(&strategy2);
    context2.execute();

    return 0;
}

/*
ConcreteStrategy1 execute
ConcreteStrategy2 execute
*/