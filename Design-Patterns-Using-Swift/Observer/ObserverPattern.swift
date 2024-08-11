import Foundation

// Subject
class Subject {
    private var observers = [Observer]()

    func attach(observer: Observer) {
        observer.setSubject(subject: self)
        observers.append(observer)
    }

    func detach(observer: Observer) {
        observer.setSubject(subject: nil)
        observers.removeAll { $0 === observer }
    }

    func notifyObservers() {
        for observer in observers {
            observer.update()
        }
    }
}

// ConcreteSubject
class ConcreteSubject: Subject {
    private var state: String = ""

    func getState() -> String {
        return state
    }

    func setState(state: String) {
        self.state = state
        notifyObservers()
    }
}

// Observer
class Observer {
    weak var subject: Subject?

    func setSubject(subject: Subject?) {
        self.subject = subject
    }

    func update() {
        // To be implemented by concrete observers
    }
}

// ConcreteObserver1
class ConcreteObserver1: Observer {
    init(subject: Subject) {
        super.init()
        setSubject(subject: subject)
        subject.attach(observer: self)
    }

    override func update() {
        if let concreteSubject = subject as? ConcreteSubject {
            print("\(concreteSubject.getState()) notified to Observer1")
        }
    }
}

// ConcreteObserver2
class ConcreteObserver2: Observer {
    init(subject: Subject) {
        super.init()
        setSubject(subject: subject)
        subject.attach(observer: self)
    }

    override func update() {
        if let concreteSubject = subject as? ConcreteSubject {
            print("\(concreteSubject.getState()) notified to Observer2")
        }
    }
}

// Client Code
let subject = ConcreteSubject()
let observer1 = ConcreteObserver1(subject: subject)
let observer2 = ConcreteObserver2(subject: subject)

print( "Observers: \(observer1) and \(observer2)")
subject.setState(state: "First state")
subject.setState(state: "Second state")

/*
Observers: ObserverPattern.ConcreteObserver1 and ObserverPattern.ConcreteObserver2
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
*/
