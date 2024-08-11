class Publisher
    attr_reader :topic_subscribers

    def initialize
        @topic_subscribers = Hash.new { |hash, key| hash[key] = [] }
    end

    def subscribe(subscriber, topic)
        @topic_subscribers[topic] << subscriber
        puts "Subscribing: #{subscriber.id} to topic: #{topic}"
    end

    def unsubscribe(subscriber, topic)
        @topic_subscribers[topic].delete(subscriber)
        puts "Unsubscribing: #{subscriber.id} to topic: #{topic}"
    end

    def notify_subscribers(data, topic)
        if @topic_subscribers.key?(topic)
            puts "Publishing: #{data} in topic: #{topic}"
            @topic_subscribers[topic].each { |subscriber| subscriber.update(data) }
        end
    end
end

class Subscriber
    attr_reader :id

    def initialize(id)
        @id = id
    end

    def update(data)
        puts "Subscriber #{id} got :: #{data}"
    end
end

# Client code
pub = Publisher.new

sub1 = Subscriber.new("Subscriber1")
sub2 = Subscriber.new("Subscriber2")
sub3 = Subscriber.new("Subscriber3")

puts
pub.subscribe(sub1, "topic1")
pub.subscribe(sub2, "topic2")
pub.subscribe(sub3, "topic2")

puts
pub.notify_subscribers("Topic 1 data", "topic1")

puts
pub.notify_subscribers("Topic 2 data", "topic2")

puts
pub.unsubscribe(sub3, "topic2")
pub.notify_subscribers("Topic 2 data", "topic2")

=begin 
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
=end