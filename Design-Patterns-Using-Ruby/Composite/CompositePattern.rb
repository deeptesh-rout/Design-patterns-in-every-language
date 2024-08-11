# Component
class Component
    def operation
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Composite
class Composite < Component
    def initialize
        @children = []
    end
  
    def operation
        puts 'Composite Operation'
        @children.each(&:operation)
    end
  
    def add(component)
        @children << component
    end
  
    def remove(component)
        @children.delete(component)
    end
end

# Leaf
class Leaf < Component
    def operation
        puts 'Leaf Operation'
    end
end

# Client code
composite = Composite.new
composite.add(Leaf.new)

composite2 = Composite.new
composite2.add(Leaf.new)

composite.add(composite2)
composite.operation

=begin 
Composite Operation
Leaf Operation
Composite Operation
Leaf Operation
=end