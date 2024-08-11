import Foundation

class Publisher {
    private var topicSubscribers = [String: [Subscriber]]()

    func subscribe(subscriber: Subscriber, topic: String) {
        topicSubscribers[topic, default: []].append(subscriber)
        print("Subscribing: \(subscriber.getId()) to topic: \(topic)")
    }

    func unsubscribe(subscriber: Subscriber, topic: String) {
        topicSubscribers[topic]?.removeAll { $0 === subscriber }
        print("Unsubscribing: \(subscriber.getId()) to topic: \(topic)")
    }

    func notifySubscribers(data: String, topic: String) {
        if let subscribers = topicSubscribers[topic] {
            print("Publishing: \(data) in topic: \(topic)")
            for subscriber in subscribers {
                subscriber.update(data: data)
            }
        }
    }
}

class Subscriber {
    private var id: String

    init(id: String) {
        self.id = id
    }

    func getId() -> String {
        return id
    }

    func update(data: String) {
        print("Subscriber \(id) got :: \(data)")
    }
}

// Client Code
let pub = Publisher()

let sub1 = Subscriber(id: "Subscriber1")
let sub2 = Subscriber(id: "Subscriber2")
let sub3 = Subscriber(id: "Subscriber3")

print()
pub.subscribe(subscriber: sub1, topic: "topic1")
pub.subscribe(subscriber: sub2, topic: "topic2")
pub.subscribe(subscriber: sub3, topic: "topic2")

print()
pub.notifySubscribers(data: "Topic 1 data", topic: "topic1")

print()
pub.notifySubscribers(data: "Topic 2 data", topic: "topic2")

print()
pub.unsubscribe(subscriber: sub3, topic: "topic2")
pub.notifySubscribers(data: "Topic 2 data", topic: "topic2")


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
