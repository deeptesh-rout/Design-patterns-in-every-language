class ATMHandlerAbstract {
    constructor(successor, denomination) {
        this.successor = successor;
        this.denomination = denomination;
    }

    handleRequest(amount) {
        throw new Error("Abstract method: handleRequest");
    }
}

class ATMHandler extends ATMHandlerAbstract {
    constructor(successor, denomination) {
        super(successor, denomination);
    }

    handleRequest(amount) {
        const q = Math.floor(amount / this.denomination);
        const r = amount % this.denomination;

        if (q !== 0) {
            console.log(`${q} notes of ${this.denomination}`);
        }

        if (r !== 0 && this.successor !== null) {
            this.successor.handleRequest(r);
        }
    }
}

// Client code
const handler = new ATMHandler(
    new ATMHandler(
        new ATMHandler(
            new ATMHandler(null, 10), 50
        ), 100
    ), 1000
);

handler.handleRequest(5560);

/*
5 notes of 1000
5 notes of 100
1 notes of 50
1 notes of 10
*/