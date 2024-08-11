class Handler {
    constructor(parent) {
        this.parent = parent;
        this.helpText = null;
    }

    showHelperText() {
        throw new Error("Abstract method: showHelperText");
    }

    setHelperText(text) {
        this.helpText = text;
    }
}

class Container extends Handler {
    constructor(parent) {
        super(parent);
    }

    showHelperText() {
        if (this.helpText !== null) {
            console.log("Help :: " + this.helpText);
        } else if (this.parent !== null) {
            console.log("Message passed to next in chain by Container");
            this.parent.showHelperText();
        }
    }
}

class Button extends Handler {
    constructor(label, parent) {
        super(parent);
        this.label = label;
    }

    showHelperText() {
        if (this.helpText !== null) {
            console.log("Help :: " + this.helpText);
        } else if (this.parent !== null) {
            console.log("Message passed to next in chain by Button");
            this.parent.showHelperText();
        }
    }
}

class Panel extends Handler {
    constructor() {
        super(null);
    }

    showHelperText() {
        if (this.helpText !== null) {
            console.log("Help :: " + this.helpText);
        } else if (this.parent !== null) {
            console.log("Message passed to next in chain by Panel");
            this.parent.showHelperText();
        }
    }
}

// Client code
const p = new Panel();
p.setHelperText("Panel help text.");

const b1 = new Button("Ok", p);
b1.setHelperText("Ok button help text.");

const b2 = new Button("Cancel", p);

b1.showHelperText();
b2.showHelperText();

/*
Help :: Ok button help text.
Message passed to next in chain by Button
Help :: Panel help text.
*/