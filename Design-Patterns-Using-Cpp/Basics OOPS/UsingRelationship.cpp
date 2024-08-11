#include <iostream>

class A {
public:
    A() {
        std::cout << "A created" << std::endl;
    }

    void fun1() {
        std::cout << "fun1" << std::endl;
    }
};

class B {
public:
    B() {
        std::cout << "B created" << std::endl;
    }

    void fun2() {
        std::cout << "fun2 start" << std::endl;
        A().fun1();
        std::cout << "fun2 end" << std::endl;
    }
};

int main() {
    B b;
    b.fun2();

    return 0;
}

/*
B created
fun2 start
A created
fun1
fun2 end
*/