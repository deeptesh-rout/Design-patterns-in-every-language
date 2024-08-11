# Observer module
module Observer
    def update
        raise NotImplementedError, 'Subclasses must implement the update method'
    end
end

# Subject class
class Subject
    attr_reader :observers

    def initialize
        @observers = []
    end

    def attach(observer)
        observer.subject = self
        @observers << observer
    end

    def detach(observer)
        observer.subject = nil
        @observers.delete(observer)
    end

    def notify_observers
        @observers.each(&:update)
    end
end

# ConcreteSubject class
class ConcreteSubject < Subject
    attr_accessor :state

    def state=(state)
        @state = state
        notify_observers
    end
end

# ConcreteObserver1 class
class ConcreteObserver1
    include Observer

    attr_accessor :subject

    def initialize(subject)
        @subject = subject
        subject.attach(self)
    end

    def update
        puts "#{subject.is_a?(ConcreteSubject) ? subject.state + ' notified to Observer1' : ''}"
    end
end

# ConcreteObserver2 class
class ConcreteObserver2
    include Observer

    attr_accessor :subject

    def initialize(subject)
        @subject = subject
        subject.attach(self)
    end

    def update
        puts "#{subject.is_a?(ConcreteSubject) ? subject.state + ' notified to Observer2' : ''}"
    end
end

# Client code
subject = ConcreteSubject.new
observer1 = ConcreteObserver1.new(subject)
observer2 = ConcreteObserver2.new(subject)

subject.state = 'First state'
subject.state = 'Second state'

=begin 
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
=end