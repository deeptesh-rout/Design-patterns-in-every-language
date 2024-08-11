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
    protected String id;
    protected Mediator mediator;

    public Colleague(String id, Mediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    abstract void send(String message, String to);

    abstract void receive(String message);

    public String getId() {
        return id;
    }
}

class ConcreteColleague extends Colleague {
    public ConcreteColleague(String id, Mediator mediator) {
        super(id, mediator);
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

public class MediatorPattern2 {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague first = new ConcreteColleague("First", mediator);
        mediator.addColleague(first);

        ConcreteColleague second = new ConcreteColleague("Second", mediator);
        mediator.addColleague(second);

        first.send("Hello, World!", "Second");
        second.send("Hi, World!", "First");
    }
}

/* 
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
Second Sent Message : Hi, World!
Mediator pass Message : Hi, World!
First Received Message Hi, World!
*/

