import java.util.ArrayList;
import java.util.List;

// Invoker
class Invoker {
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void unexecuteCommands() {
        for (Command command : commands) {
            command.unexecute();
        }
    }
}

// Command
abstract class Command {
    public abstract void execute();
    public abstract void unexecute();
}

// ConcreteCommand
class ConcreteCommand extends Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action("Action 1");
    }

    @Override
    public void unexecute() {
        receiver.action("Action 2");
    }
}

// Receiver
class Receiver {
    public void action(String action) {
        System.out.println(action);
    }
}

// Client Code
public class CommandPattern {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        ConcreteCommand concreteCommand = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();

        invoker.setCommand(concreteCommand);
        invoker.executeCommands();
        invoker.unexecuteCommands();
    }
}

/*
Action 1
Action 2
 */