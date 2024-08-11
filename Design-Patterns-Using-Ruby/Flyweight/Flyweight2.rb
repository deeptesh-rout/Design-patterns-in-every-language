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

    def operation(extrinsic_state)
        puts "Operation inside concrete flyweight: #{self}"
    end
end

# FlyweightFactory class
class FlyweightFactory
    def initialize
        @flyweights = {}
    end

    def get_flyweight(intrinsic_state)
        @flyweights[intrinsic_state] ||= ConcreteFlyweight.new(intrinsic_state)
    end
end

# ClientClass
class ClientClass
    attr_reader :flyweight, :extrinsic_state

    def initialize(factory, intrinsic_state, extrinsic_state)
        @flyweight = factory.get_flyweight(intrinsic_state)
        @extrinsic_state = extrinsic_state
    end

    def operation
        puts "Operation inside context: #{self}"
        flyweight.operation(extrinsic_state)
    end
end

# Client code
factory = FlyweightFactory.new
c = ClientClass.new(factory, 'common', 'separate1')
c.operation
c2 = ClientClass.new(factory, 'common', 'separate2')
c2.operation

=begin 
Operation inside context: #<ClientClass:0x00007f216104bcb0>
Operation inside concrete flyweight: #<ConcreteFlyweight:0x00007f216104b440>
Operation inside context: #<ClientClass:0x00007f2161049050>
Operation inside concrete flyweight: #<ConcreteFlyweight:0x00007f216104b440>
=end

