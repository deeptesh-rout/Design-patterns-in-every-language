import java.util.HashMap;
import java.util.Map;

interface IChatRoom {
    void addParticipant(IParticipant participant);
    void broadcast(String message, String origin);
    void sendMessage(String message, String to);
}

class ChatRoom implements IChatRoom {
    private Map<String, IParticipant> participants = new HashMap<>();

    @Override
    public void addParticipant(IParticipant participant) {
        participants.put(participant.getName(), participant);
    }

    @Override
    public void broadcast(String message, String origin) {
        System.out.println("ChatRoom broadcast Message : " + message);
        participants.values().stream()
                .filter(p -> !p.getName().equals(origin))
                .forEach(p -> p.receive(message));
    }

    @Override
    public void sendMessage(String message, String to) {
        participants.get(to).receive(message);
    }
}

interface IParticipant {
    String getName();
    void broadcast(String message);
    void send(String message, String to);
    void receive(String message);
}

class Participant implements IParticipant {
    private String name;
    private IChatRoom chatRoom;

    public Participant(String name, IChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
        chatRoom.addParticipant(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void broadcast(String message) {
        System.out.println(name + " broadcast Message : " + message);
        chatRoom.broadcast(message, name);
    }

    @Override
    public void send(String message, String to) {
        System.out.println(name + " sent Message : " + message);
        chatRoom.sendMessage(message, to);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received Message : " + message);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        Participant james = new Participant("James", chatRoom);
        Participant michael = new Participant("Michael", chatRoom);
        Participant robert = new Participant("Robert", chatRoom);

        michael.send("Good Morning.", "James");
        james.broadcast("Hello, World!");
    }
}

/* 
Michael sent Message : Good Morning.
James received Message : Good Morning.
James broadcast Message : Hello, World!
ChatRoom broadcast Message : Hello, World!
Robert received Message : Hello, World!
Michael received Message : Hello, World!
*/