using System;
using System.Threading;

public class ThreadLocalValue
{
    // ThreadLocal variable
    private static readonly ThreadLocal<string> tlsVar = new ThreadLocal<string>();

    // Function to set thread-local value
    private static void SetTLSValue(string value)
    {
        tlsVar.Value = value;
    }

    // Function to get thread-local value
    private static string GetTLSValue()
    {
        return tlsVar.Value;
    }

    // Worker thread function
    private static void WorkerThread()
    {
        // Set thread-specific value
        SetTLSValue("Thread-specific value for " + Thread.CurrentThread.Name);

        // Simulate some work
        Thread.Sleep(1000); // Simulate work with a sleep

        // Print thread-specific value
        Console.WriteLine(Thread.CurrentThread.Name + " value: " + GetTLSValue());
    }

    public static void Main(string[] args)
    {
        // Create and start multiple worker threads
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++)
        {
            threads[i] = new Thread(WorkerThread);
            threads[i].Name = "Thread-" + i;
            threads[i].Start();
        }

        // Wait for all threads to complete
        foreach (Thread t in threads)
        {
            t.Join();
        }
    }
}

/*
Thread-2 value: Thread-specific value for Thread-2
Thread-0 value: Thread-specific value for Thread-0
Thread-1 value: Thread-specific value for Thread-1
 */
