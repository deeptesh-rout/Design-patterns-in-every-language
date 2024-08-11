# Abstraction interface
class Abstraction
    def initialize(imp)
        @imp = imp
    end
  
    def operation
        @imp.operation
    end
end

# Implementor interface
class Implementor
    def operation
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# ConcreteImplementor1 class
class ConcreteImplementor1 < Implementor
    def operation
        puts 'ConcreteImplementor1 operation'
    end
end

# ConcreteImplementor2 class
class ConcreteImplementor2 < Implementor
    def operation
        puts 'ConcreteImplementor2 operation'
    end
end

# ConcreteAbstraction class
class ConcreteAbstraction < Abstraction
end

# Client code
imp = ConcreteImplementor1.new
abstraction = ConcreteAbstraction.new(imp)
abstraction.operation

=begin
ConcreteImplementor1 operation
=end