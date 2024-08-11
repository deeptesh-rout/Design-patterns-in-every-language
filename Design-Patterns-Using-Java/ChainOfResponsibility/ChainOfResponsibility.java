// Handler abstract class
abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    abstract void handleRequest(String request);
}

// ConcreteHandler1 class
class ConcreteHandler1 extends Handler {
    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    void handleRequest(String request) {
        if ("request1".equals(request)) {
            System.out.println("ConcreteHandler1 handles the request1.");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// ConcreteHandler2 class
class ConcreteHandler2 extends Handler {
    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    void handleRequest(String request) {
        if ("request2".equals(request)) {
            System.out.println("ConcreteHandler2 handles the request2.");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// ConcreteHandler3 class
class ConcreteHandler3 extends Handler {
    public ConcreteHandler3(Handler successor) {
        super(successor);
    }

    @Override
    void handleRequest(String request) {
        if ("request3".equals(request)) {
            System.out.println("ConcreteHandler3 handles the request3.");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// Client code
public class ChainOfResponsibility {
    public static void main(String[] args) {
        ConcreteHandler1 ch1 = new ConcreteHandler1(null);
        ConcreteHandler2 ch2 = new ConcreteHandler2(ch1);
        ConcreteHandler3 ch3 = new ConcreteHandler3(ch2);

        ch3.handleRequest("request1");
        ch3.handleRequest("request2");
        ch3.handleRequest("request3");
        ch3.handleRequest("request4");
    }
}


/* 
ConcreteHandler1 handles the request1.
ConcreteHandler2 handles the request2.
ConcreteHandler3 handles the request3.
*/