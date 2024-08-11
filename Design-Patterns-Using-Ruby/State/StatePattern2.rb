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

# Define ConcreteState1 class implementing State
class ConcreteState1
    include State

    def handle(context)
        puts 'ConcreteState1 handle'
        context.change_state(ConcreteState2.new)
    end
end

# Define ConcreteState2 class implementing State
class ConcreteState2
    include State

    def handle(context)
        puts 'ConcreteState2 handle'
        context.change_state(ConcreteState1.new)
    end
end

# Client code
state1 = ConcreteState1.new
context = Context.new(state1)
context.request
context.request

=begin 
ConcreteState1 handle
ConcreteState2 handle
=end