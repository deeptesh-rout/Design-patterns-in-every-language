using System;
using System.Threading;

class Barrier
{
    private int count;
    private readonly object barrierLock = new object();

    public Barrier(int count)
    {
        this.count = count;
    }

    public void WaitBarrier()
    {
        lock (barrierLock)
        {
            count--;
            if (count > 0)
            {
                Monitor.Wait(barrierLock);
            }
            else
            {
                Monitor.PulseAll(barrierLock);
            }
        }
    }
}

class Worker
{
    private readonly Barrier barrier;
    private readonly int id;

    public Worker(Barrier barrier, int id)
    {
        this.barrier = barrier;
        this.id = id;
    }

    public void Run()
    {
        Console.WriteLine("Worker " + id + " started");
        // Simulating some work
        for (int i = 0; i < 3; i++)
        {
            Console.WriteLine("Worker " + id + " working...");
            // Simulating some computation
            Thread.Sleep(1000); // Add sleep for 1 second
        }
        Console.WriteLine("Worker " + id + " finished");

        try
        {
            barrier.WaitBarrier();
        }
        catch (ThreadInterruptedException e)
        {
            Console.WriteLine(e.StackTrace);
        }
    }
}

// Client code

class BarrierPattern
{
    public static void Main(string[] args)
    {
        int numWorkers = 3;
        Barrier barrier = new Barrier(numWorkers);

        Thread[] threads = new Thread[numWorkers];
        for (int i = 0; i < numWorkers; i++)
        {
            Worker worker = new Worker(barrier, i);
            threads[i] = new Thread(worker.Run);
            threads[i].Start();
        }

        try
        {
            foreach (Thread t in threads)
            {
                t.Join();
            }
        }
        catch (ThreadInterruptedException e)
        {
            Console.WriteLine(e.StackTrace);
        }

        Console.WriteLine("All workers finished. Proceeding to the next step.");
    }
}

/*
Worker 1 started
Worker 2 started
Worker 2 working...
Worker 1 working...
Worker 0 started
Worker 0 working...
Worker 0 working...
Worker 2 working...
Worker 1 working...
Worker 0 working...
Worker 2 working...
Worker 1 working...
Worker 0 finished
Worker 1 finished
Worker 2 finished
All workers finished. Proceeding to the next step.
*/