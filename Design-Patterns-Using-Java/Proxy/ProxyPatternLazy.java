interface BookParser {
    int numPages();
}

class ConcreteBookParser implements BookParser {
    private int numPages;

    public ConcreteBookParser() {
        System.out.println("Concrete Book Parser Created");
        // Number of pages calculation heavy operation.
        // Suppose this calculation results in 1000 pages.
        this.numPages = 1000;
    }

    @Override
    public int numPages() {
        System.out.println("Concrete Book Parser Request Method");
        return this.numPages;
    }
}

class LazyBookParserProxy implements BookParser {
    private ConcreteBookParser subject;

    @Override
    public int numPages() {
        if (subject == null) {
            subject = new ConcreteBookParser();
        }
        return subject.numPages();
    }
}

public class ProxyPatternLazy {
    public static void main(String[] args) {
        LazyBookParserProxy proxy = new LazyBookParserProxy();
        System.out.println(proxy.numPages());
    }
}

/* 
Concrete Book Parser Created
Concrete Book Parser Request Method
1000
*/
