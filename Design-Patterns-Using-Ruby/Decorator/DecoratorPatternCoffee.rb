 
# Coffee (Component)
class Coffee
    def get_cost
    end
    
    def get_ingredients
    end
end

# SimpleCoffee (ConcreteComponent)
class SimpleCoffee < Coffee
    def get_cost
        10
    end

    def get_ingredients
        'Coffee'
    end
end

# CoffeeDecorator (Decorator)
class CoffeeDecorator < Coffee
    def initialize(component)
        @component = component
    end

    def get_cost
        @component.get_cost
    end

    def get_ingredients
        @component.get_ingredients
    end
end

# MilkDecorator (ConcreteDecorator)
class MilkDecorator < CoffeeDecorator
    def initialize(component)
        super(component)
    end

    def get_cost
        @component.get_cost + 4
    end

    def get_ingredients
        @component.get_ingredients + ', Milk'
    end
end

# EspressoDecorator (ConcreteDecorator)
class EspressoDecorator < CoffeeDecorator
    def initialize(component)
        super(component)
    end

    def get_cost
        @component.get_cost + 5
    end

    def get_ingredients
        @component.get_ingredients + ', Espresso'
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
