#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>
#include <queue>
#include <functional>

// MethodRequest encapsulates a method call along with its arguments
class MethodRequest {
private:
    std::function<void()> method;

public:
    MethodRequest(std::function<void()> method) : method(method) {}

    void execute() {
        method();
    }
};

// ActiveObject encapsulates its own thread of control and executes methods asynchronously
class ActiveObject {
private:
    std::queue<MethodRequest> queue;
    std::mutex mutex;
    std::condition_variable condition;
    volatile bool isRunning;

public:
    ActiveObject() : isRunning(true) {}

    void run() {
        while (isRunning || !queue.empty()) {
            std::unique_lock<std::mutex> lock(mutex);
            condition.wait(lock, [this] { return !queue.empty() || !isRunning; });

            if (!queue.empty()) {
                MethodRequest methodRequest = std::move(queue.front());
                queue.pop();
                lock.unlock();

                methodRequest.execute();
            }
        }
    }

    void scheduleMethod(std::function<void()> method) {
        std::unique_lock<std::mutex> lock(mutex);
        queue.emplace(method);
        condition.notify_one();
    }

    void stopThread() {
        isRunning = false;
        condition.notify_one();
    }
};

// Proxy acts as a wrapper around the ActiveObject and forwards method calls to it
class Proxy {
private:
    ActiveObject& activeObject;

public:
    Proxy(ActiveObject& activeObject) : activeObject(activeObject) {}

    void invokeMethod(std::function<void()> method) {
        activeObject.scheduleMethod(method);
    }
};

// Client code
int main() {
    // Create an instance of ActiveObject and Proxy
    ActiveObject activeObject;
    Proxy proxy(activeObject);

    // Start the ActiveObject thread
    std::thread activeObjectThread(&ActiveObject::run, &activeObject);

    // Invoke methods on the Proxy
    proxy.invokeMethod([]() { std::cout << "Hello" << std::endl; });
    proxy.invokeMethod([]() { std::cout << "World" << std::endl; });

    // Stop the ActiveObject thread
    activeObject.stopThread();
    activeObjectThread.join();

    return 0;
}

/*
Hello
World
*/