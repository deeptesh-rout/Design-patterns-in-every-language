class Prototype {
    constructor() {}

    clone() {
        throw new Error('clone method must be implemented');
    }
}

class ConcretePrototype1 extends Prototype {
    clone() {
        // ConcretePrototype1 clone
        return new ConcretePrototype1();
    }

    toString() {
        return "ConcretePrototype1";
    }
}

class ConcretePrototype2 extends Prototype {
    clone() {
        // ConcretePrototype2 clone
        return new ConcretePrototype2();
    }

    toString() {
        return "ConcretePrototype2";
    }
}

class PrototypeRegistry {

    static addPrototype(key, value) {
        if (!PrototypeRegistry._prototypes) {
            PrototypeRegistry._prototypes = {};
        }
        if (!(key in PrototypeRegistry._prototypes)) {
            PrototypeRegistry._prototypes[key] = value;
        }
    }

    static getPrototype(key) {
        if (key in PrototypeRegistry._prototypes) {
            return PrototypeRegistry._prototypes[key].clone();
        }
        return null;
    }

    static load() {
        PrototypeRegistry.addPrototype("CP1", new ConcretePrototype1());
        PrototypeRegistry.addPrototype("CP2", new ConcretePrototype2());
    }
}

// Client code
PrototypeRegistry.load();
const c1 = PrototypeRegistry.getPrototype("CP1");
const c2 = PrototypeRegistry.getPrototype("CP2");
console.log(c1.toString());
console.log(c2.toString());

/*
ConcretePrototype1
ConcretePrototype2
*/