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
    RealSubject* realSubject;

public:
    Proxy() : realSubject(nullptr) {}

    void request() override {
        if (realSubject == nullptr) {
            realSubject = new RealSubject(); // Lazy Initialization
        }
        realSubject->request();
    }

    ~Proxy() {
        delete realSubject; // Clean up allocated memory
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