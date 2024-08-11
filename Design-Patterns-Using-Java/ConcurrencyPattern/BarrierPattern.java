import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Barrier {
    private int count;
    private final Lock barrierLock = new ReentrantLock();
    private final Condition barrierCondition = barrierLock.newCondition();

    public Barrier(int count) {
        this.count = count;
    }

    public void waitBarrier() throws InterruptedException {
        barrierLock.lock();
        try {
            count--;
            if (count > 0) {
                barrierCondition.await();
            } else {
                barrierCondition.signalAll();
            }
        } finally {
            barrierLock.unlock();
        }
    }
}

class Worker implements Runnable {
    private final Barrier barrier;
    private final int id;

    public Worker(Barrier barrier, int id) {
        this.barrier = barrier;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Worker " + id + " started");
        // Simulating some work
        for (int i = 0; i < 3; i++) {
            System.out.println("Worker " + id + " working...");
            // Simulating some computation
            try {
                Thread.sleep(1000); // Add sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Worker " + id + " finished");

        try {
            barrier.waitBarrier();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarrierPattern {
    public static void main(String[] args) {
        int numWorkers = 3;
        Barrier barrier = new Barrier(numWorkers);

        Thread[] threads = new Thread[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            Worker worker = new Worker(barrier, i);
            threads[i] = new Thread(worker);
            threads[i].start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All workers finished. Proceeding to the next step.");
    }
}

/*
Worker 0 started
Worker 0 working...
Worker 2 started
Worker 1 started
Worker 1 working...
Worker 2 working...
Worker 0 working...
Worker 1 working...
Worker 2 working...
Worker 0 working...
Worker 1 working...
Worker 2 working...
Worker 1 finished
Worker 0 finished
Worker 2 finished
All workers finished. Proceeding to the next step.
*/