# Flyweight interface
class Flyweight
    def operation(extrinsic_state)
        raise NotImplementedError, 'Subclasses must implement the operation method'
    end
end

# Concrete Flyweight class
class ConcreteFlyweight < Flyweight
    attr_reader :intrinsic_state

    def initialize(intrinsic_state)
        @intrinsic_state = intrinsic_state
    end

    def operation(_extrinsic_state)
        puts 'Operation inside concrete flyweight'
    end
end

# FlyweightFactory class
class FlyweightFactory
    def initialize
        @flyweights = {}
    end

    def get_flyweight(key)
        @flyweights[key] ||= ConcreteFlyweight.new(key)
    end

    def count
        @flyweights.size
    end
end

# Client code
factory = FlyweightFactory.new
flyweight1 = factory.get_flyweight('key')
flyweight2 = factory.get_flyweight('key')
flyweight1.operation(nil)
puts "#{flyweight1} #{flyweight2}"
puts "Object count: #{factory.count}"

=begin 
Operation inside concrete flyweight
#<ConcreteFlyweight:0x00007f9cfc5217f0> #<ConcreteFlyweight:0x00007f9cfc5217f0>
Object count: 1
=end
