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

    Memento* clone() const {
        return new Memento(*this);
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

    Memento* createMemento() const {
        return new Memento(state);
    }

    void setMemento(const Memento* m) {
        if (m) {
            state = m->getState();
        }
    }
};

// CareTaker
class CareTaker {
private:
    std::vector<Memento*> history;
    int top;
    int max;

public:
    CareTaker() : top(-1), max(-1) {}

    ~CareTaker() {
        for (Memento* m : history) {
            delete m;
        }
    }

    void addMemento(const Memento* m) {
        top += 1;
        max = top;
        if (top <= static_cast<int>(history.size()) - 1) {
            delete history[top];
            history[top] = m->clone();
        } else {
            history.push_back(m->clone());
        }
    }

    const Memento* getMemento(int index) const {
        return history[index];
    }

    Memento* undo() {
        std::cout << "Undoing state." << std::endl;
        if (top <= 0) {
            top = 0;
            return history[0];
        }

        top -= 1;
        return history[top];
    }

    Memento* redo() {
        std::cout << "Redoing state." << std::endl;
        if (top >= static_cast<int>(history.size()) - 1 || top >= max) {
            return history[top];
        }

        top += 1;
        return history[top];
    }

    int getStatesCount() const {
        return history.size();
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

    const Memento* undoMemento = careTaker.undo();
    originator.setMemento(undoMemento);
    std::cout << originator.getState() << std::endl;

    const Memento* redoMemento = careTaker.redo();
    originator.setMemento(redoMemento);
    std::cout << originator.getState() << std::endl;

    originator.setState("State 4");
    careTaker.addMemento(originator.createMemento());
    std::cout << originator.getState() << std::endl;

    redoMemento = careTaker.redo();
    originator.setMemento(redoMemento);
    std::cout << originator.getState() << std::endl;

    redoMemento = careTaker.redo();
    originator.setMemento(redoMemento);
    std::cout << originator.getState() << std::endl;

    redoMemento = careTaker.redo();
    originator.setMemento(redoMemento);
    std::cout << originator.getState() << std::endl;

    return 0;
}

/*
State 1
State 2
State 3
Undoing state.
State 2
Redoing state.
State 3
State 4
Redoing state.
State 4
Redoing state.
State 4
Redoing state.
State 4
*/
