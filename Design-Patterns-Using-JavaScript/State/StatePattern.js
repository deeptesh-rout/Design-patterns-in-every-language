// Define BulbState interface
class BulbState {
    flip(bc) {
        throw new Error("flip method must be implemented");
    }

    toString() {
        throw new Error("toString method must be implemented");
    }
}

// Define BulbControl class
class BulbControl {
    constructor() {
        this.current = new Off();
    }

    setState(state) {
        this.current = state;
    }

    flip() {
        this.current.flip(this);
    }

    toStringState() {
        return this.current.toString();
    }
}

// Define On class implementing BulbState
class On extends BulbState {
    flip(bc) {
        bc.setState(new Off());
    }

    toString() {
        return "On";
    }
}

// Define Off class implementing BulbState
class Off extends BulbState {
    flip(bc) {
        bc.setState(new On());
    }

    toString() {
        return "Off";
    }
}

// Client code
const c = new BulbControl();
c.flip();
console.log(c.toStringState()); // Output: On
c.flip();
console.log(c.toStringState()); // Output: Off

/*
On
Off
*/