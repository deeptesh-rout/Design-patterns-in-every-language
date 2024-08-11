#include <iostream>

class Handler {
protected:
    Handler* successor;

public:
    Handler(Handler* successor) : successor(successor) {}

    virtual void handleRequest() = 0;
};

class ConcreteHandler1 : public Handler {
public:
    ConcreteHandler1(Handler* successor) : Handler(successor) {}

    void handleRequest() override {
        if (true) {  // Can handle request.
            std::cout << "Finally handled by ConcreteHandler1" << std::endl;
        } else if (successor != nullptr) {
            std::cout << "Message passed to next in chain by ConcreteHandler1" << std::endl;
            successor->handleRequest();
        }
    }
};

class ConcreteHandler2 : public Handler {
public:
    ConcreteHandler2(Handler* successor) : Handler(successor) {}

    void handleRequest() override {
        if (false) {  // Can't handle request.
            std::cout << "Finally handled by ConcreteHandler2" << std::endl;
        } else if (successor != nullptr) {
            std::cout << "Message passed to next in chain by ConcreteHandler2" << std::endl;
            successor->handleRequest();
        }
    }
};

// Client code
int main() {
    ConcreteHandler1* ch1 = new ConcreteHandler1(nullptr);
    ConcreteHandler2* ch2 = new ConcreteHandler2(ch1);
    ch2->handleRequest();

    // Clean up memory
    delete ch2;
    delete ch1;

    return 0;
}

/*
Message passed to next in chain by ConcreteHandler2
Finally handled by ConcreteHandler1
*/