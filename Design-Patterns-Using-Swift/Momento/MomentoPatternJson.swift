import Foundation

class Memento: NSCopying {
    private var state: Any

    init(state: Any) {
        self.state = state
    }

    func getState() -> Any {
        return state
    }

    func copy(with zone: NSZone? = nil) -> Any {
        let copy = Memento(state: state)
        return copy
    }
}

class Originator {
    private var state: Any 

    init() {
        self.state = ""
    }

    func setState(_ state: Any) {
        self.state = state
    }

    func getState() -> Any {
        return state
    }

    func createMemento() -> Memento {
        return Memento(state: state)
    }

    func setMemento(_ m: Memento) {
        self.state = m.getState()
    }
}

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
            let copiedMemento = m.copy() as! Memento
            history[top] = copiedMemento
        } else {
            let copiedMemento = m.copy() as! Memento
            history.append(copiedMemento)
        }
    }

    func getMemento(_ index: Int) -> Memento {
        return history[index]
    }

    func undo() -> Memento {
        print("Undoing state.")
        if top <= 0 {
            top = 0
            return history[0]
        }

        top -= 1
        return history[top]
    }

    func redo() -> Memento {
        print("Redoing state.")
        if top >= (history.count - 1) || top >= max {
            return history[top]
        }

        top += 1
        return history[top]
    }

    func getStatesCount() -> Int {
        return history.count
    }
}

// Client Code
let originator = Originator()
let careTaker = CareTaker()

originator.setState("State 1")
careTaker.addMemento(originator.createMemento())
print(originator.getState())

originator.setState("State 2")
careTaker.addMemento(originator.createMemento())
print(originator.getState())

originator.setState("State 3")
careTaker.addMemento(originator.createMemento())
print(originator.getState())

originator.setMemento(careTaker.undo())
print(originator.getState())

originator.setMemento(careTaker.undo())
print(originator.getState())

originator.setState("State 4")
careTaker.addMemento(originator.createMemento())
print(originator.getState())

originator.setMemento(careTaker.redo())
print(originator.getState())

originator.setMemento(careTaker.redo())
print(originator.getState())

originator.setMemento(careTaker.redo())
print(originator.getState())

/*
State 1
State 2
State 3
Undoing state.
State 2
Undoing state.
State 1
State 4
Redoing state.
State 4
Redoing state.
State 4
Redoing state.
State 4
*/