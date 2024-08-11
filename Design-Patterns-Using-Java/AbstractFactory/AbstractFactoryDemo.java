// Menu interface
interface Menu {
    void desc();
}

// WinMenu class
class WinMenu implements Menu {
    @Override
    public void desc() {
        System.out.println("Win Menu!!");
    }
}

// MacMenu class
class MacMenu implements Menu {
    @Override
    public void desc() {
        System.out.println("Mac Menu!!");
    }
}

// Button interface
interface Button {
    void desc();
}

// WinButton class
class WinButton implements Button {
    @Override
    public void desc() {
        System.out.println("Win Button!!");
    }
}

// MacButton class
class MacButton implements Button {
    @Override
    public void desc() {
        System.out.println("Mac Button!!");
    }
}

// Abstract Factory interface
interface AbstractFactory {
    Menu getMenu();
    Button getButton();
}

// WinFactory class
class WinFactory implements AbstractFactory {
    @Override
    public Menu getMenu() {
        return new WinMenu();
    }

    @Override
    public Button getButton() {
        return new WinButton();
    }
}

// MacFactory class
class MacFactory implements AbstractFactory {
    @Override
    public Menu getMenu() {
        return new MacMenu();
    }

    @Override
    public Button getButton() {
        return new MacButton();
    }
}

// Client code
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory macFactory = new MacFactory();
        macFactory.getMenu().desc();
        macFactory.getButton().desc();

        AbstractFactory winFactory = new WinFactory();
        winFactory.getButton().desc();
        winFactory.getMenu().desc();
    }
}

/* 
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!!
 */