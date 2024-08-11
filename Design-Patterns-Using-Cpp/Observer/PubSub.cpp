#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

class Subscriber {
private:
    std::string id;

public:
    Subscriber(const std::string& id) : id(id) {}

    std::string getId() const {
        return id;
    }

    void update(const std::string& data) const {
        std::cout << "Subscriber: " << id << " got : " << data << std::endl;
    }

    // Operator overloading for equality
    bool operator==(const Subscriber& other) const {
        return id == other.id;
    }
};

class Publisher {
private:
    std::unordered_map<std::string, std::vector<Subscriber>> topicSubscribers;

public:
    void subscribe(const Subscriber& subscriber, const std::string& topic) {
        topicSubscribers[topic].emplace_back(subscriber);
        std::cout << "Subscribing: " << subscriber.getId() << " to topic: " << topic << std::endl;
    }

    void unsubscribe(const Subscriber& subscriber, const std::string& topic) {
        auto& subscribers = topicSubscribers[topic];
        auto it = std::find(subscribers.begin(), subscribers.end(), subscriber);

        if (it != subscribers.end()) {
            subscribers.erase(it);
            std::cout << "Unsubscribing: " << subscriber.getId() << " from topic: " << topic << std::endl;
        } else {
            std::cout << "Subscriber " << subscriber.getId() << " is not subscribed to topic: " << topic << std::endl;
        }
    }

    void notifySubscribers(const std::string& data, const std::string& topic) {
        if (topicSubscribers.find(topic) != topicSubscribers.end()) {
            std::cout << "Publishing: " << data << " in topic: " << topic << std::endl;
            for (const auto& subscriber : topicSubscribers[topic]) {
                subscriber.update(data);
            }
        }
    }
};

// Client code
int main() {
    Publisher pub;
    Subscriber sub1("Subscriber1");
    Subscriber sub2("Subscriber2");
    Subscriber sub3("Subscriber3");

    std::cout << std::endl;
    pub.subscribe(sub1, "topic1");
    pub.subscribe(sub2, "topic2");
    pub.subscribe(sub3, "topic2");

    std::cout << std::endl;
    pub.notifySubscribers("Topic 1 data", "topic1");

    std::cout << std::endl;
    pub.notifySubscribers("Topic 2 data", "topic2");

    std::cout << std::endl;
    pub.unsubscribe(sub3, "topic2");
    pub.notifySubscribers("Topic 2 data", "topic2");

    // Try to unsubscribe a subscriber not in the list
    Subscriber sub4("Subscriber4");
    pub.unsubscribe(sub4, "topic2");

    return 0;
}

/*
Subscribing: Subscriber1 to topic: topic1
Subscribing: Subscriber2 to topic: topic2
Subscribing: Subscriber3 to topic: topic2

Publishing: Topic 1 data in topic: topic1
Subscriber: Subscriber1 got : Topic 1 data

Publishing: Topic 2 data in topic: topic2
Subscriber: Subscriber2 got : Topic 2 data
Subscriber: Subscriber3 got : Topic 2 data

Unsubscribing: Subscriber3 from topic: topic2
Publishing: Topic 2 data in topic: topic2
Subscriber: Subscriber2 got : Topic 2 data
Subscriber Subscriber4 is not subscribed to topic: topic2
*/