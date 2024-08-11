# Shape interface
class Shape
    def draw(x1, y1, x2, y2)
        raise NotImplementedError, 'Subclasses must implement the draw method'
    end
end

# Rectangle class implementing Shape
class Rectangle < Shape
    attr_reader :colour

    def initialize(colour)
        @colour = colour
    end

    def draw(x1, y1, x2, y2)
        puts "Draw rectangle colour: #{@colour} topleft: (#{x1},#{y1}) rightBottom: (#{x2},#{y2})"
    end
end

# RectangleFactory class
class RectangleFactory
    def initialize
        @shapes = {}
    end

    def get_rectangle(colour)
        @shapes[colour] ||= Rectangle.new(colour)
    end

    def count
        @shapes.size
    end
end

# Client code
factory = RectangleFactory.new
random = Random.new

1000.times do
    rectangle = factory.get_rectangle(random.rand(1000).to_s)
end

puts factory.count

