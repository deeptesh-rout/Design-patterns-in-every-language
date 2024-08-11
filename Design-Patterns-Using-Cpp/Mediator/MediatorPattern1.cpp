#include <iostream>
#include <unordered_map>

class Mediator;

class Colleague {
protected:
    Mediator* mediator;
    std::string id;

public:
    Colleague(Mediator* mediator, const std::string& id) : mediator(mediator), id(id) {}

    virtual void send(const std::string& message, const std::string& to) = 0;
    virtual void receive(const std::string& message) = 0;

    const std::string& getId() const {
        return id;
    }
};

class Mediator {
public:
    virtual void addColleague(Colleague* colleague) = 0;
    virtual void sendMessage(const std::string& message, const std::string& colleagueId) = 0;
    virtual ~Mediator() = default;
};

class ConcreteMediator : public Mediator {
private:
    std::unordered_map<std::string, Colleague*> colleagues;

public:
    void addColleague(Colleague* colleague) override {
        colleagues[colleague->getId()] = colleague;
    }

    void sendMessage(const std::string& message, const std::string& colleagueId) override {
        std::cout << "Mediator pass Message : " << message << std::endl;
        colleagues[colleagueId]->receive(message);
    }
};

class ConcreteColleague1 : public Colleague {
public:
    ConcreteColleague1(Mediator* mediator) : Colleague(mediator, "First") {}

    void send(const std::string& message, const std::string& to) override {
        std::cout << id << " Sent Message : " << message << std::endl;
        mediator->sendMessage(message, to);
    }

    void receive(const std::string& message) override {
        std::cout << id << " Received Message " << message << std::endl;
    }
};

class ConcreteColleague2 : public Colleague {
public:
    ConcreteColleague2(Mediator* mediator) : Colleague(mediator, "Second") {}

    void send(const std::string& message, const std::string& to) override {
        std::cout << id << " Sent Message : " << message << std::endl;
        mediator->sendMessage(message, to);
    }

    void receive(const std::string& message) override {
        std::cout << id << " Received Message " << message << std::endl;
    }
};

// Client code
int main() {
    ConcreteMediator mediator;
    ConcreteColleague1 first(&mediator);
    mediator.addColleague(&first);
    ConcreteColleague2 second(&mediator);
    mediator.addColleague(&second);

    first.send("Hello, World!", "Second");

    return 0;
}

/*
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
*/

