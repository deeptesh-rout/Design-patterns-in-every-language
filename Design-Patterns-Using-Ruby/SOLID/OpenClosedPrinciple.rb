class Animal
    attr_reader :name

    def initialize(name)
        @name = name
    end
end

class Bird < Animal
    def fly
        # Abstract method, to be overridden by subclasses
    end
end

class Dodo < Bird
    def initialize
        super("Dodo")
    end

    def fly
        puts "The dodo is extinct and cannot fly."
    end
end

class Penguin < Bird
    def initialize
        super("Penguin")
    end

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

class Eagle < Bird
    def initialize
        super("Eagle")
    end

    def fly
        puts "The eagle is soaring through the sky!"
    end
end

class Sparrow < Bird
    def initialize
        super("Sparrow")
    end

    def fly
        puts "The sparrow is fluttering its wings!"
    end
end

class Pigeon < Bird
    def initialize
        super("Pigeon")
    end

    def make_cooing_sound
        puts "The pigeon is making a cooing sound."
    end

    def fly
        puts "The pigeon is fluttering its wings!"
    end
end

# Client code
bird1 = Eagle.new
bird1.fly

bird2 = Dodo.new
bird2.fly

bird3 = Pigeon.new
bird3.fly

=begin 
The eagle is soaring through the sky!
The dodo is extinct and cannot fly.
The pigeon is fluttering its wings!
=end