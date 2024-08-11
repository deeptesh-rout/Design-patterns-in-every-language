using System;
using System.Data;
using System.Data.SQLite;

public class Database
{
    private static Database _instance = null;
    private IDbConnection connection;

    private Database()
    {
        try
        {
            Console.WriteLine("Database created");
            connection = new SQLiteConnection("Data Source=db.sqlite3;");
            connection.Open();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }

    public static Database GetInstance()
    {
        if (_instance == null)
        {
            _instance = new Database();
        }
        return _instance;
    }

    public void CreateTable()
    {
        try
        {
            using (IDbCommand command = connection.CreateCommand())
            {
                command.CommandText = "CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);";
                command.ExecuteNonQuery();
            }
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
            using (IDbCommand command = connection.CreateCommand())
            {
                command.CommandText = "INSERT INTO students (id, name) VALUES (@id, @name);";
                IDataParameter paramId = command.CreateParameter();
                paramId.ParameterName = "@id";
                paramId.Value = id;
                command.Parameters.Add(paramId);

                IDataParameter paramName = command.CreateParameter();
                paramName.ParameterName = "@name";
                paramName.Value = name;
                command.Parameters.Add(paramName);

                command.ExecuteNonQuery();
            }
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
            using (IDbCommand command = connection.CreateCommand())
            {
                command.CommandText = "SELECT * FROM students;";
                using (IDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        int id = Convert.ToInt32(reader["id"]);
                        string name = Convert.ToString(reader["name"]);
                        Console.WriteLine("ID: " + id + ", Name: " + name);
                    }
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
        Database db1 = Database.GetInstance();
        Database db2 = Database.GetInstance();

        Console.WriteLine("Database Objects DB1: " + db1);
        Console.WriteLine("Database Objects DB2: " + db2);

        db1.CreateTable();
        db1.AddData(1, "john");
        db2.AddData(2, "smith");

        db1.Display();
    }
}
