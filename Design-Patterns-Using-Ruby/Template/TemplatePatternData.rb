# Define AddDataTemplate
class AddDataTemplate
    def add_data
        open
        add
        close
    end

    def open
        raise NotImplementedError, 'Subclasses must implement the open method'
    end

    def add
        raise NotImplementedError, 'Subclasses must implement the add method'
    end

    def close
        raise NotImplementedError, 'Subclasses must implement the close method'
    end
end

# Define AddDataToFile extending AddDataTemplate
class AddDataToFile < AddDataTemplate
    def open
        puts 'Open file.'
    end

    def add
        puts 'Add data to file.'
    end

    def close
        puts 'Close file.'
    end
end

# Define AddDataToDB extending AddDataTemplate
class AddDataToDB < AddDataTemplate
    def open
        puts 'Open Database.'
    end

    def add
        puts 'Add data to Database.'
    end

    def close
        puts 'Close Database.'
    end
end

# Client code
add_data_to_db = AddDataToDB.new
add_data_to_db.add_data

=begin 
Open Database.
Add data to Database.
Close Database.
=end