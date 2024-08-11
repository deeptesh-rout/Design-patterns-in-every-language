// Menu protocol
protocol Menu {
    func desc()
}

// WinMenu class
class WinMenu: Menu {
    func desc() {
        print("Win Menu!!")
    }
}

// MacMenu class
class MacMenu: Menu {
    func desc() {
        print("Mac Menu!!")
    }
}

// Button protocol
protocol Button {
    func desc()
}

// WinButton class
class WinButton: Button {
    func desc() {
        print("Win Button!!")
    }
}

// MacButton class
class MacButton: Button {
    func desc() {
        print("Mac Button!!")
    }
}

// Abstract Factory protocol
protocol AbstractFactory {
    func getMenu() -> Menu
    func getButton() -> Button
}

// WinFactory class
class WinFactory: AbstractFactory {
    func getMenu() -> Menu {
        return WinMenu()
    }

    func getButton() -> Button {
        return WinButton()
    }
}

// MacFactory class
class MacFactory: AbstractFactory {
    func getMenu() -> Menu {
        return MacMenu()
    }

    func getButton() -> Button {
        return MacButton()
    }
}

// Client code
let macFactory: AbstractFactory = MacFactory()
macFactory.getMenu().desc()
macFactory.getButton().desc()

let winFactory: AbstractFactory = WinFactory()
winFactory.getButton().desc()
winFactory.getMenu().desc()

/*
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!!
*/
