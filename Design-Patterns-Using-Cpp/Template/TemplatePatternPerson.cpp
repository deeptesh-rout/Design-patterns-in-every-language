#include <iostream>

// AbstractWorker class
class AbstractWorker {
public:
    void dailyRoutine() {
        wakeUp();
        eatBreakfast();
        goToWork();
        work();
        comeBackHome();
        eatDinner();
        sleep();
    }

    virtual ~AbstractWorker() {}

private:
    void wakeUp() {
        std::cout << "Wake Up" << std::endl;
    }

    void eatBreakfast() {
        std::cout << "Eat Breakfast" << std::endl;
    }

    void goToWork() {
        std::cout << "Go to work" << std::endl;
    }

    virtual void work() = 0;

    void comeBackHome() {
        std::cout << "Come back Home" << std::endl;
    }

    void eatDinner() {
        std::cout << "Eat dinner" << std::endl;
    }

    void sleep() {
        std::cout << "Sleep" << std::endl;
    }
};

// Doctor class
class Doctor : public AbstractWorker {
private:
    void work() override {
        std::cout << "...Treat Patients..." << std::endl;
    }
};

// FireFighter class
class FireFighter : public AbstractWorker {
private:
    void work() override {
        std::cout << "...Fight Fire..." << std::endl;
    }
};

// SuperHero class
class SuperHero : public AbstractWorker {
private:
    void work() override {
        std::cout << "...Save the world!..." << std::endl;
    }
};

// Client code
int main() {
    AbstractWorker* doctor = new Doctor();
    doctor->dailyRoutine();
    std::cout << std::endl;

    AbstractWorker* fireFighter = new FireFighter();
    fireFighter->dailyRoutine();
    std::cout << std::endl;

    AbstractWorker* superHero = new SuperHero();
    superHero->dailyRoutine();

    delete doctor;       // Freeing allocated memory
    delete fireFighter;  // Freeing allocated memory
    delete superHero;    // Freeing allocated memory

    return 0;
}

/*
Wake Up
Eat Breakfast
Go to work
...Treat Patients...
Come back Home
Eat dinner
Sleep

Wake Up
Eat Breakfast
Go to work
...Fight Fire...
Come back Home
Eat dinner
Sleep

Wake Up
Eat Breakfast
Go to work
...Save the world!...
Come back Home
Eat dinner
Sleep
*/