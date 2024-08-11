# Product interface
class Animal
    def speak
        raise NotImplementedError, 'Subclasses must implement the speak method'
    end
end

# Concrete Product classes
class Dog < Animal
    def speak
        puts 'Woof Woof!'
    end
end

class Cat < Animal
    def speak
        puts 'Meow Meow!'
    end
end

# Creator abstract class
class AnimalFactory
    def create_animal
        raise NotImplementedError, 'Subclasses must implement the create_animal method'
    end
end

# Concrete Creator classes
class DogFactory < AnimalFactory
    def create_animal
        Dog.new
    end
end

class CatFactory < AnimalFactory
    def create_animal
        Cat.new
    end
end
  
# Client code
dog_factory = DogFactory.new
dog = dog_factory.create_animal
dog.speak

cat_factory = CatFactory.new
cat = cat_factory.create_animal
cat.speak

=begin 
Woof Woof!
Meow Meow!
=end