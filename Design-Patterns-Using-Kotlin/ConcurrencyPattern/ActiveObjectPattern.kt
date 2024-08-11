import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.Volatile

class MethodRequest(private val method: Runnable) {
    fun execute() {
        method.run()
    }
}

// ActiveObject encapsulates its own thread of control and executes methods asynchronously
class ActiveObject : Thread() {
    private val queue: BlockingQueue<MethodRequest> = LinkedBlockingQueue()

    @Volatile
    private var isRunning: Boolean

    init {
        this.isRunning = true
    }

    override fun run() {
        while (isRunning || !queue.isEmpty()) {
            try {
                val methodRequest = queue.take()
                methodRequest.execute()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    fun scheduleMethod(method: Runnable) {
        val methodRequest = MethodRequest(method)
        queue.add(methodRequest)
    }

    fun stopThread() {
        isRunning = false
        interrupt()
    }
}

// Proxy acts as a wrapper around the ActiveObject and forwards method calls to it
class Proxy(private val activeObject: ActiveObject) {
    fun invokeMethod(method: Runnable) {
        activeObject.scheduleMethod(method)
    }
}

// Client code.
fun main() {
    // Create an instance of ActiveObject and Proxy
    val activeObject = ActiveObject()
    val proxy = Proxy(activeObject)

    // Start the ActiveObject thread
    activeObject.start()

    // Invoke methods on the Proxy
    proxy.invokeMethod { println("Hello") }
    proxy.invokeMethod { println("World") }

    // Stop the ActiveObject thread
    activeObject.stopThread()
}

