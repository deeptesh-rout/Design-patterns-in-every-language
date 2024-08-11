#include <iostream>

class Context;

class State {
public:
    virtual void handle(Context& context) = 0;
    virtual ~State() {}
};

class Context {
private:
    State* currentState;

public:
    Context(State* state) : currentState(state) {}

    void changeState(State* state) {
        currentState = state;
    }

    void request() {
        currentState->handle(*this);
    }
};


class ConcreteState1 : public State {
public:
    void handle(Context& context) override;
};

class ConcreteState2 : public State {
public:
    void handle(Context& context) override;
};


void ConcreteState1::handle(Context& context) {
    std::cout << "ConcreteState1 handle" << std::endl;
    context.changeState(new ConcreteState2());
}

void ConcreteState2::handle(Context& context) {
    std::cout << "ConcreteState2 handle" << std::endl;
    context.changeState(new ConcreteState1());
}

// Client code
int main() {
    State* state1 = new ConcreteState1();
    Context context(state1);

    context.request();
    context.request();

    delete state1;  // Freeing allocated memory

    return 0;
}

/*
ConcreteState1 handle
ConcreteState2 handle
*/