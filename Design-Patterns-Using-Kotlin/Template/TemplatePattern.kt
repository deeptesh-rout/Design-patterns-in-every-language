abstract class AbstractClass {
    fun templateMethod() {
        operation1()
        operation2()
    }

    abstract fun operation1()
    abstract fun operation2()
}

class ConcreteClass1 : AbstractClass() {
    override fun operation1() {
        println("Concrete Class 1 : Operation 1")
    }

    override fun operation2() {
        println("Concrete Class 1 : Operation 2")
    }
}

class ConcreteClass2 : AbstractClass() {
    override fun operation1() {
        println("Concrete Class 2 : Operation 1")
    }

    override fun operation2() {
        println("Concrete Class 2 : Operation 2")
    }
}

// Client code
fun main() {
    val concreteClass: AbstractClass = ConcreteClass1()
    concreteClass.templateMethod()
}

/*
Concrete Class 1 : Operation 1
Concrete Class 1 : Operation 2
*/