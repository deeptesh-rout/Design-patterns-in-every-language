#include <iostream>
#include <string>

// A class representing a house
class House {
private:
    std::string wall;
    std::string roof;

public:
    House(const std::string& wall, const std::string& roof) : wall(wall), roof(roof) {}

    void setWall(const std::string& wall) {
        this->wall = wall;
    }

    void setRoof(const std::string& roof) {
        this->roof = roof;
    }

    friend std::ostream& operator<<(std::ostream& os, const House& house) {
        os << "House of " << house.wall << " and " << house.roof;
        return os;
    }
};

// An abstract builder class that specifies the interface for building a house
class HouseBuilder {
protected:
    House house;

public:
    HouseBuilder() : house("", "") {}

    virtual HouseBuilder* setWall() = 0;
    virtual HouseBuilder* setRoof() = 0;

    House getHouse() {
        House temp = this->house;
        this->house = House("", ""); // assign new house.
        return temp;
    }
};

// A builder class that builds a wooden house
class WoodenHouseBuilder : public HouseBuilder {
public:
    HouseBuilder* setWall() override {
        this->house.setWall("Wooden Wall");
        return this;
    }

    HouseBuilder* setRoof() override {
        this->house.setRoof("Wooden Roof");
        return this;
    }
};

// A builder class that builds a concrete house
class ConcreteHouseBuilder : public HouseBuilder {
public:
    HouseBuilder* setWall() override {
        this->house.setWall("Concrete Wall");
        return this;
    }

    HouseBuilder* setRoof() override {
        this->house.setRoof("Concrete Roof");
        return this;
    }
};

// A class that directs the building of a house
class HouseDirector {
private:
    HouseBuilder* builder;

public:
    HouseDirector(HouseBuilder* builder) : builder(builder) {}

    House construct() {
        return this->builder->setWall()->setRoof()->getHouse();
    }
};

// Client code
int main() {
    HouseBuilder* builder = new ConcreteHouseBuilder();
    HouseDirector director(builder);
    House house = director.construct();
    std::cout << house << std::endl;

    // Building a wooden house using a WoodenHouseBuilder object
    builder = new WoodenHouseBuilder();
    director = HouseDirector(builder);
    House house2 = director.construct();
    std::cout << house2 << std::endl;

    // Displaying both houses
    std::cout << house << std::endl;
    std::cout << house2 << std::endl;

    // Clean up memory
    delete builder;

    return 0;
}

/*
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
*/