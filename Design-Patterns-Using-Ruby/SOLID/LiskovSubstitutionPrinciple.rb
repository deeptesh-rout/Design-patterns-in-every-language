class Animal
    attr_reader :name
  
    def initialize(name)
        @name = name
    end
  
    def make_sound
        puts "Animal sound"
    end
end
  
class Dog < Animal
    def initialize(name)
        super(name)
    end
  
    def make_sound
        puts "woof woof!"
    end
end
  
class Cat < Animal
    def initialize(name)
        super(name)
    end
  
    def make_sound
        puts "meow meow!"
    end
end


class Rectangle
    attr_accessor :height, :width

    def initialize(l, w)
        @height = l
        @width = w
    end
end

class Square < Rectangle
    def initialize(l)
        super(l, l)
    end

    def width=(w)
        @height = w
        @width = w
    end

    def height=(h)
        @height = h
        @width = h
    end
end

def test_rectangle(rect)
    rect.height = 10
    rect.width = 20
    if 200 == rect.height * rect.width
        puts 'success'
    else
        puts 'failure'
    end
end

# Client code
rectangle = Rectangle.new(10, 20)
test_rectangle(rectangle)

square = Square.new(10)
square.width = 20
test_rectangle(square)


=begin 
success
failure
=end