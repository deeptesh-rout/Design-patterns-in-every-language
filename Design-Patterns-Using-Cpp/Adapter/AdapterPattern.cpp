#include <iostream>

// Desired Interface
class DesiredInterface {
public:
    virtual void operation() = 0;
    virtual ~DesiredInterface() {} // Virtual destructor for proper cleanup
};

// Adaptee class
class Adaptee {
public:
    void someOperation() {
        std::cout << "Adaptee someOperation() function called." << std::endl;
    }
};

// Adapter class
class Adapter : public DesiredInterface {
private:
    Adaptee adaptee;

public:
    void operation() override {
        adaptee.someOperation();
    }
};

// Client Code
int main() {
    DesiredInterface* adapter = new Adapter();
    adapter->operation();

    // Clean up memory
    delete adapter;

    return 0;
}

/*
Adaptee someOperation() function called.
*/