class A {
    init {
        println("A created")
    }

    fun fun1() {
        println("fun1")
    }
}

class B {
    init {
        println("B created")
    }

    fun fun2() {
        println("fun2 start")
        A().fun1()
        println("fun2 end")
    }
}

fun main() {
    val b = B()
    b.fun2()
}


/*
B created
fun2 start
A created
fun1
fun2 end
*/
