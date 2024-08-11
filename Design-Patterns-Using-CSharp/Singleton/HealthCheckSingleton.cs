using System;
using System.Collections.Generic;

public class HealthCheckSingleton
{
    private static HealthCheckSingleton instance;
    private List<string> servers;

    private HealthCheckSingleton()
    {
        this.servers = new List<string>();
    }

    public static HealthCheckSingleton GetInstance()
    {
        if (instance == null)
        {
            instance = new HealthCheckSingleton();
        }
        return instance;
    }

    public void AddServer()
    {
        this.servers.Add("Server 1");
        this.servers.Add("Server 2");
    }

    public void ChangeServer()
    {
        this.servers.RemoveAt(this.servers.Count - 1);
        this.servers.Add("Server 5");
    }

    public List<string> GetServers()
    {
        return this.servers;
    }

    public static void Main(string[] args)
    {
        HealthCheckSingleton hc1 = HealthCheckSingleton.GetInstance();
        hc1.AddServer();

        HealthCheckSingleton hc2 = HealthCheckSingleton.GetInstance();
        hc2.AddServer();

        Console.WriteLine(string.Join(", ", hc1.GetServers()));
        Console.WriteLine(string.Join(", ", hc2.GetServers()));
    }
}
