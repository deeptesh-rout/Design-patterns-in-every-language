# Abstraction interface
class Shape
    def initialize(imp)
        @imp = imp
    end
    
    def draw
        puts "Drawing #{self.class} with color #{@imp.fill}"
    end
end

# Implementor interface
class Color
    def fill
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Rectangle class
class Rectangle < Shape
end

# Circle class
class Circle < Shape
end

# Red class
class Red < Color
    def fill
        'Red'
    end
end

# Green class
class Green < Color
    def fill
        'Green'
    end
end

# Blue class
class Blue < Color
    def fill
        'Blue'
    end
end

# Client code
c1 = Red.new
abstraction = Circle.new(c1)
abstraction.draw

c2 = Green.new
abstraction2 = Rectangle.new(c2)
abstraction2.draw

=begin 
Drawing Circle with color Red
Drawing Rectangle with color Green 
=end