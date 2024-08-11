# Animal interface
class Animal
    def voice
        raise NotImplementedError, 'Subclasses must implement the voice method'
    end
end

# Concrete Animal classes
class Dog < Animal
    def voice
        puts 'Bhow Bhow!!'
    end
end

class Cat < Animal
    def voice
        puts 'Meow Meow!!'
    end
end

# AnimalFactory interface
class AnimalFactory
    def get_animal
        raise NotImplementedError, 'Subclasses must implement the get_animal method'
    end
end

# Concrete AnimalFactory classes
class CatFactory < AnimalFactory
    def get_animal
        Cat.new
    end
end

class DogFactory < AnimalFactory
    def get_animal
        Dog.new
    end
end

# Client code
dog_factory = DogFactory.new
dog_factory.get_animal.voice

cat_factory = CatFactory.new
cat_factory.get_animal.voice

# Future changes to include cow type of objects.
class Cow < Animal
    def voice
        puts 'Gooaa Gooaa!!'
    end
end

class CowFactory < AnimalFactory
    def get_animal
        Cow.new
    end
end

# Client code for Cow
cow_factory = CowFactory.new
cow_factory.get_animal.voice

=begin 
Bhow Bhow!!
Meow Meow!!
Gooaa Gooaa!!
=end