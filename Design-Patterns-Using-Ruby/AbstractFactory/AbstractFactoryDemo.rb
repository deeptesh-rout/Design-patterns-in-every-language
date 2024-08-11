# Menu interface
module Menu
    def desc
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# WinMenu class
class WinMenu include Menu
    def desc
        puts 'Win Menu!!'
    end
end

# MacMenu class
class MacMenu include Menu
    def desc
        puts 'Mac Menu!!'
    end
end

# Button interface
module Button
    def desc
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# WinButton class
class WinButton include Button
    def desc
        puts 'Win Button!!'
    end
end

# MacButton class
class MacButton include Button
    def desc
        puts 'Mac Button!!'
    end
end

# Abstract Factory interface
module AbstractFactory
    def get_menu
        raise NotImplementedError, 'Subclasses must implement this method'
    end

    def get_button
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# WinFactory class
class WinFactory include AbstractFactory
    def get_menu
        WinMenu.new
    end

    def get_button
        WinButton.new
    end
end

# MacFactory class
class MacFactory include AbstractFactory
    def get_menu
        MacMenu.new
    end

    def get_button
        MacButton.new
    end
end
  
# Client code
mac_factory = MacFactory.new
mac_factory.get_menu.desc
mac_factory.get_button.desc

win_factory = WinFactory.new
win_factory.get_button.desc
win_factory.get_menu.desc

=begin 
Mac Menu!!
Mac Button!!
Win Button!!
Win Menu!! 
=end