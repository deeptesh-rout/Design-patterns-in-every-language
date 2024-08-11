# Desired Interface
module Shape
    def draw
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Circle class
class Circle include Shape
    def initialize(x, y, radius)
        @x = x
        @y = y
        @radius = radius
    end

    def draw
        puts 'Draw the Circle.'
    end
end

# Rectangle class (Adaptee)
class Rectangle
    def initialize(x, y, length, width)
        @x = x
        @y = y
        @length = length
        @width = width
    end

    def old_draw
        puts 'Drawing Rectangle.'
    end
end

# RectangleAdapter class
class RectangleAdapter include Shape
    def initialize(x, y, length, width)
        @adaptee = Rectangle.new(x, y, length, width)
    end

    def draw
        @adaptee.old_draw
    end
end
  
# Client Code
adapter = RectangleAdapter.new(1, 2, 3, 4)
adapter.draw

=begin 
Drawing Rectangle.
=end
