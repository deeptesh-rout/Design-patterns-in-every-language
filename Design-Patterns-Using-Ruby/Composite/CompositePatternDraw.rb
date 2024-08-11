# Shape
class Shape
    def move(x, y)
        raise NotImplementedError, 'Subclasses must implement this method'
    end
  
    def draw
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Rectangle
class Rectangle < Shape
    
    attr_accessor :x, :y, :length, :breadth
    
    def initialize(x, y, length, breadth)
        @x = x
        @y = y
        @length = length
        @breadth = breadth
    end
    
    def move(x, y)
        @x += x
        @y += y
    end
    
    def draw
        puts "Draw a Rectangle at (#{@x}, #{@y})."
        '<Rectangle>'
    end
end

# Circle
class Circle < Shape
    
    attr_accessor :x, :y, :radius
    
    def initialize(x, y, radius)
        @x = x
        @y = y
        @radius = radius
    end
    
    def move(x, y)
        @x += x
        @y += y
    end
    
    def draw
        puts "Draw a Circle of radius #{@radius} at (#{@x}, #{@y})."
        '<Circle>'
    end
end

# CompoundShape
class CompoundShape < Shape
    
    def initialize
        @children = []
    end
    
    def add(child)
        @children << child
    end
    
    def remove(child)
        @children.delete(child)
    end
    
    def move(x, y)
        @children.each { |child| child.move(x, y) }
    end
    
    def draw
        st = 'Shapes('
        @children.each { |child| st += child.draw }
        st += ')'
        st
    end
end

# Client code
all = CompoundShape.new
all.add(Rectangle.new(1, 2, 1, 2))
all.add(Circle.new(5, 3, 10))

group = CompoundShape.new
group.add(Rectangle.new(5, 7, 1, 2))
group.add(Circle.new(2, 1, 2))

all.add(group)
puts all.draw

=begin 
Draw a Rectangle at (1, 2).
Draw a Circle of radius 10 at (5, 3).
Draw a Rectangle at (5, 7).
Draw a Circle of radius 2 at (2, 1).
Shapes(<Rectangle><Circle>Shapes(<Rectangle><Circle>))
=end