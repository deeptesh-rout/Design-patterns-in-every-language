class Shape
    def accept(visitor)
        raise NotImplementedError, 'Subclasses must implement the accept method'
    end
end

class Circle < Shape
    attr_reader :x, :y, :radius

    def initialize(x, y, radius)
        @x = x
        @y = y
        @radius = radius
    end

    def accept(visitor)
        visitor.visit_circle(self)
    end
end

class Rectangle < Shape
    attr_reader :x, :y, :width, :height

    def initialize(x, y, width, height)
        @x = x
        @y = y
        @width = width
        @height = height
    end

    def accept(visitor)
        visitor.visit_rectangle(self)
    end
end

class Visitor
    def visit_circle(circle)
        raise NotImplementedError, 'Subclasses must implement the visit_circle method'
    end

    def visit_rectangle(rectangle)
        raise NotImplementedError, 'Subclasses must implement the visit_rectangle method'
    end
end

class XMLVisitor < Visitor
    def visit_circle(circle)
        puts "<circle>\n  <x>#{circle.x}</x>\n  <y>#{circle.y}</y>\n  <radius>#{circle.radius}</radius>\n</circle>"
    end

    def visit_rectangle(rectangle)
        puts "<rectangle>\n  <x>#{rectangle.x}</x>\n  <y>#{rectangle.y}</y>\n  <width>#{rectangle.width}</width>\n  <height>#{rectangle.height}</height>\n</rectangle>"
    end
end

class TextVisitor < Visitor
    def visit_circle(circle)
        puts "Circle ( (x : #{circle.x}, y : #{circle.y}), radius : #{circle.radius}) "
    end

    def visit_rectangle(rectangle)
        puts "Rectangle ( (x : #{rectangle.x}, y : #{rectangle.y}), width : #{rectangle.width}, height : #{rectangle.height}) "
    end
end

class ObjectsStructure
    attr_accessor :shapes, :visitor

    def initialize
        @shapes = []
        @visitor = nil
    end

    def add_shape(shape)
        shapes << shape
    end

    def accept
        shapes.each { |shape| shape.accept(visitor) }
    end
end

# Client code
os = ObjectsStructure.new
os.add_shape(Rectangle.new(6, 7, 8, 9))
os.add_shape(Circle.new(6, 7, 8))

os.visitor = XMLVisitor.new
os.accept

os.visitor = TextVisitor.new
os.accept

=begin 
<rectangle>
  <x>6</x>
  <y>7</y>
  <width>8</width>
  <height>9</height>
</rectangle>
<circle>
  <x>6</x>
  <y>7</y>
  <radius>8</radius>
</circle>
Rectangle ( (x : 6, y : 7), width : 8, height : 9) 
Circle ( (x : 6, y : 7), radius : 8) 
=end