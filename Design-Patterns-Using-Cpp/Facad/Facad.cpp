#include <iostream>

// Subsystem1
class Subsystem1 {
public:
    void operation1() {
        std::cout << "Subsystem1 operation1" << std::endl;
    }

    void operation2() {
        std::cout << "Subsystem1 operation2" << std::endl;
    }
};

// Subsystem2
class Subsystem2 {
public:
    void operation1() {
        std::cout << "Subsystem2 operation1" << std::endl;
    }

    void operation2() {
        std::cout << "Subsystem2 operation2" << std::endl;
    }
};

// SystemManagerFacade
class SystemManagerFacade {
private:
    Subsystem1 subsystem1;
    Subsystem2 subsystem2;

public:
    void operation() {
        subsystem1.operation1();
        subsystem1.operation2();
        subsystem2.operation1();
        subsystem2.operation2();
    }
};

// Client code
int main() {
    SystemManagerFacade facade;
    facade.operation();

    return 0;
}

/*
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
*/