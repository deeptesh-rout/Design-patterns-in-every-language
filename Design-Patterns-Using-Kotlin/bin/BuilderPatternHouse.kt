// A class representing a house
class House(private var wall: String, private var roof: String) {
    fun setWall(wall: String) {
        this.wall = wall
    }

    fun setRoof(roof: String) {
        this.roof = roof
    }

    override fun toString(): String {
        return String.format("House of %s and %s", wall, roof)
    }
}

// An abstract builder class that specifies the interface for building a house
abstract class HouseBuilder {
    protected var hs: House = House("", "")

    abstract fun setWall(): HouseBuilder

    abstract fun setRoof(): HouseBuilder

    fun getHouse(): House {
        val temp = this.hs
        this.hs = House("", "") // assign new house.
        return temp
    }
}

// A builder class that builds a wooden house
class WoodenHouseBuilder : HouseBuilder() {
    override fun setWall(): HouseBuilder {
        hs.setWall("Wooden Wall")
        return this
    }

    override fun setRoof(): HouseBuilder {
        hs.setRoof("Wooden Roof")
        return this
    }
}

// A builder class that builds a concrete house
class ConcreteHouseBuilder : HouseBuilder() {
    override fun setWall(): HouseBuilder {
        hs.setWall("Concrete Wall")
        return this
    }

    override fun setRoof(): HouseBuilder {
        hs.setRoof("Concrete Roof")
        return this
    }
}

// A class that directs the building of a house
class HouseDirector(private val builder: HouseBuilder) {
    fun construct(): House {
        return builder.setWall().setRoof().getHouse()
    }
}

// Client code
fun main() {
    var builder: HouseBuilder = ConcreteHouseBuilder()
    var director = HouseDirector(builder)
    val house = director.construct()
    println(house)

    // Building a wooden house using a WoodenHouseBuilder object
    builder = WoodenHouseBuilder()
    director = HouseDirector(builder)
    val house2 = director.construct()
    println(house2)
}
 
/*
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
*/

