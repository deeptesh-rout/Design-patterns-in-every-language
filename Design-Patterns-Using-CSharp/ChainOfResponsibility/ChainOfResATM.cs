using System;

// Abstract class representing an ATM handler
abstract class ATMHandlerAbstract
{
    protected ATMHandlerAbstract successor;
    protected int denomination;

    public ATMHandlerAbstract(ATMHandlerAbstract successor, int denomination)
    {
        this.successor = successor;
        this.denomination = denomination;
    }

    public abstract void HandleRequest(int amount);
}

// Concrete class representing an ATM handler
class ATMHandler : ATMHandlerAbstract
{
    public ATMHandler(ATMHandlerAbstract successor, int denomination) : base(successor, denomination)
    {
    }

    public override void HandleRequest(int amount)
    {
        int q = amount / denomination;
        int r = amount % denomination;

        if (q != 0)
        {
            Console.WriteLine($"{q} notes of {denomination}");
        }

        if (r != 0 && successor != null)
        {
            successor.HandleRequest(r);
        }
    }
}

// Client code
public class ChainOfResATM
{
    public static void Main(string[] args)
    {
        ATMHandlerAbstract handler = new ATMHandler(
            new ATMHandler(
                new ATMHandler(
                    new ATMHandler(null, 10), 50
                ), 100
            ), 1000
        );

        handler.HandleRequest(5560);
    }
}
