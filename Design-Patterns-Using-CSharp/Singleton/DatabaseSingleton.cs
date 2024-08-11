using System;
using System.Data;
using System.Data.SQLite;

public class DatabaseSingleton
{
    private static DatabaseSingleton instance;
    private IDbConnection connection;
    private IDbCommand command;

    private DatabaseSingleton()
    {
        try
        {
            Console.WriteLine("Database created");
            connection = new SQLiteConnection("Data Source=db.sqlite3;");
            connection.Open();
            command = connection.CreateCommand();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }

    public static DatabaseSingleton GetInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public void CreateTable()
    {
        try
        {
            command.CommandText = "CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);";
            command.ExecuteNonQuery();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }

    public void AddData(int id, string name)
    {
        try
        {
            command.CommandText = $"INSERT INTO students (id, name) VALUES ({id}, '{name}');";
            command.ExecuteNonQuery();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }

    public void Display()
    {
        try
        {
            command.CommandText = "SELECT * FROM students;";
            using (IDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    int studentId = Convert.ToInt32(reader["id"]);
                    string studentName = Convert.ToString(reader["name"]);
                    Console.WriteLine($"ID: {studentId}, Name: {studentName}");
                }
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }

    // Client code
    public static void Main(string[] args)
    {
        DatabaseSingleton db1 = DatabaseSingleton.GetInstance();
        DatabaseSingleton db2 = DatabaseSingleton.GetInstance();

        Console.WriteLine($"Database Objects DB1: {db1}");
        Console.WriteLine($"Database Objects DB2: {db2}");

        db1.CreateTable();
        db1.AddData(1, "john");
        db2.AddData(2, "smith");

        db1.Display();
    }
}
