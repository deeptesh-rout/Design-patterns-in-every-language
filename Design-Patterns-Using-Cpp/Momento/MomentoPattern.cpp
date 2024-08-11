#include <iostream>
#include <vector>

// Memento
class Memento {
private:
    std::string state;

public:
    Memento(const std::string& state) : state(state) {}

    const std::string& getState() const {
        return state;
    }
};

// CareTaker
class CareTaker {
private:
    std::vector<Memento> history;
    int top;
    int max;

public:
    CareTaker() : top(-1), max(-1) {}

    void addMemento(const Memento& m) {
        top += 1;
        max = top;
        if (top <= static_cast<int>(history.size()) - 1) {
            history[top] = m;
        } else {
            history.push_back(m);
        }
    }

    const Memento& getMemento(int index) const {
        return history[index];
    }

    Memento undo() {
        std::cout << "Undoing state." << std::endl;
        if (top <= 0) {
            top = 0;
            return getMemento(0);
        }

        top -= 1;
        return getMemento(top);
    }

    Memento redo() {
        std::cout << "Redoing state." << std::endl;
        if (top >= static_cast<int>(history.size()) - 1 || top >= max) {
            return getMemento(top);
        }

        top += 1;
        return getMemento(top);
    }

    int getStatesCount() const {
        return history.size();
    }
};

// Originator
class Originator {
private:
    std::string state;

public:
    void setState(const std::string& state) {
        this->state = state;
    }

    const std::string& getState() const {
        return state;
    }

    Memento createMemento() const {
        return Memento(state);
    }

    void setMemento(const Memento& m) {
        setState(m.getState());
    }
};

// Client code
int main() {
    Originator originator;
    CareTaker careTaker;

    originator.setState("State 1");
    careTaker.addMemento(originator.createMemento());
    std::cout << originator.getState() << std::endl;

    originator.setState("State 2");
    careTaker.addMemento(originator.createMemento());
    std::cout << originator.getState() << std::endl;

    originator.setState("State 3");
    careTaker.addMemento(originator.createMemento());
    std::cout << originator.getState() << std::endl;

    originator.setMemento(careTaker.undo());
    std::cout << originator.getState() << std::endl;

    originator.setMemento(careTaker.undo());
    std::cout << originator.getState() << std::endl;

    originator.setMemento(careTaker.redo());
    std::cout << originator.getState() << std::endl;

    originator.setMemento(careTaker.redo());
    std::cout << originator.getState() << std::endl;

    return 0;
}

/*
State 1
State 2
State 3
Undoing state.
State 2
Undoing state.
State 1
Redoing state.
State 2
Redoing state.
State 3
*/
