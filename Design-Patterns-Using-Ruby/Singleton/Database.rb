require 'sqlite3'

class Database
    @@instance = nil

    def initialize
        begin
            puts 'Database created'
            @connection = SQLite3::Database.new('db.sqlite3')
            rescue SQLite3::Exception => e
              puts "Exception occurred: #{e}"
        end
    end

    def self.instance
        @@instance ||= new
    end

    def create_table
        begin
            statement = @connection.prepare('CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);')
            statement.execute
          rescue SQLite3::Exception => e
            puts "Exception occurred: #{e}"
        end
    end

    def add_data(id, name)
        begin
            statement = @connection.prepare('INSERT INTO students (id, name) VALUES (?, ?);')
            statement.bind_params(id, name)
            statement.execute
            rescue SQLite3::Exception => e
            puts "Exception occurred: #{e}"
        end
    end

    def drop_table
        begin
            statement = @connection.prepare('DROP TABLE IF EXISTS students;')
            statement.execute
            puts 'Table students dropped successfully.'
          rescue SQLite3::Exception => e
            puts "Exception occurred: #{e}"
        end
    end

    def display
        begin
            statement = @connection.prepare('SELECT * FROM students;')
            result_set = statement.execute
            result_set.each do |row|
              puts "ID: #{row[0]}, Name: #{row[1]}"
            end
          rescue SQLite3::Exception => e
            puts "Exception occurred: #{e}"
        end
    end
end

# Client code
db1 = Database.instance
db2 = Database.instance

puts "Database Objects DB1: #{db1}"
puts "Database Objects DB2: #{db2}"

db1.create_table
db1.add_data(1, 'john')
db2.add_data(2, 'smith')

db1.display
db1.drop_table

=begin 
Database created
Database Objects DB1: #<Database:0x00007f857aac1870>
Database Objects DB2: #<Database:0x00007f857aac1870>
ID: 1, Name: john
ID: 2, Name: smith
Table students dropped successfully.
=end