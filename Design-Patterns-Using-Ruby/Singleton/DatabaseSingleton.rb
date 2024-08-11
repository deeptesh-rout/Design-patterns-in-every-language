require 'sqlite3'

class DatabaseSingleton
  @@instance = nil

  def self.instance
    @@instance ||= new
  end

  def initialize
    begin
      puts "Database created"
      @connection = SQLite3::Database.new('db.sqlite3')
    rescue SQLite3::Exception => e
      puts "Exception occurred: #{e}"
    end
  end

  def create_table
    begin
      @connection.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);")
    rescue SQLite3::Exception => e
      puts "Exception occurred: #{e}"
    end
  end

  def add_data(id, name)
    begin
      query = "INSERT INTO students (id, name) VALUES (?, ?);"
      @connection.execute(query, id, name)
    rescue SQLite3::Exception => e
      puts "Exception occurred: #{e}"
    end
  end

  def display
    begin
      result_set = @connection.execute("SELECT * FROM students;")
      result_set.each do |row|
        puts "ID: #{row[0]}, Name: #{row[1]}"
      end
    rescue SQLite3::Exception => e
      puts "Exception occurred: #{e}"
    end
  end
end

# Client code
db1 = DatabaseSingleton.instance
db2 = DatabaseSingleton.instance

puts "Database Objects DB1: #{db1}"
puts "Database Objects DB2: #{db2}"

db1.create_table
db1.add_data(1, 'john')
db2.add_data(2, 'smith')

db1.display

=begin 
Database created
Database Objects DB1: #<DatabaseSingleton:0x00007ff1959146f8>
Database Objects DB2: #<DatabaseSingleton:0x00007ff1959146f8>
ID: 1, Name: john
ID: 2, Name: smith
=end