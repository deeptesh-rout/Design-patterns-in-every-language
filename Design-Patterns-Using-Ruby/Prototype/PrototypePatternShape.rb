class Shape
    attr_accessor :color

    def initialize
        @color = ''
    end

    def to_s
        raise NotImplementedError, "Subclasses must implement the 'to_s' method"
    end

    def clone_shape
        clone
    end
end

class Rectangle < Shape
    def to_s
        'Rectangle.'
    end
end

class Circle < Shape
    def to_s
        'Circle.'
    end
end

class ShapeRegistry
    @@shapes = {}

    def self.add_shape(key, value)
        @@shapes[key] = value
    end

    def self.get_shape(key)
        return @@shapes[key].clone_shape if @@shapes.key?(key)

        nil
    end

    def self.load
        add_shape('circle', Circle.new)
        add_shape('rectangle', Rectangle.new)
    end
end

# Client code
ShapeRegistry.load
c = ShapeRegistry.get_shape('circle')
r = ShapeRegistry.get_shape('rectangle')
puts c
puts r

=begin 
Circle.
Rectangle. 
=end