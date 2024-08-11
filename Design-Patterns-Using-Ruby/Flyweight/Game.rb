# Flyweight interface
class Flyweight
    attr_reader :intrinsic_state

    def initialize(intrinsic_state)
        @intrinsic_state = intrinsic_state  # intrinsic state
    end

    def operation(extrinsic_state) # extrinsic state
        raise NotImplementedError, 'Subclasses must implement the operation method'
    end
end

# Concrete Flyweight class
class ConcreteFlyweight < Flyweight
    def operation(extrinsic_state)
        puts 'Operation inside concrete flyweight.'
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
        puts 'Operation inside context.'
        flyweight.operation(extrinsic_state)
    end
end

# Client code
factory = FlyweightFactory.new
c = ClientClass.new(factory, 'common', 'separate1')
c.operation

c2 = ClientClass.new(factory, 'common', 'separate2')
c2.operation

puts c, c2
puts c.flyweight, c2.flyweight

=begin 
Operation inside context.
Operation inside concrete flyweight.
Operation inside context.
Operation inside concrete flyweight.
#<ClientClass:0x00007f307440e970>
#<ClientClass:0x00007f307440d2c8>
#<ConcreteFlyweight:0x00007f307440df98>
#<ConcreteFlyweight:0x00007f307440df98>
=end
