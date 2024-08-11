#include <iostream>
#include <unordered_map>

// Forward declarations
class IChatRoom;
class IParticipant;

// ChatRoom interface
class IChatRoom {
public:
    virtual void addParticipant(IParticipant* participant) = 0;
    virtual void broadcast(const std::string& message, const std::string& origin) = 0;
    virtual void sendMessage(const std::string& message, const std::string& to) = 0;
    virtual ~IChatRoom() = default;
};

// Participant interface
class IParticipant {
public:
    virtual std::string getName() const = 0;
    virtual void broadcast(const std::string& message) const = 0;
    virtual void send(const std::string& message, const std::string& to) const = 0;
    virtual void receive(const std::string& message) const = 0;
    virtual ~IParticipant() = default;
};


// ChatRoom implementation
class ChatRoom : public IChatRoom {
private:
    std::unordered_map<std::string, IParticipant*> participants;

public:
    void addParticipant(IParticipant* participant) override {
        participants[participant->getName()] = participant;
    }

    void broadcast(const std::string& message, const std::string& origin) override {
        std::cout << "ChatRoom broadcast Message: " << message << std::endl;
        for (const auto& entry : participants) {
            if (entry.first != origin) {
                entry.second->receive(message);
            }
        }
    }

    void sendMessage(const std::string& message, const std::string& to) override {
        participants[to]->receive(message);
    }
};



// Participant implementation
class Participant : public IParticipant {
private:
    std::string name;
    IChatRoom* chatRoom;

public:
    Participant(const std::string& name, IChatRoom* chatRoom)
        : name(name), chatRoom(chatRoom) {
        chatRoom->addParticipant(this);
    }

    std::string getName() const override {
        return name;
    }

    void broadcast(const std::string& message) const override {
        std::cout << name << " broadcast Message: " << message << std::endl;
        chatRoom->broadcast(message, name);
    }

    void send(const std::string& message, const std::string& to) const override {
        std::cout << name << " sent Message: " << message << std::endl;
        chatRoom->sendMessage(message, to);
    }

    void receive(const std::string& message) const override {
        std::cout << name << " received Message: " << message << std::endl;
    }
};

// Client code
int main() {
    ChatRoom chatRoom;
    Participant james("James", &chatRoom);
    Participant michael("Michael", &chatRoom);
    Participant robert("Robert", &chatRoom);

    michael.send("Good Morning.", "James");
    james.broadcast("Hello, World!");

    return 0;
}

/*
Michael sent Message: Good Morning.
James received Message: Good Morning.
James broadcast Message: Hello, World!
ChatRoom broadcast Message: Hello, World!
Robert received Message: Hello, World!
Michael received Message: Hello, World!
*/