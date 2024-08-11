class Person {
    constructor(name) {
        this.name = name;
        this.oath = '';
    }

    toString() {
        return `Person: ${this.name}:${this.oath}`;
    }

    setOath() {
        this.oath = 'Always tell the truth';
    }
}

class Citizen extends Person {
    constructor(name, id) {
        super(name);
        this.id = id;
    }

    setOath() {
        this.oath = 'Country comes first';
    }
}

// Client code
const p = new Person("John");
p.setOath();
console.log(p.toString());

const c = new Citizen("Smith", 31);
c.setOath();
console.log(c.toString());

/*
Person: John:Always tell the truth
Person: Smith:Country comes first
*/