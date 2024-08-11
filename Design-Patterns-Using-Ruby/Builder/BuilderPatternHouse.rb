# A class representing a house
class House
    attr_accessor :wall, :roof
  
    def initialize(wall, roof)
        @wall = wall
        @roof = roof
    end
  
    def to_s
        "House of #{@wall} and #{@roof}"
    end
end

# An abstract builder class that specifies the interface for building a house
class HouseBuilder
    attr_accessor :house
  
    def initialize
        @house = House.new("", "")
    end
  
    def set_wall
        raise NotImplementedError, 'Subclasses must implement this method'
    end
  
    def set_roof
        raise NotImplementedError, 'Subclasses must implement this method'
    end
  
    def get_house
        temp = @house
        @house = House.new("", "") # assign new house.
        temp
    end
end

# A builder class that builds a wooden house
class WoodenHouseBuilder < HouseBuilder
    def set_wall
        @house.wall = "Wooden Wall"
        self
    end
  
    def set_roof
        @house.roof = "Wooden Roof"
        self
    end
end

# A builder class that builds a concrete house
class ConcreteHouseBuilder < HouseBuilder
    def set_wall
        @house.wall = "Concrete Wall"
        self
    end
  
    def set_roof
        @house.roof = "Concrete Roof"
        self
    end
end

# A class that directs the building of a house
class HouseDirector
    attr_accessor :builder
  
    def initialize(builder)
        @builder = builder
    end
  
    def construct
        @builder.set_wall.set_roof.get_house
    end
end

# Client code
builder = ConcreteHouseBuilder.new
director = HouseDirector.new(builder)
house = director.construct
puts house

builder = WoodenHouseBuilder.new
director = HouseDirector.new(builder)
house2 = director.construct
puts house2

=begin 
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
=end