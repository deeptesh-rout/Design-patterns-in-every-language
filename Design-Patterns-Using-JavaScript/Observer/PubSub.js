class Publisher {
    constructor() {
        this.topicSubscribers = new Map();
    }

    subscribe(subscriber, topic) {
        this.topicSubscribers.set(topic, (this.topicSubscribers.get(topic) || []).concat(subscriber));
        console.log(`Subscribing: ${subscriber.getId()} to topic: ${topic}`);
    }

    unsubscribe(subscriber, topic) {
        const subscribers = this.topicSubscribers.get(topic) || [];
        this.topicSubscribers.set(topic, subscribers.filter(sub => sub !== subscriber));
        console.log(`Unsubscribing: ${subscriber.getId()} to topic: ${topic}`);
    }

    notifySubscribers(data, topic) {
        if (this.topicSubscribers.has(topic)) {
            console.log(`Publishing: ${data} in topic: ${topic}`);
            for (const subscriber of this.topicSubscribers.get(topic)) {
                subscriber.update(data);
            }
        }
    }
}

class Subscriber {
    constructor(id) {
        this.id = id;
    }

    getId() {
        return this.id;
    }

    update(data) {
        console.log(`Subscriber ${this.id} got :: ${data}`);
    }
}

// Client code
const pub = new Publisher();

const sub1 = new Subscriber("Subscriber1");
const sub2 = new Subscriber("Subscriber2");
const sub3 = new Subscriber("Subscriber3");

console.log();
pub.subscribe(sub1, "topic1");
pub.subscribe(sub2, "topic2");
pub.subscribe(sub3, "topic2");

console.log();
pub.notifySubscribers("Topic 1 data", "topic1");

console.log();
pub.notifySubscribers("Topic 2 data", "topic2");

console.log();
pub.unsubscribe(sub3, "topic2");
pub.notifySubscribers("Topic 2 data", "topic2");

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