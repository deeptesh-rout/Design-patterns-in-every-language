import Foundation

// Memento
class Memento {
    private var state: String

    init(state: String) {
        self.state = state
    }

    func getState() -> String {
        return state
    }
}

// CareTaker
class CareTaker {
    private var history: [Memento]
    private var top: Int
    private var max: Int

    init() {
        self.history = []
        self.top = -1
        self.max = -1
    }

    func addMemento(_ m: Memento) {
        top += 1
        max = top
        if top <= history.count - 1 {
            history[top] = m
        } else {
            history.append(m)
        }
    }

    func getMemento(_ index: Int) -> Memento {
        return history[index]
    }

    func undo() -> Memento {
        print("Undoing state.")
        if top <= 0 {
            top = 0
            return getMemento(0)
        }

        top -= 1
        return getMemento(top)
    }

    func redo() -> Memento {
        print("Redoing state.")
        if top >= (history.count - 1) || top >= max {
            return getMemento(top)
        }

        top += 1
        return getMemento(top)
    }

    func getStatesCount() -> Int {
        return history.count
    }
}

// Originator
class Originator {
    private var state: String
    private var careTaker: CareTaker

    init() {
        self.state = ""
        self.careTaker = CareTaker()
    }

    func setState(_ state: String) {
        self.state = state
        careTaker.addMemento(createMemento())
    }

    func getState() -> String {
        return state
    }

    func createMemento() -> Memento {
        return Memento(state: state)
    }

    func setMemento(_ m: Memento) {
        state = m.getState()
    }

    func undo() {
        setMemento(careTaker.undo())
    }

    func redo() {
        setMemento(careTaker.redo())
    }
}

// Client code
let originator = Originator()
originator.setState("State 1")
print(originator.getState())

originator.setState("State 2")
print(originator.getState())

originator.setState("State 3")
print(originator.getState())

originator.undo()
print(originator.getState())

originator.undo()
print(originator.getState())

originator.redo()
print(originator.getState())

originator.redo()
print(originator.getState())

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