import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance = null;;
    private Connection connection;
    private PreparedStatement preparedStatement;

    private DatabaseSingleton() {
        try {
            System.out.println("Database created");
            this.connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public void createTable() {
        try {
            this.preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);");
            this.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addData(int id, String name) {
        try {
            String query = "INSERT INTO students (id, name) VALUES (?, ?);";
            this.preparedStatement = connection.prepareStatement(query);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.setString(2, name);
            this.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        try {
            this.preparedStatement = connection.prepareStatement("SELECT * FROM students;");
            ResultSet resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DatabaseSingleton db1 = DatabaseSingleton.getInstance();
        DatabaseSingleton db2 = DatabaseSingleton.getInstance();
        System.out.println("Database Objects DB1: " + db1);
        System.out.println("Database Objects DB2: " + db2);

        db1.createTable();
        db1.addData(1, "john");
        db2.addData(2, "smith");

        db1.display();
    }
}
