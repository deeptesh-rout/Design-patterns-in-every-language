import Foundation

// BookParser protocol
protocol BookParser {
    func numPages() -> Int
}

// ConcreteBookParser class conforming to BookParser protocol
class ConcreteBookParser: BookParser {
    private var pages: Int

    init() {
        print("Concrete Book Parser Created")
        // Number of pages calculation heavy operation.
        // Suppose this calculation results in 1000 pages.
        self.pages = 1000
    }

    func numPages() -> Int {
        print("Concrete Book Parser Request Method")
        return self.pages
    }
}

// LazyBookParserProxy class conforming to BookParser protocol
class LazyBookParserProxy: BookParser {
    private var subject: ConcreteBookParser?

    func numPages() -> Int {
        if subject == nil {
            subject = ConcreteBookParser()
        }
        return subject!.numPages()
    }
}

// Client Code
let proxy = LazyBookParserProxy()
print(proxy.numPages())

/*
Concrete Book Parser Created
Concrete Book Parser Request Method
1000
*/