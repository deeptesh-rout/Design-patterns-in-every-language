using System;

// Abstract class representing a handler
abstract class Handler
{
    protected Handler parent;
    protected string helpText;

    public Handler(Handler parent)
    {
        this.parent = parent;
        this.helpText = null;
    }

    public abstract void ShowHelperText();

    public void SetHelperText(string text)
    {
        this.helpText = text;
    }
}

// Concrete class representing a container handler
class Container : Handler
{
    public Container(Handler parent) : base(parent)
    {
    }

    public override void ShowHelperText()
    {
        if (helpText != null)
        {
            Console.WriteLine("Help :: " + helpText);
        }
        else if (parent != null)
        {
            Console.WriteLine("Message passed to next in chain by Container");
            parent.ShowHelperText();
        }
    }
}

// Concrete class representing a button handler
class Button : Handler
{
    private string label;

    public Button(string label, Handler parent) : base(parent)
    {
        this.label = label;
    }

    public override void ShowHelperText()
    {
        if (helpText != null)
        {
            Console.WriteLine("Help :: " + helpText);
        }
        else if (parent != null)
        {
            Console.WriteLine("Message passed to next in chain by Button");
            parent.ShowHelperText();
        }
    }
}

// Concrete class representing a panel handler
class Panel : Handler
{
    public Panel() : base(null)
    {
    }

    public override void ShowHelperText()
    {
        if (helpText != null)
        {
            Console.WriteLine("Help :: " + helpText);
        }
        else if (parent != null)
        {
            Console.WriteLine("Message passed to next in chain by Panel");
            parent.ShowHelperText();
        }
    }
}

// Client code
public class ChainOfResponsibilityGUI
{
    public static void Main(string[] args)
    {
        Panel p = new Panel();
        p.SetHelperText("Panel help text.");

        Button b1 = new Button("Ok", p);
        b1.SetHelperText("Ok button help text.");

        Button b2 = new Button("Cancel", p);

        b1.ShowHelperText();
        b2.ShowHelperText();
    }
}
