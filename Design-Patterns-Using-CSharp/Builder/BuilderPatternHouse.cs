using System;

// A class representing a house
class House
{
    private string wall;
    private string roof;

    public House(string wall, string roof)
    {
        this.wall = wall;
        this.roof = roof;
    }

    public void SetWall(string wall)
    {
        this.wall = wall;
    }

    public void SetRoof(string roof)
    {
        this.roof = roof;
    }

    public override string ToString()
    {
        return $"House of {wall} and {roof}";
    }
}

// An abstract builder class that specifies the interface for building a house
abstract class HouseBuilder
{
    protected House house;

    public HouseBuilder()
    {
        this.house = new House("", "");
    }

    public abstract HouseBuilder SetWall();

    public abstract HouseBuilder SetRoof();

    public House GetHouse()
    {
        House temp = this.house;
        this.house = new House("", ""); // assign new house.
        return temp;
    }
}

// A builder class that builds a wooden house
class WoodenHouseBuilder : HouseBuilder
{
    public override HouseBuilder SetWall()
    {
        this.house.SetWall("Wooden Wall");
        return this;
    }

    public override HouseBuilder SetRoof()
    {
        this.house.SetRoof("Wooden Roof");
        return this;
    }
}

// A builder class that builds a concrete house
class ConcreteHouseBuilder : HouseBuilder
{
    public override HouseBuilder SetWall()
    {
        this.house.SetWall("Concrete Wall");
        return this;
    }

    public override HouseBuilder SetRoof()
    {
        this.house.SetRoof("Concrete Roof");
        return this;
    }
}

// A class that directs the building of a house
class HouseDirector
{
    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder)
    {
        this.builder = builder;
    }

    public House Construct()
    {
        return this.builder.SetWall().SetRoof().GetHouse();
    }
}

// Client code
public class BuilderPatternHouse
{
    public static void Main(string[] args)
    {
        HouseBuilder builder = new ConcreteHouseBuilder();
        HouseDirector director = new HouseDirector(builder);
        House house = director.Construct();
        Console.WriteLine(house);

        // Building a wooden house using a WoodenHouseBuilder object
        builder = new WoodenHouseBuilder();
        director = new HouseDirector(builder);
        House house2 = director.Construct();
        Console.WriteLine(house2);

        // Displaying both houses
        Console.WriteLine(house);
        Console.WriteLine(house2);
    }
}
