#include <iostream>

class Subject {
public:
    virtual void request() = 0;
};

class RealSubject : public Subject {
public:
    void request() override {
        std::cout << "Concrete Subject Request Method" << std::endl;
    }
};

class Proxy : public Subject {
private:
    RealSubject realSubject;

public:
    Proxy() {
        // In this simplified example, the RealSubject is created inside the Proxy.
        // In a real-world scenario, you might use lazy initialization or other mechanisms.
    }

    void request() override {
        realSubject.request();
    }
};

// Client code
int main() {
    Proxy proxy;
    proxy.request();

    return 0;
}

/*
Concrete Subject Request Method
*/