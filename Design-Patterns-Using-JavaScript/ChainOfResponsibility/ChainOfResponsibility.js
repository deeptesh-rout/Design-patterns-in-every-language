// Handler abstract class
class Handler {
    constructor(successor) {
        this.successor = successor;
    }

    handleRequest(request) {
        throw new Error('Method handleRequest() must be implemented');
    }
}

// ConcreteHandler1 class
class ConcreteHandler1 extends Handler {
    constructor(successor) {
        super(successor);
    }

    handleRequest(request) {
        if (request === "request1") {
            console.log("ConcreteHandler1 handles the request1.");
        } else if (this.successor !== null) {
            this.successor.handleRequest(request);
        }
    }
}

// ConcreteHandler2 class
class ConcreteHandler2 extends Handler {
    constructor(successor) {
        super(successor);
    }

    handleRequest(request) {
        if (request === "request2") {
            console.log("ConcreteHandler2 handles the request2.");
        } else if (this.successor !== null) {
            this.successor.handleRequest(request);
        }
    }
}

// ConcreteHandler3 class
class ConcreteHandler3 extends Handler {
    constructor(successor) {
        super(successor);
    }

    handleRequest(request) {
        if (request === "request3") {
            console.log("ConcreteHandler3 handles the request3.");
        } else if (this.successor !== null) {
            this.successor.handleRequest(request);
        }
    }
}

// Client code
const ch1 = new ConcreteHandler1(null);
const ch2 = new ConcreteHandler2(ch1);
const ch3 = new ConcreteHandler3(ch2);

ch3.handleRequest("request1");
ch3.handleRequest("request2");
ch3.handleRequest("request3");
ch3.handleRequest("request4");
