class Publisher {
    private val topicSubscribers: MutableMap<String, MutableList<Subscriber>> = HashMap()

    fun subscribe(subscriber: Subscriber, topic: String) {
        topicSubscribers.computeIfAbsent(topic) { _: String? -> ArrayList() }.add(subscriber)
        println("Subscribing: " + subscriber.id + " to topic: " + topic)
    }

    fun unsubscribe(subscriber: Subscriber, topic: String) {
        topicSubscribers.getOrDefault(topic, ArrayList()).remove(subscriber)
        println("Unsubscribing: " + subscriber.id + " to topic: " + topic)
    }

    fun notifySubscribers(data: String, topic: String) {
        if (topicSubscribers.containsKey(topic)) {
            println("Publishing: $data in topic: $topic")
            for (subscriber in topicSubscribers[topic]!!) {
                subscriber.update(data)
            }
        }
    }
}

class Subscriber(val id: String) {
    fun update(data: String) {
        println("Subscriber $id got :: $data")
    }
}

// Client Code
fun main() {
    val pub = Publisher()

    val sub1 = Subscriber("Subscriber1")
    val sub2 = Subscriber("Subscriber2")
    val sub3 = Subscriber("Subscriber3")

    println()
    pub.subscribe(sub1, "topic1")
    pub.subscribe(sub2, "topic2")
    pub.subscribe(sub3, "topic2")

    println()
    pub.notifySubscribers("Topic 1 data", "topic1")

    println()
    pub.notifySubscribers("Topic 2 data", "topic2")

    println()
    pub.unsubscribe(sub3, "topic2")
    pub.notifySubscribers("Topic 2 data", "topic2")
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

