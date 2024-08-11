# ICoffee (Component)
class ICoffee
    def get_cost
    end
    
    def get_ingredients
    end
end

# SimpleCoffee (ConcreteComponent)
class SimpleCoffee < ICoffee
    def get_cost
            10
      end
    
      def get_ingredients
            'Coffee'
      end
end

# CoffeeDecorator (Decorator)
class CoffeeDecorator < ICoffee
    attr_reader :component, :name, :cost
  
    def initialize(component, name, cost)
        @component = component
        @name = name
        @cost = cost
    end
  
    def get_cost
        component.get_cost + cost
    end
  
    def get_ingredients
        "#{component.get_ingredients}, #{name}"
    end
end

# MilkDecorator (ConcreteDecorator)
class MilkDecorator < CoffeeDecorator
    def initialize(component)
        super(component, 'Milk', 4)
    end
end

# EspressoDecorator (ConcreteDecorator)
class EspressoDecorator < CoffeeDecorator
    def initialize(component)
        super(component, 'Espresso', 5)
    end
end

# Client code
component = SimpleCoffee.new
decorator1 = MilkDecorator.new(component)
decorator2 = EspressoDecorator.new(decorator1)

puts "Coffee cost is :: #{decorator2.get_cost}"
puts "Coffee ingredients are :: #{decorator2.get_ingredients}"

latte = MilkDecorator.new(MilkDecorator.new(SimpleCoffee.new))
puts "Coffee cost is :: #{latte.get_cost}"
puts "Coffee ingredients are :: #{latte.get_ingredients}"

=begin 
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
=end