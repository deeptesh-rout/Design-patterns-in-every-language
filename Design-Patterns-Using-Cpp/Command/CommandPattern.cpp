#include <iostream>
#include <vector>

// Forward declaration
class Receiver;

// Command
class Command {
public:
    virtual void execute() = 0;
    virtual void unexecute() = 0;
};

// ConcreteCommand
class ConcreteCommand : public Command {
private:
    Receiver* receiver;

public:
    ConcreteCommand(Receiver* receiver);

    void execute() override;
    void unexecute() override;
};

// Receiver
class Receiver {
public:
    void action(const std::string& action);
};

// Invoker
class Invoker {
private:
    std::vector<Command*> commands;

public:
    void setCommand(Command* command);
    void executeCommands();
    void unexecuteCommands();
};

// ConcreteCommand implementation
ConcreteCommand::ConcreteCommand(Receiver* receiver) : receiver(receiver) {}

void ConcreteCommand::execute() {
    receiver->action("Action 1");
}

void ConcreteCommand::unexecute() {
    receiver->action("Action 2");
}

// Receiver implementation
void Receiver::action(const std::string& action) {
    std::cout << action << std::endl;
}

// Invoker implementation
void Invoker::setCommand(Command* command) {
    commands.push_back(command);
}

void Invoker::executeCommands() {
    for (auto command : commands) {
        command->execute();
    }
}

void Invoker::unexecuteCommands() {
    for (auto command : commands) {
        command->unexecute();
    }
}

// Client Code
int main() {
    Receiver receiver;
    ConcreteCommand concreteCommand(&receiver);
    Invoker invoker;

    invoker.setCommand(&concreteCommand);
    invoker.executeCommands();
    invoker.unexecuteCommands();

    return 0;
}

/*
Action 1
Action 2
*/