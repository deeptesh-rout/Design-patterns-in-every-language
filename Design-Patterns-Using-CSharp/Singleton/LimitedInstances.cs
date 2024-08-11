using System;
using System.Collections.Generic;

public class LimitedInstances
{
    private static List<LimitedInstances> instances = new List<LimitedInstances>();
    private static readonly int limit = 4;

    private LimitedInstances()
    {
    }

    public static LimitedInstances GetInstance()
    {
        if (instances.Count < limit)
        {
            LimitedInstances instance = new LimitedInstances();
            instances.Add(instance);
            return instance;
        }
        else
        {
            throw new InvalidOperationException("Instance Limit reached");
        }
    }

    public static void Main(string[] args)
    {
        try
        {
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
            LimitedInstances.GetInstance();
        }
        catch (InvalidOperationException e)
        {
            Console.WriteLine(e.Message);
        }
    }
}
