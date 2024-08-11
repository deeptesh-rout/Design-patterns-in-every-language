abstract class ATMHandlerAbstract {
    protected ATMHandlerAbstract successor;
    protected int denomination;

    public ATMHandlerAbstract(ATMHandlerAbstract successor, int denomination) {
        this.successor = successor;
        this.denomination = denomination;
    }

    public abstract void handleRequest(int amount);
}

class ATMHandler extends ATMHandlerAbstract {
    public ATMHandler(ATMHandlerAbstract successor, int denomination) {
        super(successor, denomination);
    }

    @Override
    public void handleRequest(int amount) {
        int q = amount / denomination;
        int r = amount % denomination;

        if (q != 0) {
            System.out.println(q + " notes of " + denomination);
        }

        if (r != 0 && successor != null) {
            successor.handleRequest(r);
        }
    }
}

public class ChainOfResATM {
    public static void main(String[] args) {
        ATMHandlerAbstract handler = new ATMHandler(new ATMHandler(new ATMHandler(
            new ATMHandler(null, 10), 50), 100), 1000);
        handler.handleRequest(5560);
    }
}

/*
5 notes of 1000
5 notes of 100
1 notes of 50
1 notes of 10
 */