interface Mediator {
    fun addColleague(colleague: Colleague)
    fun sendMessage(message: String, colleagueId: String)
}

class ConcreteMediator : Mediator {
    private val colleagues: MutableMap<String, Colleague> = HashMap()

    override fun addColleague(colleague: Colleague) {
        colleagues[colleague.id] = colleague
    }

    override fun sendMessage(message: String, colleagueId: String) {
        println("Mediator pass Message : $message")
        colleagues[colleagueId]!!.receive(message)
    }
}

abstract class Colleague(protected var mediator: Mediator, var id: String) {
    abstract fun send(message: String, to: String)

    abstract fun receive(message: String)
}

class ConcreteColleague1(mediator: Mediator) : Colleague(mediator, "First") {
    override fun send(message: String, to: String) {
        println("$id Sent Message : $message")
        mediator.sendMessage(message, to)
    }

    override fun receive(message: String) {
        println("$id Received Message $message")
    }
}

class ConcreteColleague2(mediator: Mediator) : Colleague(mediator, "Second") {
    override fun send(message: String, to: String) {
        println("$id Sent Message : $message")
        mediator.sendMessage(message, to)
    }

    override fun receive(message: String) {
        println("$id Received Message $message")
    }
}

// Client Code
fun main() {
    val mediator = ConcreteMediator()
    val first = ConcreteColleague1(mediator)
    mediator.addColleague(first)
    val second = ConcreteColleague2(mediator)
    mediator.addColleague(second)

    first.send("Hello, World!", "Second")
}

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
*/