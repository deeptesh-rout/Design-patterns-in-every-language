#include <iostream>

class ATMHandlerAbstract {
protected:
    ATMHandlerAbstract* successor;
    int denomination;

public:
    ATMHandlerAbstract(ATMHandlerAbstract* successor, int denomination)
        : successor(successor), denomination(denomination) {}

    virtual void handleRequest(int amount) = 0;
};

class ATMHandler : public ATMHandlerAbstract {
public:
    ATMHandler(ATMHandlerAbstract* successor, int denomination)
        : ATMHandlerAbstract(successor, denomination) {}

    void handleRequest(int amount) override {
        int q = amount / denomination;
        int r = amount % denomination;

        if (q != 0) {
            std::cout << q << " notes of " << denomination << std::endl;
        }

        if (r != 0 && successor != nullptr) {
            successor->handleRequest(r);
        }
    }
};

// Client code
int main() {
    ATMHandlerAbstract* handler = new ATMHandler(
        new ATMHandler( new ATMHandler(new ATMHandler(nullptr, 10), 50
            ), 100
        ), 1000
    );

    handler->handleRequest(5560);

    // Clean up memory
    delete handler;

    return 0;
}

/*
5 notes of 1000
5 notes of 100
1 notes of 50
1 notes of 10
*/