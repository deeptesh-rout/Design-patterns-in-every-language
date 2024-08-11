import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class Barrier(private var count: Int) {
    private val barrierLock: Lock = ReentrantLock()
    private val barrierCondition: Condition = barrierLock.newCondition()

    @Throws(InterruptedException::class)
    fun waitBarrier() {
        barrierLock.lock()
        try {
            count--
            if (count > 0) {
                barrierCondition.await()
            } else {
                barrierCondition.signalAll()
            }
        } finally {
            barrierLock.unlock()
        }
    }
}

class Worker(private val barrier: Barrier, private val id: Int) : Runnable {
    override fun run() {
        println("Worker $id started")
        // Simulating some work
        for (i in 0..2) {
            println("Worker $id working...")
            // Simulating some computation
        }
        println("Worker $id finished")

        try {
            barrier.waitBarrier()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}

// Client code.
fun main() {
    val numWorkers = 3
    val barrier = Barrier(numWorkers)

    val threads = arrayOfNulls<Thread>(numWorkers)
    for (i in 0 until numWorkers) {
        val worker = Worker(barrier, i)
        threads[i] = Thread(worker)
        threads[i]!!.start()
    }

    try {
        for (t in threads) {
            t!!.join()
        }
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    println("All workers finished. Proceeding to the next step.")
}

/*
Worker 0 started
Worker 0 working...
Worker 0 working...
Worker 0 working...
Worker 0 finished
Worker 1 started
Worker 1 working...
Worker 1 working...
Worker 1 working...
Worker 1 finished
Worker 2 started
Worker 2 working...
Worker 2 working...
Worker 2 working...
Worker 2 finished
All workers finished. Proceeding to the next step.
 */
