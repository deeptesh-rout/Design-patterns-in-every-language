# Define State interface
module State
    def handle(context)
        raise NotImplementedError, 'Subclasses must implement the handle method'
    end
end

# Define Context class
class Context
    attr_accessor :current_state

    def initialize(state)
        @current_state = state
    end

    def change_state(state)
        @current_state = state
    end

    def request
        @current_state.handle(self)
    end
end

# Define Singleton module for managing instances
module Singleton
    def instance
        @instance ||= new
    end
end

# Define ConcreteState1 class implementing State with Singleton pattern
class ConcreteState1
    include State
    extend Singleton

    def handle(context)
        context.change_state(ConcreteState2.instance)
    end
end

# Define ConcreteState2 class implementing State with Singleton pattern
class ConcreteState2
    include State
    extend Singleton

    def handle(context)
        context.change_state(ConcreteState3.instance)
    end
end

# Define ConcreteState3 class implementing State with Singleton pattern
class ConcreteState3
    include State
    extend Singleton

    def handle(context)
        context.change_state(ConcreteState4.instance)
    end
end

# Define ConcreteState4 class implementing State with Singleton pattern
class ConcreteState4
    include State
    extend Singleton

    def handle(context)
        context.change_state(ConcreteState1.instance)
    end
end

# Client code
def test(state, count)
    context = Context.new(state)
    start = Time.now
    count.times { context.request }
    duration = Time.now - start
    puts duration
end

state1 = ConcreteState1.instance
test(state1, 10)

state2 = ConcreteState1.instance
test(state2, 10)

=begin 
1.1145e-05
2.181e-06
=end