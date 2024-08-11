class Rectangle
    attr_reader :length, :breadth
  
    def initialize(length, breadth)
      @length = length
      @breadth = breadth
    end
  
    def area
      length * breadth
    end
  
    def perimeter
      2 * (length + breadth)
    end
  
    # Overloading + operator
    def add(rec)
      Rectangle.new(self.length + rec.length, self.breadth + rec.breadth)
    end
  
    # Overloading - operator
    def subtract(rec)
      Rectangle.new((self.length - rec.length).abs, (self.breadth - rec.breadth).abs)
    end
  
    # Overloading == operator
    def ==(rec)
      self.length == rec.length && self.breadth == rec.breadth
    end
  
    # Overriding to_s method
    def to_s
      "Rectangle length and width: #{length} #{breadth}"
    end
end
  
# Client code
r1 = Rectangle.new(4, 6)
r2 = Rectangle.new(10, 6)

puts "Is r1 == r2 ? #{r1 == r2}"

r3 = r1.add(r2)
r4 = r1.subtract(r2)

puts r1
puts r2
puts r3
puts r4
  