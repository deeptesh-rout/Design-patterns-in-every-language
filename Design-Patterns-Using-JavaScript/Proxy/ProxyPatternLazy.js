// Interface
class BookParser {
    numPages() {
        throw new Error('numPages method must be implemented');
    }
}

// ConcreteBookParser class
class ConcreteBookParser extends BookParser {
    constructor() {
        super();
        console.log("Concrete Book Parser Created");
        // Number of pages calculation heavy operation.
        // Suppose this calculation results in 1000 pages.
        this.numPagesValue = 1000;
    }

    numPages() {
        console.log("Concrete Book Parser Request Method");
        return this.numPagesValue;
    }
}

// LazyBookParserProxy class
class LazyBookParserProxy extends BookParser {
    constructor() {
        super();
        this.subject = null;
    }

    numPages() {
        if (!this.subject) {
            this.subject = new ConcreteBookParser();
        }
        return this.subject.numPages();
    }
}

// Client code
const proxy = new LazyBookParserProxy();
console.log(proxy.numPages());

/*
Concrete Book Parser Created
Concrete Book Parser Request Method
1000
*/