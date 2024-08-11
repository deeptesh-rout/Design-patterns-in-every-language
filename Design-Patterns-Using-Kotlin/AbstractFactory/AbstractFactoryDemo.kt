// Menu interface
interface Menu {
    fun desc()
}

// WinMenu class
class WinMenu : Menu {
    override fun desc() {
        println("Win Menu!!")
    }
}

// MacMenu class
class MacMenu : Menu {
    override fun desc() {
        println("Mac Menu!!")
    }
}

// Button interface
interface Button {
    fun desc()
}

// WinButton class
class WinButton : Button {
    override fun desc() {
        println("Win Button!!")
    }
}

// MacButton class
class MacButton : Button {
    override fun desc() {
        println("Mac Button!!")
    }
}

// Abstract Factory interface
interface AbstractFactory {
    val menu: Menu
    val button: Button
}

// WinFactory class
class WinFactory : AbstractFactory {
    override val menu: Menu
        get() = WinMenu()

    override val button: Button
        get() = WinButton()
}

// MacFactory class
class MacFactory : AbstractFactory {
    override val menu: Menu
        get() = MacMenu()

    override val button: Button
        get() = MacButton()
}

// Client code
fun main() {
    val macFactory: AbstractFactory = MacFactory()
    macFactory.menu.desc()
    macFactory.button.desc()

    val winFactory: AbstractFactory = WinFactory()
    winFactory.button.desc()
    winFactory.menu.desc()
}

/*
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!!
*/