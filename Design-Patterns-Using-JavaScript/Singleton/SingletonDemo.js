class Database {
    constructor() {
        console.log("Database created");
    }

    addData(data) {
        console.log(data);
    }
}

class Singleton {
    constructor() {
        if (!Singleton.instance) {
            Singleton.instance = this;
            this.db = new Database();
        }
        return Singleton.instance;
    }

    static getInstance() {
        if (!Singleton.instance) {
            new Singleton();
        }
        return Singleton.instance;
    }

    addData(data) {
        this.db.addData(data);
    }
}

// Client code
const s1 = Singleton.getInstance();
const s2 = Singleton.getInstance();
console.log(s1 === s2); // true, because it's the same instance
s1.addData("Hello, world!");