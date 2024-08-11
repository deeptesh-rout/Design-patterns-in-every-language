class A {
    init() {
        print("A created")
    }

    func fun1() {
        print("fun1")
    }
}

class B {
    init() {
        print("B created")
    }

    func fun2() {
        print("fun2 start")
        A().fun1()
        print("fun2 end")
    }
}

let b = B()
b.fun2()
