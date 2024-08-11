class Rectangle
    attr_accessor :height, :width

    def initialize(l, w)
        @height = l
        @width = w
    end

    def set_width(w)
        @width = w
    end
    
    def set_height(h)
        @height = h
    end

    def get_width
        @width
    end
    
    def get_height
        @height
    end
end

class Square < Rectangle
    def initialize(l)
        super(l, l)
    end

    def set_width(w)
        @width = w
        @height = w
    end

    def set_height(h)
        @height = h
        @width = h
    end
end

# Client code
def test_rect(rect)
    rect.set_height(10)
    rect.set_width(20)
    if 200 == rect.get_height * rect.get_width
        puts 'success'
    else
        puts 'failure'
    end
end


r = Rectangle.new(10, 20)
test_rect(r)

s = Square.new(10)
s.set_width(20)
test_rect(s)
