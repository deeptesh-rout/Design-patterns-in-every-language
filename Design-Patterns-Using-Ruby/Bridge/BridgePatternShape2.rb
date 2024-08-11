# Abstraction
class Shape
    attr_accessor :implementation
  
    def initialize(implementation)
        @implementation = implementation
    end
  
    def draw
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Concrete Abstraction
class Square < Shape
    def draw
        implementation.draw_square
    end
end

class Circle < Shape
    def draw
        implementation.draw_circle
    end
end

# Implementation
class DrawingAPI
    def draw_square
        raise NotImplementedError, 'Subclasses must implement this method'
    end
  
    def draw_circle
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Concrete Implementation
class WindowsAPI < DrawingAPI
    def draw_square
        puts 'Drawing a square on Windows.'
    end
  
    def draw_circle
        puts 'Drawing a circle on Windows.'
    end
end

class MacAPI < DrawingAPI
    def draw_square
        puts 'Drawing a square on Mac.'
    end
  
    def draw_circle
        puts 'Drawing a circle on Mac.'
    end
end

# Client code
windows_api = WindowsAPI.new
mac_api = MacAPI.new

square = Square.new(windows_api)
square.draw  # Output: Drawing a square on Windows.

circle = Circle.new(mac_api)
circle.draw  # Output: Drawing a circle on Mac.

=begin 
Drawing a square on Windows.
Drawing a circle on Mac.
=end
