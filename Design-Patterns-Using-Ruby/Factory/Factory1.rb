# Product interface
class Product
    def operation
        raise NotImplementedError, 'Subclasses must implement the operation method'
    end
end

# Concrete Product classes
class ConcreteProduct1 < Product
    def operation
        puts 'Concrete Product1 Operation!'
    end
end

class ConcreteProduct2 < Product
    def operation
        puts 'Concrete Product2 Operation!'
    end
end

# Creator abstract class
class Factory
    def create_product
        raise NotImplementedError, 'Subclasses must implement the create_product method'
    end
end

# Concrete Creator classes
class ConcreteFactory1 < Factory
    def create_product
        ConcreteProduct1.new
    end
end

class ConcreteFactory2 < Factory
    def create_product
        ConcreteProduct2.new
    end
end

# Client code
factory1 = ConcreteFactory1.new
product1 = factory1.create_product
product1.operation

factory2 = ConcreteFactory2.new
product2 = factory2.create_product
product2.operation
  

=begin 
Concrete Product1 Operation!
Concrete Product2 Operation!
=end