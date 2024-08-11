

public abstract class Printer {

    public abstract void print(String document);

    public abstract void scan();

    public abstract void fax(String document);
}

interface Printable {
    void print(String document);
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax(String document);
}

class BasicInkjetPrinter implements Printable {
    @Override
    public void print(String document) {
        System.out.printf("Printing %s using basic inkjet printer%n", document);
    }
}

class HighEndOfficePrinter implements Printable, Scannable, Faxable {
    @Override
    public void print(String document) {
        System.out.printf("Printing %s using high end office printer%n", document);
    }

    @Override
    public void scan() {
        System.out.println("Scanning using high end office printer");
    }

    @Override
    public void fax(String document) {
        System.out.printf("Faxing %s using high end office printer%n", document);
    }
}

// Client code
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        // BasicInkjetPrinter
        BasicInkjetPrinter basicPrinter = new BasicInkjetPrinter();
        basicPrinter.print("Sample Document");

        // HighEndOfficePrinter
        HighEndOfficePrinter officePrinter = new HighEndOfficePrinter();
        officePrinter.print("Important Report");
        officePrinter.scan();
        officePrinter.fax("Confidential Memo");
    }
}

/*
Printing Sample Document using basic inkjet printer
Printing Important Report using high end office printer
Scanning using high end office printer
Faxing Confidential Memo using high end office printer
*/