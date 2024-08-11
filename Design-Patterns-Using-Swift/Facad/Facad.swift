// Subsystem1
class Subsystem1 {
    func operation1() {
        print("Subsystem1 operation1")
    }

    func operation2() {
        print("Subsystem1 operation2")
    }
}

// Subsystem2
class Subsystem2 {
    func operation1() {
        print("Subsystem2 operation1")
    }

    func operation2() {
        print("Subsystem2 operation2")
    }
}

// SystemManagerFacade
class SystemManagerFacade {
    private var subsystem1: Subsystem1
    private var subsystem2: Subsystem2

    init() {
        self.subsystem1 = Subsystem1()
        self.subsystem2 = Subsystem2()
    }

    func operation() {
        subsystem1.operation1()
        subsystem1.operation2()
        subsystem2.operation1()
        subsystem2.operation2()
    }
}

// Client code
let facade = SystemManagerFacade()
facade.operation()

/*
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
*/