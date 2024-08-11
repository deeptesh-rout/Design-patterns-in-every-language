# Product class
class Product
    attr_accessor :partA, :partB
  
    def initialize(a, b)
        @partA = a
        @partB = b
    end
  
    def to_s
        "Product : (#{@partA}, #{@partB})"
    end
end

# Builder abstract class
class Builder
    def set_part_a(_a)
        raise NotImplementedError, 'Subclasses must implement this method'
    end
  
    def set_part_b(_b)
        raise NotImplementedError, 'Subclasses must implement this method'
    end
  
    def get_product
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# ConcreteBuilder class that extends Builder
class ConcreteBuilder < Builder
    attr_accessor :part_a, :part_b
  
    def initialize
        @part_a = 'A default'
        @part_b = 'B default'
    end
  
    def set_part_a(a)
        @part_a = a
        self
    end
  
    def set_part_b(b)
        @part_b = b
        self
    end
  
    def get_product
        Product.new(@part_a, @part_b)
    end
end

# Director class
class Director
    attr_accessor :builder
  
    def initialize(builder)
        @builder = builder
    end
  
    def construct
        @builder.set_part_a('A1').set_part_b('B1').get_product
    end
  
    def construct2
        @builder.set_part_a('A2')
        @builder.set_part_b('B2')
        @builder.get_product
    end
end

# Client code
builder = ConcreteBuilder.new
director = Director.new(builder)

product = director.construct
puts product

product2 = director.construct2
puts product2

=begin 
Product : (A1, B1)
Product : (A2, B2)
=end