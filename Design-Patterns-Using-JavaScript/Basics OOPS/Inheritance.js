class Person {
    constructor(name, age, gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    toString() {
        return `Person: ${this.name} is a ${this.gender} and ${this.age} years old.`;
    }

    getGender() {
        return this.gender;
    }
}

class Citizen extends Person {
    constructor(name, age, id, gender) {
        super(name, age, gender);
        this.id = id;
    }

    getVoterId() {
        return this.id;
    }

    toString() {
        return `Citizen: ${this.name} is a ${this.gender} and ${this.age} years old with voter id ${this.id}.`;
    }
}

// Client code
const p = new Person("John", 32, "Male");
console.log(p.toString());

const c = new Citizen("Smith", 31, 1234, "Male");
console.log(c.toString());

/*
Person: John is a Male and 32 years old.
Citizen: Smith is a Male and 31 years old with voter id 1234.
*/