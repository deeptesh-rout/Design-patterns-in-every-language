#include <iostream>

class BookParser {
public:
    virtual int numPages() = 0;
};

class ConcreteBookParser : public BookParser {
private:
    int _numPages;

public:
    ConcreteBookParser() {
        std::cout << "Concrete Book Parser Created" << std::endl;
        // Number of pages calculation heavy operation.
        // Suppose this calculation results in 1000 pages.
        this->_numPages = 1000;
    }

    int numPages() override {
        std::cout << "Concrete Book Parser Request Method" << std::endl;
        return this->_numPages;
    }
};

class LazyBookParserProxy : public BookParser {
private:
    ConcreteBookParser* subject;

public:
    LazyBookParserProxy() : subject(nullptr) {}

    int numPages() override {
        if (subject == nullptr) {
            subject = new ConcreteBookParser();
        }
        return subject->numPages();
    }

    ~LazyBookParserProxy() {
        delete subject; // Clean up allocated memory
    }
};

// Client code
int main() {
    LazyBookParserProxy proxy;
    std::cout << proxy.numPages() << std::endl;

    return 0;
}

/*
Concrete Book Parser Created
Concrete Book Parser Request Method
1000
*/
