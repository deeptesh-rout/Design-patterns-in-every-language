// Printer Interface
class Printer {
    print(document) {
        throw new Error('You have to implement the method print!');
    }

    scan() {
        throw new Error('You have to implement the method scan!');
    }

    fax(document) {
        throw new Error('You have to implement the method fax!');
    }
}

// Printable Interface
class Printable {
    print(document) {
        throw new Error('You have to implement the method print!');
    }
}

// Scannable Interface
class Scannable {
    scan() {
        throw new Error('You have to implement the method scan!');
    }
}

// Faxable Interface
class Faxable {
    fax(document) {
        throw new Error('You have to implement the method fax!');
    }
}

// BasicInkjetPrinter Class
class BasicInkjetPrinter extends Printable {
    print(document) {
        console.log(`Printing ${document} using basic inkjet printer`);
    }
}

// HighEndOfficePrinter Class
class HighEndOfficePrinter extends Printer {
    print(document) {
        console.log(`Printing ${document} using high end office printer`);
    }

    scan() {
        console.log("Scanning using high end office printer");
    }

    fax(document) {
        console.log(`Faxing ${document} using high end office printer`);
    }
}

// Client code
// BasicInkjetPrinter
const basicPrinter = new BasicInkjetPrinter();
basicPrinter.print("Sample Document");

// HighEndOfficePrinter
const officePrinter = new HighEndOfficePrinter();
officePrinter.print("Important Report");
officePrinter.scan();
officePrinter.fax("Confidential Memo");

/*
Printing Sample Document using basic inkjet printer
Printing Important Report using high end office printer
Scanning using high end office printer
Faxing Confidential Memo using high end office printer
*/
