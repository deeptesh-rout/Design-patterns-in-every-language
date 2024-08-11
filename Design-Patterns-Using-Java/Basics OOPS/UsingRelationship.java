class A {
    public A() {
        System.out.println("A created");
    }

    public void fun1() {
        System.out.println("fun1");
    }
}

class B {
    public B() {
        System.out.println("B created");
    }

    public void fun2() {
        System.out.println("fun2 start");
        new A().fun1();
        System.out.println("fun2 end");
    }
}

public class UsingRelationship {
    public static void main(String[] args) {
        B b = new B();
        b.fun2();
    }
}

/* 
B created
fun2 start
A created
fun1
fun2 end 
*/