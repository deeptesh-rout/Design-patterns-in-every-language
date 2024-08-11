class Prototype
    def clone
        super
    end

    def display
        raise NotImplementedError, "Subclasses must implement the 'display' method"
    end
end

class ConcretePrototype1 < Prototype
    def display
        puts "ConcretePrototype1"
    end
end

class ConcretePrototype2 < Prototype
    def display
        puts "ConcretePrototype2"
    end
end

class PrototypeRegistry
    @@prototypes = {}

    def self.add_prototype(key, value)
        @@prototypes[key] = value
    end

    def self.get_prototype(key)
        return @@prototypes[key].clone if @@prototypes.key?(key)
        nil
    end

    def self.load
        add_prototype("CP1", ConcretePrototype1.new)
        add_prototype("CP2", ConcretePrototype2.new)
    end
end

# Client code
PrototypeRegistry.load
c1 = PrototypeRegistry.get_prototype("CP1")
c2 = PrototypeRegistry.get_prototype("CP2")
c1.display
c2.display

=begin 
ConcretePrototype1
ConcretePrototype2 
=end