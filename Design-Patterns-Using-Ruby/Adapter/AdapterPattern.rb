# Desired Interface
module DesiredInterface
    def operation
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Adapter class
class Adapter include DesiredInterface
    def initialize
        @adaptee = Adaptee.new
    end

    def operation
        @adaptee.some_operation
    end
end

# Adaptee class
class Adaptee
    def some_operation
        puts "Adaptee someOperation() function called."
    end
end

# Client Code
adapter = Adapter.new
adapter.operation

=begin 
Adaptee someOperation() function called.
=end
