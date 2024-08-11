class Database
    def initialize
        puts 'Database created'
    end

    def add_data(data)
        puts data
    end
end

class Singleton
    private_class_method :new

    @@instance = nil
    @@db = nil

    def self.instance
        @@instance ||= new
        @@db ||= Database.new
    end

    def add_data(data)
        @@db.add_data(data)
    end
end

# Client code
s1 = Singleton.instance
s2 = Singleton.instance
puts s1
puts s2
s2.add_data('Hello, world!')

=begin 
Database created
#<Singleton:0x000055c5932d2ec8>
#<Singleton:0x000055c5932d2ec8>
Hello, world!
=end
