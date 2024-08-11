using System;
using System.Collections.Generic;

class Publisher
{
    private Dictionary<string, List<Subscriber>> topicSubscribers = new Dictionary<string, List<Subscriber>>();

    public void Subscribe(Subscriber subscriber, string topic)
    {
        topicSubscribers.TryGetValue(topic, out var subscribers);
        if (subscribers == null)
        {
            subscribers = new List<Subscriber>();
            topicSubscribers[topic] = subscribers;
        }

        subscribers.Add(subscriber);
        Console.WriteLine($"Subscribing: {subscriber.GetId()} to topic: {topic}");
    }

    public void Unsubscribe(Subscriber subscriber, string topic)
    {
        if (topicSubscribers.TryGetValue(topic, out var subscribers))
        {
            subscribers.Remove(subscriber);
            Console.WriteLine($"Unsubscribing: {subscriber.GetId()} to topic: {topic}");
        }
    }

    public void NotifySubscribers(string data, string topic)
    {
        if (topicSubscribers.TryGetValue(topic, out var subscribers))
        {
            Console.WriteLine($"Publishing: {data} in topic: {topic}");
            foreach (var subscriber in subscribers)
            {
                subscriber.Update(data);
            }
        }
    }
}

class Subscriber
{
    private string id;

    public Subscriber(string id)
    {
        this.id = id;
    }

    public string GetId()
    {
        return id;
    }

    public void Update(string data)
    {
        Console.WriteLine($"Subscriber {id} got :: {data}");
    }
}

// Client code

class PubSub
{
    static void Main(string[] args)
    {
        Publisher pub = new Publisher();

        Subscriber sub1 = new Subscriber("Subscriber1");
        Subscriber sub2 = new Subscriber("Subscriber2");
        Subscriber sub3 = new Subscriber("Subscriber3");

        Console.WriteLine();
        pub.Subscribe(sub1, "topic1");
        pub.Subscribe(sub2, "topic2");
        pub.Subscribe(sub3, "topic2");

        Console.WriteLine();
        pub.NotifySubscribers("Topic 1 data", "topic1");

        Console.WriteLine();
        pub.NotifySubscribers("Topic 2 data", "topic2");

        Console.WriteLine();
        pub.Unsubscribe(sub3, "topic2");
        pub.NotifySubscribers("Topic 2 data", "topic2");
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
