using System;

class Database
{
    public Database()
    {
        Console.WriteLine("Database created");
    }

    public void AddData(string data)
    {
        Console.WriteLine(data);
    }
}

class Singleton
{
    private static Singleton instance = null;
    private Database db;

    private Singleton()
    {
        instance = this;
        db = new Database();
    }

    public static Singleton GetInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();  // Corrected line
        }
        return instance;
    }

    public void AddData(string data)
    {
        db.AddData(data);
    }
}

// Client code
class SingletonDemo
{
    static void Main()
    {
        Singleton s1 = Singleton.GetInstance();
        Singleton s2 = Singleton.GetInstance();

        Console.WriteLine(s1);
        Console.WriteLine(s2);

        s2.AddData("Hello, world!");
    }
}

/*
Database created
Singleton
Singleton
Hello, world!
*/