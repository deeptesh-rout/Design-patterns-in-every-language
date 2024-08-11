#include <iostream>

class Adder {
private:
    int sum;

public:
    Adder() : sum(0) {}

    // Overloaded method for incrementing by a specific value
    void increment(int a) {
        this->sum += a;
    }

    // Overloaded method for incrementing by 1
    void increment() {
        this->sum += 1;
    }

    int getValue() const {
        return this->sum;
    }
};

int main() {
    Adder a;
    a.increment(10);
    a.increment();
    std::cout << a.getValue() << std::endl;

    return 0;
}
/*
11
*/