# Mediator interface
class Mediator
    def add_colleague(colleague)
        raise NotImplementedError, 'Subclasses must override this method'
    end
  
    def send_message(message, colleague_id)
        raise NotImplementedError, 'Subclasses must override this method'
    end
end

# ConcreteMediator class
class ConcreteMediator < Mediator
    def initialize
        @colleagues = {}
    end

    def add_colleague(colleague)
        @colleagues[colleague.id] = colleague
    end

    def send_message(message, colleague_id)
        puts "Mediator pass Message : #{message}"
        @colleagues[colleague_id].receive(message)
    end
end

# Colleague abstract class
class Colleague
    attr_reader :id

    def initialize(mediator, id)
        @mediator = mediator
        @id = id
    end

    def send(message, to)
        puts "#{id} Sent Message : #{message}"
        @mediator.send_message(message, to)
    end

    def receive(message)
        puts "#{id} Received Message #{message}"
    end
end

# ConcreteColleague1 class
class ConcreteColleague1 < Colleague
    def initialize(mediator)
        super(mediator, 'First')
    end
end

# ConcreteColleague2 class
class ConcreteColleague2 < Colleague
    def initialize(mediator)
        super(mediator, 'Second')
    end
end
  
# Client code
mediator = ConcreteMediator.new
first = ConcreteColleague1.new(mediator)
mediator.add_colleague(first)
second = ConcreteColleague2.new(mediator)
mediator.add_colleague(second)
first.send('Hello, World!', 'Second')
=begin 
First Sent Message : Hello, World!
Mediator pass Message : Hello, World!
Second Received Message Hello, World!
=end