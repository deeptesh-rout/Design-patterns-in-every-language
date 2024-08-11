class Memento(private val state: String) {
    fun getStateFun(): String {
        return state
    }
}

class CareTaker {
    private val history: MutableList<Memento> = mutableListOf()
    private var top = -1
    private var max = -1

    fun addMemento(m: Memento) {
        top++
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
        top--
        return getMemento(top)
    }

    fun redo(): Memento {
        println("Redoing state.")
        if (top >= history.size - 1 || top >= max) {
            return getMemento(top)
        }
        top++
        return getMemento(top)
    }

    fun getStateFunsCount(): Int {
        return history.size
    }
}

class Originator {
    private val careTaker: CareTaker = CareTaker()
    var state: String = ""

    fun setStateFun(state: String) {
        this.state = state
        careTaker.addMemento(createMemento())
    }

    fun getStateFun(): String {
        return state
    }

    private fun createMemento(): Memento {
        return Memento(state)
    }

    fun setMemento(m: Memento) {
        state = m.getStateFun()
    }

    fun undo() {
        setMemento(careTaker.undo())
    }

    fun redo() {
        setMemento(careTaker.redo())
    }
}

// Client Code
fun main() {
    val originator = Originator()
    originator.setStateFun("State 1")
    println(originator.getStateFun())
    originator.setStateFun("State 2")
    println(originator.getStateFun())
    originator.setStateFun("State 3")
    println(originator.getStateFun())

    originator.undo()
    println(originator.getStateFun())
    originator.undo()
    println(originator.getStateFun())
    originator.redo()
    println(originator.getStateFun())
    originator.redo()
    println(originator.getStateFun())
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