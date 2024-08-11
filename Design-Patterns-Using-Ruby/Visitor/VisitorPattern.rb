# Define Element interface
class Element
    def accept(visitor)
        raise NotImplementedError, 'Subclasses must implement the accept method'
    end
end

# Define ConcreteElementA implementing Element
class ConcreteElementA < Element
    def accept(visitor)
        visitor.visit_element_a(self)
    end
end

# Define ConcreteElementB implementing Element
class ConcreteElementB < Element
    def accept(visitor)
        visitor.visit_element_b(self)
    end
end

# Define Visitor interface
class Visitor
    def visit_element_a(element_a)
        raise NotImplementedError, 'Subclasses must implement the visit_element_a method'
    end
    
    def visit_element_b(element_b)
        raise NotImplementedError, 'Subclasses must implement the visit_element_b method'
    end
end

# Define ConcreteVisitor1 implementing Visitor
class ConcreteVisitor1 < Visitor
    def visit_element_a(element_a)
        puts 'ConcreteVisitor1 visit_element_a() method called.'
    end
    
    def visit_element_b(element_b)
        puts 'ConcreteVisitor1 visit_element_b() method called.'
    end
end

# Define ConcreteVisitor2 implementing Visitor
class ConcreteVisitor2 < Visitor
    def visit_element_a(element_a)
        puts 'ConcreteVisitor2 visit_element_a() method called.'
    end
    
    def visit_element_b(element_b)
        puts 'ConcreteVisitor2 visit_element_b() method called.'
    end
end

# Client code
visitor1 = ConcreteVisitor1.new
element_a = ConcreteElementA.new
element_a.accept(visitor1)

element_b = ConcreteElementB.new
element_b.accept(visitor1)

=begin 
ConcreteVisitor1 visit_element_a() method called.
ConcreteVisitor1 visit_element_b() method called.
=end