// A class representing a house
class House {
    constructor(wall, roof) {
        this.wall = wall;
        this.roof = roof;
    }

    setWall(wall) {
        this.wall = wall;
    }

    setRoof(roof) {
        this.roof = roof;
    }

    toString() {
        return `House of ${this.wall} and ${this.roof}`;
    }
}

// An abstract builder class that specifies the interface for building a house
class HouseBuilder {
    constructor() {
        this.house = new House("", "");
    }

    setWall() {
        throw new Error("Abstract method: setWall");
    }

    setRoof() {
        throw new Error("Abstract method: setRoof");
    }

    getHouse() {
        const temp = this.house;
        this.house = new House("", ""); // assign new house.
        return temp;
    }
}

// A builder class that builds a wooden house
class WoodenHouseBuilder extends HouseBuilder {
    setWall() {
        this.house.setWall("Wooden Wall");
        return this;
    }

    setRoof() {
        this.house.setRoof("Wooden Roof");
        return this;
    }
}

// A builder class that builds a concrete house
class ConcreteHouseBuilder extends HouseBuilder {
    setWall() {
        this.house.setWall("Concrete Wall");
        return this;
    }

    setRoof() {
        this.house.setRoof("Concrete Roof");
        return this;
    }
}

// A class that directs the building of a house
class HouseDirector {
    constructor(builder) {
        this.builder = builder;
    }

    construct() {
        return this.builder.setWall().setRoof().getHouse();
    }
}

// Client code
const builder = new ConcreteHouseBuilder();
const director = new HouseDirector(builder);
const house = director.construct();
console.log(house.toString());

// Building a wooden house using a WoodenHouseBuilder object
const builder2 = new WoodenHouseBuilder();
const director2 = new HouseDirector(builder2);
const house2 = director2.construct();
console.log(house2.toString());

/*
House of Concrete Wall and Concrete Roof
House of Wooden Wall and Wooden Roof
*/