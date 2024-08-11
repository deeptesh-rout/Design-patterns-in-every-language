# Abstract ProductA
module ProductA
    def operation_a
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Concrete ProductA1
class ProductA1 include ProductA
    def operation_a
        puts 'ProductA1 operationA'
    end
end

# Concrete ProductA2
class ProductA2 include ProductA
    def operation_a
        puts 'ProductA2 operationA'
    end
end

# Abstract ProductB
module ProductB
    def operation_b
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Concrete ProductB1
class ProductB1 include ProductB
    def operation_b
        puts 'ProductB1 operationB'
    end
end

# Concrete ProductB2
class ProductB2 include ProductB
    def operation_b
        puts 'ProductB2 operationB'
    end
end

# Abstract Factory
module AbstractFactory
    def create_product_a
        raise NotImplementedError, 'Subclasses must implement this method'
    end

    def create_product_b
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Concrete Factory1
class ConcreteFactory1 include AbstractFactory
    def create_product_a
        ProductA1.new
    end

    def create_product_b
        ProductB1.new
    end
end

# Concrete Factory2
class ConcreteFactory2 include AbstractFactory
    def create_product_a
        ProductA2.new
    end

    def create_product_b
        ProductB2.new
    end
end

# Client code
factory1 = ConcreteFactory1.new
productA1 = factory1.create_product_a
productB1 = factory1.create_product_b
productA1.operation_a
productB1.operation_b

factory2 = ConcreteFactory2.new
productA2 = factory2.create_product_a
productB2 = factory2.create_product_b
productA2.operation_a
productB2.operation_b

=begin 
ProductA1 operationA
ProductB1 operationB
ProductA2 operationA
ProductB2 operationB
=end