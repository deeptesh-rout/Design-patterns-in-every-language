interface BulbState {
    fun flip(bc: BulbControl)
    override fun toString(): String
}

class BulbControl {
    private var current: BulbState

    init {
        this.current = Off()
    }

    fun setState(state: BulbState) {
        this.current = state
    }

    fun flip() {
        current.flip(this)
    }

    fun toStringState(): String {
        return current.toString()
    }
}

class On : BulbState {
    override fun flip(bc: BulbControl) {
        bc.setState(Off())
    }

    override fun toString(): String {
        return "On"
    }
}

class Off : BulbState {
    override fun flip(bc: BulbControl) {
        bc.setState(On())
    }

    override fun toString(): String {
        return "Off"
    }
}

// Client code.
fun main() {
    val c = BulbControl()
    c.flip()
    println(c.toStringState())
    c.flip()
    println(c.toStringState())
}

/*
On
Off
*/