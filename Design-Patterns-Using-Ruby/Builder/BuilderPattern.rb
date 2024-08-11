# Define the Product class with two parts
class Product
    attr_accessor :partA, :partB
  
    def initialize(a, b)
        @partA = a
        @partB = b
    end
  
    def to_s
        "Product: (#{@partA}, #{@partB})"
    end
end

# Define an abstract class called Builder
class Builder
    attr_accessor :product
  
    def initialize
        @product = Product.new('A default', 'B default')
    end
  
    def set_part_a(a)
        @product.partA = a
        self
    end
  
    def set_part_b(b)
        @product.partB = b
        self
    end
  
    def get_product
        temp = @product
        @product = Product.new('A default', 'B default')
        temp
    end
end

# Define a ConcreteBuilder class that extends Builder
class ConcreteBuilder < Builder
end

# Define a Director class that takes a builder object as a parameter
class Director
    attr_accessor :builder
  
    def initialize(builder)
        @builder = builder
    end
  
    def construct
        @builder.set_part_a('A1').set_part_b('B1').get_product
    end
  
    def construct2
        @builder.set_part_a('A2').set_part_b('B2').get_product
    end
  
    def construct3
        @builder.set_part_a('A3').get_product
    end
end

# Client code
builder = ConcreteBuilder.new
director = Director.new(builder)

product = director.construct
puts product

product2 = director.construct2
puts product2

product3 = director.construct3
puts product3

=begin 
Product: (A1, B1)
Product: (A2, B2)
Product: (A3, B default)
=end