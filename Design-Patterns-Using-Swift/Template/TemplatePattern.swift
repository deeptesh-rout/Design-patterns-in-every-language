import Foundation

class AbstractClass {
    final func templateMethod() {
        operation1()
        operation2()
    }

    func operation1() {
        fatalError("Abstract method. Subclasses must implement operation1.")
    }

    func operation2() {
        fatalError("Abstract method. Subclasses must implement operation2.")
    }
}

class ConcreteClass1: AbstractClass {
    override func operation1() {
        print("Concrete Class 1 : Operation 1")
    }

    override func operation2() {
        print("Concrete Class 1 : Operation 2")
    }
}

class ConcreteClass2: AbstractClass {
    override func operation1() {
        print("Concrete Class 2 : Operation 1")
    }

    override func operation2() {
        print("Concrete Class 2 : Operation 2")
    }
}

// Client code.
let concreteClass = ConcreteClass1()
concreteClass.templateMethod()

/*
Concrete Class 1 : Operation 1
Concrete Class 1 : Operation 2
*/