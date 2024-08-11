abstract class ATMHandlerAbstract(protected var successor: ATMHandlerAbstract?, protected var denomination: Int) {
    abstract fun handleRequest(amount: Int)
}

class ATMHandler(successor: ATMHandlerAbstract?, denomination: Int) : ATMHandlerAbstract(successor, denomination) {
    override fun handleRequest(amount: Int) {
        val q = amount / denomination
        val r = amount % denomination

        if (q != 0) {
            println("$q notes of $denomination")
        }

        if (r != 0 && successor != null) {
            successor!!.handleRequest(r)
        }
    }
}

// Client code.
fun main() {
    val handler: ATMHandlerAbstract = ATMHandler(
            ATMHandler(
                    ATMHandler(
                            ATMHandler(null, 10), 50
                    ), 100
            ), 1000
    )
    handler.handleRequest(5560)
}


/*
5 notes of 1000
5 notes of 100
1 notes of 50
1 notes of 10
 */

