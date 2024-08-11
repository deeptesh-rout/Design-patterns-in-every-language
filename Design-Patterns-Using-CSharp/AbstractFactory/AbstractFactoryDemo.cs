using System;

// Menu interface
interface Menu
{
    void Desc();
}

// WinMenu class
class WinMenu : Menu
{
    public void Desc()
    {
        Console.WriteLine("Win Menu!!");
    }
}

// MacMenu class
class MacMenu : Menu
{
    public void Desc()
    {
        Console.WriteLine("Mac Menu!!");
    }
}

// Button interface
interface Button
{
    void Desc();
}

// WinButton class
class WinButton : Button
{
    public void Desc()
    {
        Console.WriteLine("Win Button!!");
    }
}

// MacButton class
class MacButton : Button
{
    public void Desc()
    {
        Console.WriteLine("Mac Button!!");
    }
}

// Abstract Factory interface
interface AbstractFactory
{
    Menu GetMenu();
    Button GetButton();
}

// WinFactory class
class WinFactory : AbstractFactory
{
    public Menu GetMenu()
    {
        return new WinMenu();
    }

    public Button GetButton()
    {
        return new WinButton();
    }
}

// MacFactory class
class MacFactory : AbstractFactory
{
    public Menu GetMenu()
    {
        return new MacMenu();
    }

    public Button GetButton()
    {
        return new MacButton();
    }
}

// Client code
public class AbstractFactoryDemo
{
    public static void Main(string[] args)
    {
        AbstractFactory macFactory = new MacFactory();
        macFactory.GetMenu().Desc();
        macFactory.GetButton().Desc();

        AbstractFactory winFactory = new WinFactory();
        winFactory.GetButton().Desc();
        winFactory.GetMenu().Desc();
    }
}

/* 
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!!
*/