# Shape interface
class Shape
    def draw(x1, y1, x2, y2)
        raise NotImplementedError, 'Subclasses must implement the draw method'
    end
end

# Rectangle class implementing Shape with Intrinsic State
class RectangleIntrinsic < Shape
    attr_reader :color

    def initialize(color)
        @color = color
    end

    def draw(x1, y1, x2, y2)
        puts "Draw rectangle color: #{@color} topleft: (#{x1},#{y1}) rightBottom: (#{x2},#{y2})"
    end
end

# RectangleFactory class for managing Flyweight objects
class RectangleFactory
    def initialize
        @shapes = {}
    end

    def get_rectangle(color)
        @shapes[color] ||= RectangleIntrinsic.new(color)
    end
end

# Rectangle class without Flyweight
class RectangleWithoutFlyweight
    attr_reader :color

    def initialize(color)
        @color = color
    end

    def draw(x1, y1, x2, y2)
        puts "Draw rectangle color: #{@color} topleft: (#{x1},#{y1}) rightBottom: (#{x2},#{y2})"
    end
end

# Client code
factory = RectangleFactory.new
random = Random.new

start_time = Time.now.to_f * 1000

100.times do
    rectangle = factory.get_rectangle(random.rand(10).to_s)
end

end_time = Time.now.to_f * 1000

puts "Flyweight Time: #{end_time - start_time} ms"

start_time = Time.now.to_f * 1000

10000.times do
    rectangle = RectangleWithoutFlyweight.new(random.rand(10).to_s)
end

end_time = Time.now.to_f * 1000

puts "Without Flyweight Time: #{end_time - start_time} ms"

=begin 
Flyweight Time: 0.036865234375 ms
Without Flyweight Time: 4.562744140625 ms 
=end