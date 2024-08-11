using System;

public class Database
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

public sealed class Singleton
{
    private static volatile Singleton instance;
    private static Database db;
    private static readonly object lockObject = new object();

    private Singleton()
    {
        db = new Database();
    }

    public static Singleton Instance
    {
        get
        {
            if (instance == null)
            {
                lock (lockObject)
                {
                    if (instance == null)
                    {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    public void AddData(string data)
    {
        db.AddData(data);
    }
}

// Client code

public class DoubleChecking
{
    public static void Main()
    {
        Singleton s1 = Singleton.Instance;
        Singleton s2 = Singleton.Instance;

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