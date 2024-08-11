abstract class Handler {
    protected Handler parent;
    protected String helpText;

    public Handler(Handler parent) {
        this.parent = parent;
        this.helpText = null;
    }

    public abstract void showHelperText();

    public void setHelperText(String text) {
        this.helpText = text;
    }
}

class Container extends Handler {
    public Container(Handler parent) {
        super(parent);
    }

    @Override
    public void showHelperText() {
        if (helpText != null) {
            System.out.println("Help :: " + helpText);
        } else if (parent != null) {
            System.out.println("Message passed to next in chain by Container");
            parent.showHelperText();
        }
    }
}

class Button extends Handler {
    private String label;

    public Button(String label, Handler parent) {
        super(parent);
        this.label = label;
    }

    @Override
    public void showHelperText() {
        if (helpText != null) {
            System.out.println("Help :: " + helpText);
        } else if (parent != null) {
            System.out.println("Message passed to next in chain by Button");
            parent.showHelperText();
        }
    }
}

class Panel extends Handler {
    public Panel() {
        super(null);
    }

    @Override
    public void showHelperText() {
        if (helpText != null) {
            System.out.println("Help :: " + helpText);
        } else if (parent != null) {
            System.out.println("Message passed to next in chain by Panel");
            parent.showHelperText();
        }
    }
}

public class ChainOfResponsibilityGUI {
    public static void main(String[] args) {
        Panel p = new Panel();
        p.setHelperText("Panel help text.");

        Button b1 = new Button("Ok", p);
        b1.setHelperText("Ok button help text.");

        Button b2 = new Button("Cancel", p);

        b1.showHelperText();
        b2.showHelperText();
    }
}

/*
Help :: Ok button help text.
Message passed to next in chain by Button
Help :: Panel help text.
*/