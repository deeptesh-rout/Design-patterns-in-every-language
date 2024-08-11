import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observer.setSubject(this);
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observer.setSubject(null);
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

abstract class Observer {
    protected Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public abstract void update();
}

class ConcreteObserver1 extends Observer {
    public ConcreteObserver1(Subject subject) {
        setSubject(subject);
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(subject instanceof ConcreteSubject ?
                ((ConcreteSubject) subject).getState() + " notified to Observer1" : "");
    }
}

class ConcreteObserver2 extends Observer {
    public ConcreteObserver2(Subject subject) {
        setSubject(subject);
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(subject instanceof ConcreteSubject ?
                ((ConcreteSubject) subject).getState() + " notified to Observer2" : "");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver1 observer1 = new ConcreteObserver1(subject);
        ConcreteObserver2 observer2 = new ConcreteObserver2(subject);

        subject.setState("First state");
        subject.setState("Second state");
    }
}

/*
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
*/