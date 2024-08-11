using System;
using System.Collections.Generic;
using System.Threading;

// MethodRequest encapsulates a method call along with its arguments
class MethodRequest
{
    private Action method;

    public MethodRequest(Action method)
    {
        this.method = method;
    }

    public void Execute()
    {
        method.Invoke();
    }
}

// ActiveObject encapsulates its own thread of control and executes methods asynchronously
class ActiveObject
{
    private Queue<MethodRequest> queue;
    private Thread thread;
    private volatile bool isRunning;

    public ActiveObject()
    {
        this.queue = new Queue<MethodRequest>();
        this.isRunning = true;
        this.thread = new Thread(Run);
    }

    public void Start()
    {
        thread.Start();
    }

    public void Run()
    {
        while (isRunning || queue.Count > 0)
        {
            try
            {
                MethodRequest methodRequest;
                lock (queue)
                {
                    methodRequest = queue.Dequeue();
                }
                methodRequest.Execute();
            }
            catch (ThreadInterruptedException e)
            {
                Console.WriteLine(e.StackTrace);
            }
        }
    }

    public void ScheduleMethod(Action method)
    {
        MethodRequest methodRequest = new MethodRequest(method);
        lock (queue)
        {
            queue.Enqueue(methodRequest);
        }
    }

    public void StopThread()
    {
        isRunning = false;
        thread.Interrupt();
    }
}

// Proxy acts as a wrapper around the ActiveObject and forwards method calls to it
class Proxy
{
    private ActiveObject activeObject;

    public Proxy(ActiveObject activeObject)
    {
        this.activeObject = activeObject;
    }

    public void InvokeMethod(Action method)
    {
        activeObject.ScheduleMethod(method);
    }
}

// Client code
class ActiveObjectPattern
{
    static void Main(string[] args)
    {
        // Create an instance of ActiveObject and Proxy
        ActiveObject activeObject = new ActiveObject();
        Proxy proxy = new Proxy(activeObject);

        // Start the ActiveObject thread
        activeObject.Start();

        // Invoke methods on the Proxy
        proxy.InvokeMethod(() => Console.WriteLine("Hello"));
        proxy.InvokeMethod(() => Console.WriteLine("World"));

        // Stop the ActiveObject thread
        activeObject.StopThread();
    }
}
