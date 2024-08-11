#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

class Barrier {
private:
    int count;
    std::mutex barrierMutex;
    std::condition_variable barrierCondition;

public:
    Barrier(int count) : count(count) {}

    void waitBarrier() {
        std::unique_lock<std::mutex> lock(barrierMutex);
        count--;

        if (count > 0) {
            barrierCondition.wait(lock);
        } else {
            barrierCondition.notify_all();
        }
    }
};

class Worker {
private:
    Barrier& barrier;
    int id;

public:
    Worker(Barrier& barrier, int id) : barrier(barrier), id(id) {}

    void operator()() {
        std::cout << "Worker " << id << " started" << std::endl;
        // Simulating some work
        for (int i = 0; i < 3; i++) {
            std::cout << "Worker " << id << " working..." << std::endl;
            // Simulating some computation
            std::this_thread::sleep_for(std::chrono::seconds(1));
        }
        std::cout << "Worker " << id << " finished" << std::endl;

        barrier.waitBarrier();
    }
};

// Client code
int main() {
    int numWorkers = 3;
    Barrier barrier(numWorkers);

    std::thread threads[numWorkers];

    for (int i = 0; i < numWorkers; i++) {
        Worker worker(barrier, i);
        threads[i] = std::thread(worker);
    }

    for (auto& t : threads) {
        t.join();
    }

    std::cout << "All workers finished. Proceeding to the next step." << std::endl;

    return 0;
}

/*
Worker 2 started
Worker 2 working...
Worker 0 started
Worker 0 working...
Worker 1 started
Worker 1 working...
Worker 2 working...
Worker 0 working...
Worker 1 working...
Worker 2 working...
Worker 0 working...
Worker 1 working...
Worker 2 finished
Worker 0 finished
Worker 1 finished
All workers finished. Proceeding to the next step.
*/
