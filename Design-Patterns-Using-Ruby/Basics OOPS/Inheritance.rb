class Person
    attr_reader :name, :age, :gender

    def initialize(name, age, gender)
        @name = name
        @age = age
        @gender = gender
    end

    def to_s
        "Person: #{@name} is a #{@gender} and #{@age} years old."
    end
end

class Citizen < Person
    attr_reader :voter_id

    def initialize(name, age, voter_id, gender)
        super(name, age, gender)
        @voter_id = voter_id
    end

    def to_s
        "Citizen: #{@name} is a #{@gender} and #{@age} years old with voter id #{@voter_id}."
    end
end

# Client code
p = Person.new("John", 32, "Male")
puts p.to_s

c = Citizen.new("Smith", 31, 1234, "Male")
puts c.to_s
