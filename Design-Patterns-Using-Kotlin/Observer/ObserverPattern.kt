import java.util.ArrayList

abstract class Subject {
    private val observers: MutableList<Observer> = ArrayList()

    fun attach(observer: Observer) {
        observer.subject = this
        observers.add(observer)
    }

    fun detach(observer: Observer) {
        observer.subject = null
        observers.remove(observer)
    }

    fun notifyObservers() {
        observers.forEach { it.update() }
    }
}

class ConcreteSubject : Subject() {
    var state: String? = null
        set(value) {
            field = value
            notifyObservers()
        }
}

abstract class Observer {
    var subject: Subject? = null

    abstract fun update()
}

class ConcreteObserver1(subject: Subject) : Observer() {
    init {
        subject.attach(this)
        this.subject = subject
    }

    override fun update() {
        println(if (subject is ConcreteSubject)
            (subject as ConcreteSubject).state + " notified to Observer1"
        else
            "")
    }
}

class ConcreteObserver2(subject: Subject) : Observer() {
    init {
        subject.attach(this)
        this.subject = subject
    }

    override fun update() {
        println(if (subject is ConcreteSubject)
            (subject as ConcreteSubject).state + " notified to Observer2"
        else
            "")
    }
}

// Client code
fun main() {
    val subject = ConcreteSubject()
    ConcreteObserver1(subject)
    ConcreteObserver2(subject)
    subject.state = "First state"
    subject.state = "Second state"
}


/*
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
*/