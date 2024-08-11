// A class representing a house
class House {
    private String wall;
    private String roof;

    public House(String wall, String roof) {
        this.wall = wall;
        this.roof = roof;
    }

    public void setWall(String wall){
        this.wall = wall;
    }

    public void setRoof(String roof){
        this.roof = roof;
    }

    @Override
    public String toString() {
        return String.format("House of %s and %s", wall, roof);
    }
}

// An abstract builder class that specifies the interface for building a house
abstract class HouseBuilder {
    protected House house;

    public HouseBuilder() {
        this.house = new House("", "");
    }

    public abstract HouseBuilder setWall();

    public abstract HouseBuilder setRoof();

    public House getHouse() {
        House temp = this.house;
        this.house = new House("", ""); // assign new house.
        return temp;
    }
}

// A builder class that builds a wooden house
class WoodenHouseBuilder extends HouseBuilder {
    @Override
    public HouseBuilder setWall() {
        this.house.setWall("Wooden Wall");
        return this;
    }

    @Override
    public HouseBuilder setRoof() {
        this.house.setRoof("Wooden Roof");
        return this;
    }
}

// A builder class that builds a concrete house
class ConcreteHouseBuilder extends HouseBuilder {
    @Override
    public HouseBuilder setWall() {
        this.house.setWall("Concrete Wall");
        return this;
    }

    @Override
    public HouseBuilder setRoof() {
        this.house.setRoof("Concrete Roof");
        return this;
    }
}

// A class that directs the building of a house
class HouseDirector {
    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    public House construct() {
        return this.builder.setWall().setRoof().getHouse();
    }
}

// Client code
public class BuilderPatternHouse {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        HouseDirector director = new HouseDirector(builder);
        House house = director.construct();
        System.out.println(house);

        // Building a wooden house using a WoodenHouseBuilder object
        builder = new WoodenHouseBuilder();
        director = new HouseDirector(builder);
        House house2 = director.construct();
        System.out.println(house2);
    }
}

/*
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
 */