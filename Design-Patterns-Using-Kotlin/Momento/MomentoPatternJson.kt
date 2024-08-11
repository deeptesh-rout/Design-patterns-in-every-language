import java.util.ArrayList
import kotlin.collections.MutableList

data class Memento(val state: Map<String, Any?>)

class Originator {
    private var state: MutableMap<String, Any?> = mutableMapOf()

    fun setState(state: String) {
        this.state["state"] = state
    }

    fun getState(): Map<String, Any?> {
        return state
    }

    fun createMemento(): Memento {
        return Memento(HashMap(state))
    }

    fun setMemento(m: Memento) {
        println(m.state)
        state = HashMap(m.state)
    }
}

class CareTaker {
    private val history: MutableList<Memento> = ArrayList()
    private var top = -1
    private var max = -1

    fun addMemento(m: Memento) {
        top++
        max = top
        if (top <= history.size - 1) {
            history[top] = Memento(HashMap(m.state))
        } else {
            history.add(Memento(HashMap(m.state)))
        }
    }

    fun getMemento(index: Int): Memento {
        return history[index]
    }

    fun undo(): Memento {
        println("Undoing state.")
        if (top <= 0) {
            return Memento(HashMap(getMemento(0).state))
        }

        top--
        return Memento(HashMap(getMemento(top).state))
    }

    fun redo(): Memento {
        println("Redoing state.")
        if (top >= history.size - 1 || top >= max) {
            return Memento(HashMap(getMemento(top).state))
        }

        top++
        return Memento(HashMap(getMemento(top).state))
    }

    fun getStatesCount(): Int {
        return history.size
    }
}

// Client Code
fun main() {
    val originator = Originator()
    val careTaker = CareTaker()

    originator.setState("State 1")
    careTaker.addMemento(originator.createMemento())
    println(originator.getState())

    originator.setState("State 2")
    careTaker.addMemento(originator.createMemento())
    println(originator.getState())

    originator.setState("State 3")
    careTaker.addMemento(originator.createMemento())
    println(originator.getState())

    originator.setMemento(careTaker.undo())
    println(originator.getState())

    originator.setMemento(careTaker.undo())
    println(originator.getState())

    originator.setState("State 4")
    careTaker.addMemento(originator.createMemento())
    println(originator.getState())

    originator.setMemento(careTaker.redo())
    println(originator.getState())

    originator.setMemento(careTaker.redo())
    println(originator.getState())

    originator.setMemento(careTaker.redo())
    println(originator.getState())
}

/*
{state=State 1}
{state=State 2}
{state=State 3}
Undoing state.
{state=State 2}
{state=State 2}
Undoing state.
{state=State 1}
{state=State 1}
{state=State 4}
Redoing state.
{state=State 4}
{state=State 4}
Redoing state.
{state=State 4}
{state=State 4}
Redoing state.
{state=State 4}
{state=State 4}
*/