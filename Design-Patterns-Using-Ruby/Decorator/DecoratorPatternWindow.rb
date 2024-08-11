# Window (Component)
class Window
    def draw
    end
end

# SimpleWindow (ConcreteComponent)
class SimpleWindow < Window
    def draw
        puts 'SimpleWindow draw.'
    end
end

# Decorator (Decorator)
class Decorator < Window
    attr_reader :component

    def initialize(component)
        @component = component
    end

    def draw
        component.draw
    end
end

# VerticalScrollBarDecorator (ConcreteDecorator)
class VerticalScrollBarDecorator < Decorator
    def initialize(component)
        super(component)
    end

    def draw
        super
        puts 'VerticalScrollBarDecorator draw'
    end
end

# HorizontalScrollBarDecorator (ConcreteDecorator)
class HorizontalScrollBarDecorator < Decorator
    def initialize(component)
        super(component)
    end

    def draw
        super
        puts 'HorizontalScrollBarDecorator draw'
    end
end

# Client code
component = SimpleWindow.new
decorator1 = VerticalScrollBarDecorator.new(component)
decorator2 = HorizontalScrollBarDecorator.new(decorator1)
decorator2.draw

=begin 
SimpleWindow draw.
VerticalScrollBarDecorator draw
HorizontalScrollBarDecorator draw 
=end