public class ThreadLocalValue {
    // ThreadLocal variable
    private static final ThreadLocal<String> tlsVar = new ThreadLocal<>();

    // Function to set thread-local value
    private static void setTLSValue(String value) {
        tlsVar.set(value);
    }

    // Function to get thread-local value
    private static String getTLSValue() {
        return tlsVar.get();
    }

    // Worker thread function
    private static void workerThread() {
        // Set thread-specific value
        setTLSValue("Thread-specific value for " + Thread.currentThread().getName());

        // Simulate some work
        try {
            Thread.sleep(1000); // Simulate work with a sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print thread-specific value
        System.out.println(Thread.currentThread().getName() + " value: " + getTLSValue());
    }

    public static void main(String[] args) {
        // Create and start multiple worker threads
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(ThreadLocalValue::workerThread);
            threads[i].start();
        }

        // Wait for all threads to complete
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
Thread-2 value: Thread-specific value for Thread-2
Thread-1 value: Thread-specific value for Thread-1
Thread-0 value: Thread-specific value for Thread-0
 */