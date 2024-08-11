import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// MethodRequest encapsulates a method call along with its arguments
class MethodRequest {
    private Runnable method;

    public MethodRequest(Runnable method) {
        this.method = method;
    }

    public void execute() {
        method.run();
    }
}

// ActiveObject encapsulates its own thread of control and executes methods asynchronously
class ActiveObject extends Thread {
    private BlockingQueue<MethodRequest> queue;
    private volatile boolean isRunning;

    public ActiveObject() {
        this.queue = new LinkedBlockingQueue<>();
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning || !queue.isEmpty()) {
            try {
                MethodRequest methodRequest = queue.take();
                methodRequest.execute();
            } catch (InterruptedException e) {
            }
        }
    }

    public void scheduleMethod(Runnable method) {
        MethodRequest methodRequest = new MethodRequest(method);
        queue.add(methodRequest);
    }

    public void stopThread() {
        isRunning = false;
        interrupt();
    }
}

// Proxy acts as a wrapper around the ActiveObject and forwards method calls to it
class Proxy {
    private ActiveObject activeObject;

    public Proxy(ActiveObject activeObject) {
        this.activeObject = activeObject;
    }

    public void invokeMethod(Runnable method) {
        activeObject.scheduleMethod(method);
    }
}

// Example usage
public class ActiveObjectPattern {
    public static void main(String[] args) {
        // Create an instance of ActiveObject and Proxy
        ActiveObject activeObject = new ActiveObject();
        Proxy proxy = new Proxy(activeObject);

        // Start the ActiveObject thread
        activeObject.start();

        // Invoke methods on the Proxy
        proxy.invokeMethod(() -> System.out.println("Hello"));
        proxy.invokeMethod(() -> System.out.println("World"));

        // Stop the ActiveObject thread
        activeObject.stopThread();
    }
}

/*
Hello
World
*/