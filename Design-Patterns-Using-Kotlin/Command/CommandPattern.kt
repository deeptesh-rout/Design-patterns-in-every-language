// Invoker
class Invoker {
    private val commands: MutableList<Command> = ArrayList()

    fun setCommand(command: Command) {
        commands.add(command)
    }

    fun executeCommands() {
        for (command in commands) {
            command.execute()
        }
    }

    fun unexecuteCommands() {
        for (command in commands) {
            command.unexecute()
        }
    }
}

// Command
abstract class Command {
    abstract fun execute()
    abstract fun unexecute()
}

// ConcreteCommand
class ConcreteCommand(private val receiver: Receiver) : Command() {
    override fun execute() {
        receiver.action("Action 1")
    }

    override fun unexecute() {
        receiver.action("Action 2")
    }
}

// Receiver
class Receiver {
    fun action(action: String) {
        println(action)
    }
}

// Client Code
fun main() {
    val receiver = Receiver()
    val concreteCommand = ConcreteCommand(receiver)
    val invoker = Invoker()
    invoker.setCommand(concreteCommand)
    invoker.executeCommands()
    invoker.unexecuteCommands()
}

/*
Action 1
Action 2
*/
