class Animal
    attr_reader :name

    def initialize(name)
        @name = name
    end
end

class Bird < Animal
    def fly
        case name
        when "Dodo"
            puts "The dodo is extinct and cannot fly."
        when "Penguin"
            puts "The penguin cannot fly."
        when "Eagle"
            puts "The eagle is soaring through the sky!"
        when "Sparrow"
            puts "The sparrow is fluttering its wings!"
        end
    end
end

# Client code
bird1 = Bird.new("Eagle")
bird1.fly

bird2 = Bird.new("Dodo")
bird2.fly

=begin 
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
=end
