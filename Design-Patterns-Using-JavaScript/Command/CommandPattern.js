// Invoker
class Invoker {
    constructor() {
        this.commands = [];
    }

    setCommand(command) {
        this.commands.push(command);
    }

    executeCommands() {
        for (const command of this.commands) {
            command.execute();
        }
    }

    unexecuteCommands() {
        for (const command of this.commands) {
            command.unexecute();
        }
    }
}

// Command
class Command {
    execute() {
        throw new Error("Abstract method: execute");
    }

    unexecute() {
        throw new Error("Abstract method: unexecute");
    }
}

// ConcreteCommand
class ConcreteCommand extends Command {
    constructor(receiver) {
        super();
        this.receiver = receiver;
    }

    execute() {
        this.receiver.action("Action 1");
    }

    unexecute() {
        this.receiver.action("Action 2");
    }
}

// Receiver
class Receiver {
    action(action) {
        console.log(action);
    }
}

// Client Code
const receiver = new Receiver();
const concreteCommand = new ConcreteCommand(receiver);
const invoker = new Invoker();

invoker.setCommand(concreteCommand);
invoker.executeCommands();
invoker.unexecuteCommands();

/*
Action 1
Action 2
*/