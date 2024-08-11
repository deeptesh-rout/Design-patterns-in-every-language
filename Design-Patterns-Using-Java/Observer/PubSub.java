import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Publisher {
    private Map<String, List<Subscriber>> topicSubscribers = new HashMap<>();

    public void subscribe(Subscriber subscriber, String topic) {
        topicSubscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
        System.out.println("Subscribing: " + subscriber.getId() + " to topic: " + topic);
    }

    public void unsubscribe(Subscriber subscriber, String topic) {
        topicSubscribers.getOrDefault(topic, new ArrayList<>()).remove(subscriber);
        System.out.println("Unsubscribing: " + subscriber.getId() + " to topic: " + topic);
    }

    public void notifySubscribers(String data, String topic) {
        if (topicSubscribers.containsKey(topic)) {
            System.out.println("Publishing: " + data + " in topic: " + topic);
            for (Subscriber subscriber : topicSubscribers.get(topic)) {
                subscriber.update(data);
            }
        }
    }
}

class Subscriber {
    private String id;

    public Subscriber(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void update(String data) {
        System.out.println("Subscriber " + id + " got :: " + data);
    }
}

public class PubSub {
    public static void main(String[] args) {
        Publisher pub = new Publisher();

        Subscriber sub1 = new Subscriber("Subscriber1");
        Subscriber sub2 = new Subscriber("Subscriber2");
        Subscriber sub3 = new Subscriber("Subscriber3");

        System.out.println();
        pub.subscribe(sub1, "topic1");
        pub.subscribe(sub2, "topic2");
        pub.subscribe(sub3, "topic2");

        System.out.println();
        pub.notifySubscribers("Topic 1 data", "topic1");

        System.out.println();
        pub.notifySubscribers("Topic 2 data", "topic2");

        System.out.println();
        pub.unsubscribe(sub3, "topic2");
        pub.notifySubscribers("Topic 2 data", "topic2");
    }
}

/*
Subscribing: Subscriber1 to topic: topic1
Subscribing: Subscriber2 to topic: topic2
Subscribing: Subscriber3 to topic: topic2

Publishing: Topic 1 data in topic: topic1
Subscriber Subscriber1 got :: Topic 1 data

Publishing: Topic 2 data in topic: topic2
Subscriber Subscriber2 got :: Topic 2 data
Subscriber Subscriber3 got :: Topic 2 data

Unsubscribing: Subscriber3 to topic: topic2
Publishing: Topic 2 data in topic: topic2
Subscriber Subscriber2 got :: Topic 2 data
*/
