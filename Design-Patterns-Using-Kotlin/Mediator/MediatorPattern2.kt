interface Mediator {
    fun addColleague(colleague: Colleague)
    fun sendMessage(message: String, colleagueId: String)
}

class ConcreteMediator : Mediator {
    private val colleagues = mutableMapOf<String, Colleague>()

    override fun addColleague(colleague: Colleague) {
        colleagues[colleague.id] = colleague
    }

    override fun sendMessage(message: String, colleagueId: String) {
        println("Mediator pass Message: $message")
        colleagues[colleagueId]?.receive(message)
    }
}

interface Colleague {
    val id: String
    fun send(message: String, to: String)
    fun receive(message: String)
}

class ConcreteColleague(override val id: String, private val mediator: Mediator) : Colleague {
    override fun send(message: String, to: String) {
        println("$id Sent Message: $message")
        mediator.sendMessage(message, to)
    }

    override fun receive(message: String) {
        println("$id Received Message: $message")
    }
}

// Client Code
fun main() {
    val mediator: Mediator = ConcreteMediator()
    val first = ConcreteColleague("First", mediator)
    mediator.addColleague(first)

    val second = ConcreteColleague("Second", mediator)
    mediator.addColleague(second)

    first.send("Hello, World!", "Second")
    second.send("Hi, World!", "First")
}

/*
First Sent Message: Hello, World!
Mediator pass Message: Hello, World!
Second Received Message: Hello, World!
Second Sent Message: Hi, World!
Mediator pass Message: Hi, World!
First Received Message: Hi, World!
*/