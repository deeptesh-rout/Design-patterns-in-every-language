// Interface
class Subject {
    request() {
        throw new Error('request method must be implemented');
    }
}

// RealSubject class
class RealSubject extends Subject {
    request() {
        console.log("Concrete Subject Request Method");
    }
}

// Proxy class
class Proxy extends Subject {
    constructor() {
        super();
        this.realSubject = null;
    }

    request() {
        if (!this.realSubject) {
            this.realSubject = new RealSubject(); // Lazy Initialization
        }
        this.realSubject.request();
    }
}

// Client code
const proxy = new Proxy();
proxy.request();

/*
Concrete Subject Request Method
*/