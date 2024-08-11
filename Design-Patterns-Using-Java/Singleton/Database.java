import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static Database _instance = null; // Keep instance reference
    private static Connection connection;
    
    private Database() {
        try {
            System.out.println("Database created");
            connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (_instance == null) {
            _instance = new Database();
        }
        return _instance;
    }

    public void createTable() {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);"
            );
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addData(int id, String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO students (id, name) VALUES (?, ?);"
            );
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println("Database Objects DB1: " + db1);
        System.out.println("Database Objects DB2: " + db2);

        db1.createTable();
        db1.addData(1, "john");
        db2.addData(2, "smith");

        db1.display();
    }
}
