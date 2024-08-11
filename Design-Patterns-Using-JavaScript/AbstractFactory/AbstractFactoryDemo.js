// Menu interface
class Menu {
    desc() {
        console.log("Menu!!");
    }
}

// WinMenu class
class WinMenu extends Menu {
    desc() {
        console.log("Win Menu!!");
    }
}

// MacMenu class
class MacMenu extends Menu {
    desc() {
        console.log("Mac Menu!!");
    }
}

// Button interface
class Button {
    desc() {
        console.log("Button!!");
    }
}

// WinButton class
class WinButton extends Button {
    desc() {
        console.log("Win Button!!");
    }
}

// MacButton class
class MacButton extends Button {
    desc() {
        console.log("Mac Button!!");
    }
}

// Abstract Factory interface
class AbstractFactory {
    getMenu() {
        throw new Error("Abstract method: getMenu");
    }

    getButton() {
        throw new Error("Abstract method: getButton");
    }
}

// WinFactory class
class WinFactory extends AbstractFactory {
    getMenu() {
        return new WinMenu();
    }

    getButton() {
        return new WinButton();
    }
}

// MacFactory class
class MacFactory extends AbstractFactory {
    getMenu() {
        return new MacMenu();
    }

    getButton() {
        return new MacButton();
    }
}

// Client code
const macFactory = new MacFactory();
macFactory.getMenu().desc();
macFactory.getButton().desc();

const winFactory = new WinFactory();
winFactory.getButton().desc();
winFactory.getMenu().desc();

/*
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!!
*/