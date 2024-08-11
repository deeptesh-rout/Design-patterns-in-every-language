class Animal
    attr_accessor :name

    def initialize(name)
        @name = name
    end
end

class Bird < Animal
    attr_accessor :flight_height

    def initialize(name)
        super(name)
        @flight_height = 0
    end

    def fly
        # To be implemented in subclasses
    end
end

class Sparrow < Bird
    def fly
        puts "The sparrow is fluttering its wings."
        @flight_height = 100
    end
end

class Penguin < Bird
    def fly
        puts "The penguin cannot fly."
    end

    def slide
        puts "The penguin is sliding on its belly!"
    end

    def swim
        puts "The penguin is swimming in the water!"
    end
end

class Dodo < Bird
    def fly
        puts "The dodo is extinct and cannot fly."
    end
end

def test(bird)
    bird.fly
    if bird.flight_height > 0
        puts "Bird is flying at a positive height."
    else
        puts "Error: fly() method called; flight height is still zero."
    end
end

# Client code
sparrow = Sparrow.new("Sparrow")
test(sparrow)

penguin = Penguin.new("Penguin")
test(penguin)

dodo = Dodo.new("Dodo")
test(dodo)

=begin 
The sparrow is fluttering its wings.
Bird is flying at a positive height.
The penguin cannot fly.
Error: fly() method called; flight height is still zero.
The dodo is extinct and cannot fly.
Error: fly() method called; flight height is still zero.
=end