#include <iostream>
#include <vector>
#include <algorithm>

class Subject;

class Observer {
public:
    virtual void update(const std::string& newState) = 0;
    virtual void setSubject(Subject* subject) = 0;
};

class Subject {
private:
    std::vector<Observer*> observers;

public:
    void attach(Observer* observer) {
        observer->setSubject(this);
        observers.push_back(observer);
    }

    void detach(Observer* observer) {
        observer->setSubject(nullptr);
        auto it = std::find(observers.begin(), observers.end(), observer);
        observers.erase(it);
    }

    void notifyObservers(const std::string& newState) {
        for (Observer* observer : observers) {
            observer->update(newState);
        }
    }
};

class ConcreteSubject : public Subject {
private:
    std::string state;

public:
    const std::string& getState() const {
        return state;
    }

    void setState(const std::string& newState) {
        state = newState;
        notifyObservers(newState);
    }
};

class ConcreteObserver1 : public Observer {
private:
    Subject* subject;

public:
    ConcreteObserver1(Subject* subject) : subject(subject) {
        subject->attach(this);
    }

    void update(const std::string& newState) override {
        std::cout << newState << " notified to Observer1" << std::endl;
    }

    void setSubject(Subject* newSubject) override {
        subject = newSubject;
    }
};

class ConcreteObserver2 : public Observer {
private:
    Subject* subject;

public:
    ConcreteObserver2(Subject* subject) : subject(subject) {
        subject->attach(this);
    }

    void update(const std::string& newState) override {
        std::cout << newState << " notified to Observer2" << std::endl;
    }

    void setSubject(Subject* newSubject) override {
        subject = newSubject;
    }
};

// Client code
int main() {
    ConcreteSubject subject;
    ConcreteObserver1 observer1(&subject);
    ConcreteObserver2 observer2(&subject);

    subject.setState("First state");
    subject.setState("Second state");

    return 0;
}

/*
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
*/