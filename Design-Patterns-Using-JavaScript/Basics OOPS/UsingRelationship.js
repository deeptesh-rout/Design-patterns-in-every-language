class A {
    constructor() {
        console.log("A created");
    }

    fun1() {
        console.log("fun1");
    }
}

class B {
    constructor() {
        console.log("B created");
    }

    fun2() {
        console.log("fun2 start");
        new A().fun1();
        console.log("fun2 end");
    }
}

// Client code
const b = new B();
b.fun2();

/*
B created
fun2 start
A created
fun1
fun2 end
*/