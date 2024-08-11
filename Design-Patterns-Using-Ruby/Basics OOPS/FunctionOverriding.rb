class Person
    attr_reader :name
    attr_accessor :oath

    def initialize(name)
        @name = name
    end

    def to_s
        "Person: #{@name}:#{@oath}"
    end

    def set_oath
        @oath = "Always tell the truth"
    end
end

class Citizen < Person
    attr_reader :id

    def initialize(name, id)
        super(name)
        @id = id
    end

    def set_oath
        @oath = "Country comes first"
    end
end

# Client code
p = Person.new("John")
p.set_oath
puts p.to_s

c = Citizen.new("Smith", 31)
c.set_oath
puts c.to_s
