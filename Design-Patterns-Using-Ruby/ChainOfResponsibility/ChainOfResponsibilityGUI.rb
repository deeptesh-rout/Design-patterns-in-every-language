# Abstract class representing a handler
class Handler
    attr_accessor :parent, :help_text
    
    def initialize(parent)
        @parent = parent
        @help_text = nil
    end
    
    def show_helper_text
        raise NotImplementedError, 'Subclasses must implement this method'
    end
    
    def set_helper_text(text)
        @help_text = text
    end
end
  
# Class representing a container
class Container < Handler
    def initialize(parent)
        super(parent)
    end
    
    def show_helper_text
        if help_text
            puts "Help :: #{help_text}"
        elsif parent
            puts 'Message passed to next in chain by Container'
            parent.show_helper_text
        end
    end
end

# Class representing a button
class Button < Handler
    attr_accessor :label
    
    def initialize(label, parent)
        super(parent)
        @label = label
    end
    
    def show_helper_text
        if help_text
            puts "Help :: #{help_text}"
        elsif parent
            puts "Message passed to next in chain by Button"
            parent.show_helper_text
        end
    end
end

# Class representing a panel
class Panel < Handler
    def initialize
        super(nil)
    end
    
    def show_helper_text
        if help_text
            puts "Help :: #{help_text}"
        elsif parent
            puts "Message passed to next in chain by Panel"
            parent.show_helper_text
        end
    end
end

# Client code
p = Panel.new
p.set_helper_text('Panel help text.')

b1 = Button.new('Ok', p)
b1.set_helper_text('Ok button help text.')

b2 = Button.new('Cancel', p)

b1.show_helper_text
b2.show_helper_text

=begin 
Help :: Ok button help text.
Message passed to next in chain by Button
Help :: Panel help text.
=end
