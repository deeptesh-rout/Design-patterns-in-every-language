// Memento
class Memento(val state: String?)

// CareTaker
class CareTaker {
    private val history: MutableList<Memento> = ArrayList()
    private var top: Int = -1
    private var max: Int= -1

    fun addMemento(m: Memento) {
        top += 1
        max = top
        if (top <= history.size - 1) {
            history[top] = m
        } else {
            history.add(m)
        }
    }

    fun getMemento(index: Int): Memento {
        return history[index]
    }

    fun undo(): Memento {
        println("Undoing state.")
        if (top <= 0) {
            top = 0
            return getMemento(0)
        }

        top -= 1
        return getMemento(top)
    }

    fun redo(): Memento {
        println("Redoing state.")
        if (top >= (history.size - 1) || top >= max) {
            return getMemento(top)
        }

        top += 1
        return getMemento(top)
    }

    val statesCount: Int
        get() = history.size
}

// Originator
class Originator {
    var state: String? = null

    fun createMemento(): Memento {
        return Memento(state)
    }

    fun setMemento(m: Memento) {
        state = m.state
    }
}

// Client code
fun main() {
    val originator = Originator()
    val careTaker = CareTaker()

    originator.state = "State 1"
    careTaker.addMemento(originator.createMemento())
    println(originator.state)

    originator.state = "State 2"
    careTaker.addMemento(originator.createMemento())
    println(originator.state)

    originator.state = "State 3"
    careTaker.addMemento(originator.createMemento())
    println(originator.state)

    originator.setMemento(careTaker.undo())
    println(originator.state)

    originator.setMemento(careTaker.undo())
    println(originator.state)

    originator.setMemento(careTaker.redo())
    println(originator.state)

    originator.setMemento(careTaker.redo())
    println(originator.state)
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