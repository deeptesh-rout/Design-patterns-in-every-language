# Component
class Component
    def operation
    end
end

# ConcreteComponent
class ConcreteComponent < Component
    def operation
        puts 'ConcreteComponent operation.'
    end
end

# Decorator
class Decorator < Component
    def initialize(component)
        @component = component
    end
  
    def operation
        @component.operation
    end
end

# ConcreteDecorator1
class ConcreteDecorator1 < Decorator
    def operation
        puts 'ConcreteDecorator1 operation start.'
        super
        puts 'ConcreteDecorator1 operation end.'
    end
end

# ConcreteDecorator2
class ConcreteDecorator2 < Decorator
    def operation
        puts 'ConcreteDecorator2 operation start.'
        super
        puts 'ConcreteDecorator2 operation end.'
    end
end

# Client code
component = ConcreteComponent.new
decorator1 = ConcreteDecorator1.new(component)
decorator2 = ConcreteDecorator2.new(decorator1)
decorator2.operation

=begin 
ConcreteDecorator2 operation start.
ConcreteDecorator1 operation start.
ConcreteComponent operation.
ConcreteDecorator1 operation end.
ConcreteDecorator2 operation end. 
=end