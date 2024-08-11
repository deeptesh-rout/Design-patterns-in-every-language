# Mediator Interface
class Mediator
    def add_colleague(colleague)
        raise NotImplementedError, 'Subclasses must implement add_colleague'
    end

    def send_message(message, colleague_id)
        raise NotImplementedError, 'Subclasses must implement send_message'
    end
end

# Concrete Mediator
class ConcreteMediator < Mediator
    def initialize
        @colleagues = {}
    end

    def add_colleague(colleague)
        @colleagues[colleague.id] = colleague
    end

    def send_message(message, colleague_id)
        puts "Mediator pass Message: #{message}"
        @colleagues[colleague_id].receive(message)
    end
end

# Colleague Abstract Class
class Colleague
    attr_reader :id, :mediator

    def initialize(id, mediator)
        @id = id
        @mediator = mediator
    end

    def send(message, to)
        raise NotImplementedError, 'Subclasses must implement send'
    end

    def receive(message)
        raise NotImplementedError, 'Subclasses must implement receive'
    end
end

# Concrete Colleague
class ConcreteColleague < Colleague
    def send(message, to)
        puts "#{id} Sent Message: #{message}"
        mediator.send_message(message, to)
    end

    def receive(message)
        puts "#{id} Received Message #{message}"
    end
end

# Client Code
mediator = ConcreteMediator.new
first = ConcreteColleague.new('First', mediator)
mediator.add_colleague(first)

second = ConcreteColleague.new('Second', mediator)
mediator.add_colleague(second)

first.send('Hello, World!', 'Second')
second.send('Hi, World!', 'First')

=begin 
First Sent Message: Hello, World!
Mediator pass Message: Hello, World!
Second Received Message Hello, World!
Second Sent Message: Hi, World!
Mediator pass Message: Hi, World!
First Received Message Hi, World!
=end