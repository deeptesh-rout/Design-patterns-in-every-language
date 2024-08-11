import java.util.HashMap;
import java.util.Map;

interface Mediator {
    void addColleague(Colleague colleague);
    void sendMessage(String message, String colleagueId);
}

class ConcreteMediator implements Mediator {
    private Map<String, Colleague> colleagues = new HashMap<>();

    @Override
    public void addColleague(Colleague colleague) {
        colleagues.put(colleague.getId(), colleague);
    }

    @Override
    public void sendMessage(String message, String colleagueId) {
        System.out.println("Mediator pass Message : " + message);
        colleagues.get(colleagueId).receive(message);
    }
}

abstract class Colleague {
    protected Mediator mediator;
    protected String id;

    public Colleague(Mediator mediator, String id) {
        this.mediator = mediator;
        this.id = id;
    }

    abstract void send(String message, String to);

    abstract void receive(String message);

    public String getId() {
        return id;
    }
}

class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator, "First");
    }

    @Override
    void send(String message, String to) {
        System.out.println(id + " Sent Message : " + message);
        mediator.sendMessage(message, to);
    }

    @Override
    void receive(String message) {
        System.out.println(id + " Received Message " + message);
    }
}

class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator, "Second");
    }

    @Override
    void send(String message, String to) {
        System.out.println(id + " Sent Message : " + message);
        mediator.sendMessage(message, to);
    }

    @Override
    void receive(String message) {
        System.out.println(id + " Received Message " + message);
    }
}

public class MediatorPattern1 {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague1 first = new ConcreteColleague1(mediator);
        mediator.addColleague(first);
        ConcreteColleague2 second = new ConcreteColleague2(mediator);
        mediator.addColleague(second);
        first.send("Hello, World!", "Second");
    }
}

/* 
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
*/