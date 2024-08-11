abstract class Handler(protected var parent: Handler?) {
    protected var helpText: String? = null

    abstract fun showHelperText()

    fun passMessageToNext() {
        if (parent != null && parent is Handler) {
            println("Message passed to next in chain by ${javaClass.simpleName}")
            parent!!.showHelperText()
        }
    }

    fun setHelperText(text: String?) {
        this.helpText = text
    }
}

class Container(parent: Handler?) : Handler(parent) {
    override fun showHelperText() {
        if (helpText != null) {
            println("Help :: $helpText")
        } else {
            passMessageToNext()
        }
    }
}

open class Button(private val label: String, parent: Handler?) : Handler(parent) {
    override fun showHelperText() {
        if (helpText != null) {
            println("Help :: $helpText")
        } else {
            passMessageToNext()
        }
    }
}

class Panel : Handler(null) {
    override fun showHelperText() {
        if (helpText != null) {
            println("Help :: $helpText")
        } else {
            passMessageToNext()
        }
    }
}

// Client code.
fun main() {
    val p = Panel()
    p.setHelperText("Panel help text.")

    val b1: Button = Button("Ok", p)
    b1.setHelperText("Ok button help text.")

    val b2: Button = Button("Cancel", p)

    b1.showHelperText()
    b2.showHelperText()
}

/*
Help :: Ok button help text.
Message passed to next in chain by Button
Help :: Panel help text.
*/