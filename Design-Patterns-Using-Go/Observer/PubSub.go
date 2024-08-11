package main

import (
	"fmt"
)

// Publisher interface
type Publisher interface {
	Subscribe(subs Subscriber, topic string)
	Unsubscribe(subs Subscriber, topic string)
	Notify(data string, topic string)
}

// ConcretePublisher struct
type ConcretePublisher struct {
	topicSubscribers map[string][]Subscriber
}

func (p *ConcretePublisher) Subscribe(subs Subscriber, topic string) {
	if p.topicSubscribers == nil {
		p.topicSubscribers = make(map[string][]Subscriber)
	}

	p.topicSubscribers[topic] = append(p.topicSubscribers[topic], subs)
	fmt.Printf("Subscribing: %s to topic: %s\n", subs.GetID(), topic)
}

func (p *ConcretePublisher) Unsubscribe(subs Subscriber, topic string) {
	if subscribers, ok := p.topicSubscribers[topic]; ok {
		for i, s := range subscribers {
			if s == subs {
				p.topicSubscribers[topic] = append(subscribers[:i], subscribers[i+1:]...)
				break
			}
		}
	}

	fmt.Printf("Unsubscribing: %s to topic: %s\n", subs.GetID(), topic)
}

func (p *ConcretePublisher) Notify(data string, topic string) {
	if subscribers, ok := p.topicSubscribers[topic]; ok {
		fmt.Printf("Publishing: %s in topic: %s\n", data, topic)
		for _, subscriber := range subscribers {
			subscriber.Update(data)
		}
	}
}

// Subscriber interface
type Subscriber interface {
	Update(data string)
	GetID() string
}

// ConcreteSubscriber struct
type ConcreteSubscriber struct {
	id string
}

func (s *ConcreteSubscriber) Update(data string) {
	fmt.Printf("Subscriber %s got :: %s\n", s.id, data)
}

func (s *ConcreteSubscriber) GetID() string {
	return s.id
}

// Client code
func main() {
	pub := &ConcretePublisher{}

	sub1 := &ConcreteSubscriber{id: "Subscriber1"}
	sub2 := &ConcreteSubscriber{id: "Subscriber2"}
	sub3 := &ConcreteSubscriber{id: "Subscriber3"}

	fmt.Println()
	pub.Subscribe(sub1, "topic1")
	pub.Subscribe(sub2, "topic2")
	pub.Subscribe(sub3, "topic2")

	fmt.Println()
	pub.Notify("Topic 1 data", "topic1")

	fmt.Println()
	pub.Notify("Topic 2 data", "topic2")

	fmt.Println()
	pub.Unsubscribe(sub3, "topic2")
	pub.Notify("Topic 2 data", "topic2")
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