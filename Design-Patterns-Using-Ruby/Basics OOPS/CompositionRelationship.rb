class Tyre
    attr_reader :type

    def initialize(type)
        @type = type
    end
end

class Car
    attr_reader :model, :tyres

    def initialize(model)
        @model = model
        @tyres = Array.new(4) { Tyre.new("MRF") }
    end

    def display
        puts "Car: #{@model}, Tyre: #{tyres[0].type}"
    end
end

# Client code
car = Car.new("BMW")
car.display
