# Invoker
class Invoker
    def initialize
        @commands = []
    end
  
    def set_command(command)
        @commands << command
    end
  
    def execute_commands
        @commands.each(&:execute)
    end
  
    def unexecute_commands
        @commands.each(&:unexecute)
    end
end

# Command
class Command
    def execute
        raise NotImplementedError, 'Subclasses must implement this method'
    end
  
    def unexecute
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# ConcreteCommand
class ConcreteCommand < Command
    def initialize(receiver)
        @receiver = receiver
    end
  
    def execute
        @receiver.action('Action 1')
    end
  
    def unexecute
        @receiver.action('Action 2')
    end
end

# Receiver
class Receiver
    def action(action)
        puts action
    end
end

# Client Code
receiver = Receiver.new
concrete_command = ConcreteCommand.new(receiver)
invoker = Invoker.new

invoker.set_command(concrete_command)
invoker.execute_commands
invoker.unexecute_commands

=begin 
Action 1
Action 2
=end