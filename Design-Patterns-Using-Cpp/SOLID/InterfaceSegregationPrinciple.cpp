
#include <iostream>
#include <string>

class Printer {
public:
    virtual void print(const std::string& document) = 0;
    virtual void scan() = 0;
    virtual void fax(const std::string& document) = 0;
};



// Printable interface
class Printable {
public:
    virtual void print(const std::string& document) = 0;
    virtual ~Printable() {}
};

// Scannable interface
class Scannable {
public:
    virtual void scan() = 0;
    virtual ~Scannable() {}
};

// Faxable interface
class Faxable {
public:
    virtual void fax(const std::string& document) = 0;
    virtual ~Faxable() {}
};

// BasicInkjetPrinter class implementing Printable interface
class BasicInkjetPrinter : public Printable {
public:
    void print(const std::string& document) override {
        std::cout << "Printing " << document << " using basic inkjet printer" << std::endl;
    }
};

// HighEndOfficePrinter class implementing Printable, Scannable, and Faxable interfaces
class HighEndOfficePrinter : public Printable, public Scannable, public Faxable {
public:
    void print(const std::string& document) override {
        std::cout << "Printing " << document << " using high end office printer" << std::endl;
    }

    void scan() override {
        std::cout << "Scanning using high end office printer" << std::endl;
    }

    void fax(const std::string& document) override {
        std::cout << "Faxing " << document << " using high end office printer" << std::endl;
    }
};

// Client code
int main() {
    // BasicInkjetPrinter
    BasicInkjetPrinter basicPrinter;
    basicPrinter.print("Sample Document");

    // HighEndOfficePrinter
    HighEndOfficePrinter officePrinter;
    officePrinter.print("Important Report");
    officePrinter.scan();
    officePrinter.fax("Confidential Memo");

    return 0;
}


/*
Printing Sample Document using basic inkjet printer
Printing Important Report using high end office printer
Scanning using high end office printer
Faxing Confidential Memo using high end office printer
*/