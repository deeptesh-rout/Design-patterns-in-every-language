# Define Strategy interface
module Strategy
    def execute(data)
        raise NotImplementedError, 'Subclasses must implement the execute method'
    end
end

# Define ConcreteStrategy1 class implementing Strategy
class ConcreteStrategy1
    include Strategy

    def execute(data)
        puts 'ConcreteStrategy1 execute'
    end
end

# Define ConcreteStrategy2 class implementing Strategy
class ConcreteStrategy2
    include Strategy

    def execute(data)
        puts 'ConcreteStrategy2 execute'
    end
end

# Define Context class
class Context
    attr_accessor :strategy

    def initialize(strategy)
        @strategy = strategy
    end

    def set_strategy(strategy)
        @strategy = strategy
    end

    def execute
        data = 1
        @strategy.execute(data)
    end
end

# Client code
context = Context.new(ConcreteStrategy1.new)
context.execute

context.set_strategy(ConcreteStrategy2.new)
context.execute

=begin 
ConcreteStrategy1 execute
ConcreteStrategy2 execute
=end
