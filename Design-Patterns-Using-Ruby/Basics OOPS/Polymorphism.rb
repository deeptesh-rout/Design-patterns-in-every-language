class Adder
    def initialize
      @sum = 0
    end
  
    # Overloaded method for incrementing by a specific value
    def increment(a = 1)
      @sum += a
    end
  
    def get_value
      @sum
    end
end
  
# Client code
a = Adder.new
a.increment(10)
a.increment
puts a.get_value
  