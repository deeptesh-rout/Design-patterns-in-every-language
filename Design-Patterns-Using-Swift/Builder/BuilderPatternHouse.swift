// A class representing a house
class House {
    private var wall: String
    private var roof: String

    init(wall: String, roof: String) {
        self.wall = wall
        self.roof = roof
    }

    func setWall(_ wall: String) {
        self.wall = wall
    }

    func setRoof(_ roof: String) {
        self.roof = roof
    }

    var description: String {
        return "House of \(wall) and \(roof)"
    }
}

// An abstract builder class that specifies the interface for building a house
class HouseBuilder {
    var house: House

    init() {
        self.house = House(wall: "", roof: "")
    }

    func setWall() -> Self {
        fatalError("Abstract method. Subclasses must implement this method.")
    }

    func setRoof() -> Self {
        fatalError("Abstract method. Subclasses must implement this method.")
    }

    func getHouse() -> House {
        let temp = self.house
        self.house = House(wall: "", roof: "") // assign new house.
        return temp
    }
}

// A builder class that builds a wooden house
class WoodenHouseBuilder: HouseBuilder {
    override func setWall() -> Self {
        self.house.setWall("Wooden Wall")
        return self
    }

    override func setRoof() -> Self {
        self.house.setRoof("Wooden Roof")
        return self
    }
}

// A builder class that builds a concrete house
class ConcreteHouseBuilder: HouseBuilder {
    override func setWall() -> Self {
        self.house.setWall("Concrete Wall")
        return self
    }

    override func setRoof() -> Self {
        self.house.setRoof("Concrete Roof")
        return self
    }
}

// A class that directs the building of a house
class HouseDirector {
    private var builder: HouseBuilder

    init(builder: HouseBuilder) {
        self.builder = builder
    }

    func construct() -> House {
        return self.builder.setWall().setRoof().getHouse()
    }
}

// Client code
let builder = ConcreteHouseBuilder()
let director = HouseDirector(builder: builder)
let house = director.construct()
print(house.description)

let builder2 = WoodenHouseBuilder()
let director2 = HouseDirector(builder: builder2)
let house2 = director2.construct()
print(house2.description)

/*
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
*/
