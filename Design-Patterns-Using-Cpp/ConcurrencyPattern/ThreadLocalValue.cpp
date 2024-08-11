#include <iostream>
#include <thread>
#include <string>

class ThreadLocalValue {
private:
    // ThreadLocal variable
    static thread_local std::string tlsVar;

    // Function to set thread-local value
    static void setTLSValue(const std::string& value) {
        tlsVar = value;
    }

    // Function to get thread-local value
    static const std::string& getTLSValue() {
        return tlsVar;
    }

    // Worker thread function
    static void workerThread(const int id) {
        const std::string value = "Thread-specific value: " + std::to_string(id);
        setTLSValue(value);
        std::cout << getTLSValue() << std::endl;
    }

public:
    static void main() {
        // Create and start multiple worker threads
        std::thread threads[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = std::thread([i] { workerThread(i); });
        }

        // Wait for all threads to complete
        for (auto& t : threads) {
            t.join();
        }
    }
};

// Initialize thread-local variable
thread_local std::string ThreadLocalValue::tlsVar;

// Client code
int main() {
    ThreadLocalValue::main();
    return 0;
}

/*
Thread-specific value: 0
Thread-specific value: 1
Thread-specific value: 2
*/