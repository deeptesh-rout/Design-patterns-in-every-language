# Define AbstractClass
class AbstractClass
    def template_method
        operation1
        operation2
    end

    def operation1
        raise NotImplementedError, 'Subclasses must implement the operation1 method'
    end

    def operation2
        raise NotImplementedError, 'Subclasses must implement the operation2 method'
    end
end

# Define ConcreteClass1 extending AbstractClass
class ConcreteClass1 < AbstractClass
    def operation1
        puts 'Concrete Class 1 : Operation 1'
    end

    def operation2
        puts 'Concrete Class 1 : Operation 2'
    end
end

# Define ConcreteClass2 extending AbstractClass
class ConcreteClass2 < AbstractClass
    def operation1
        puts 'Concrete Class 2 : Operation 1'
    end

    def operation2
        puts 'Concrete Class 2 : Operation 2'
    end
end

# Client code
concrete_class = ConcreteClass1.new
concrete_class.template_method

=begin 
Concrete Class 1 : Operation 1
Concrete Class 1 : Operation 2 
=end