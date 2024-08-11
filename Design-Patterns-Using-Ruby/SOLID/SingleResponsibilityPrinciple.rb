class Animal
    attr_reader :name

    def initialize(name)
        @name = name
    end

    def eat
        puts "#{name} is eating."
    end

    def sleep
        puts "#{name} is sleeping."
    end

    def make_sound
        puts "#{name} is making a sound."
    end
end

class Mammal < Animal
    def give_birth
        puts "#{name} is giving birth to live young."
    end
end

class Reptile < Animal
    def lay_eggs
        puts "#{name} is laying eggs."
    end
end

class Bird < Animal
    def fly
        puts "#{name} is flying."
    end

    def lay_eggs
        puts "#{name} is laying eggs."
    end
end

# Client code
animal1 = Mammal.new("Cat")
animal1.give_birth
animal1.make_sound

animal2 = Reptile.new("Snake")
animal2.lay_eggs
animal2.eat

animal3 = Bird.new("Eagle")
animal3.lay_eggs
animal3.fly

=begin 
Cat is giving birth to live young.
Cat is making a sound.
Snake is laying eggs.
Snake is eating.
Eagle is laying eggs.
Eagle is flying.
=end