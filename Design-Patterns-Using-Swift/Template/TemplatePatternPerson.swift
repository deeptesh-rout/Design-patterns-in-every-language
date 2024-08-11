import Foundation

class AbstractWorker {
    final func dailyRoutine() {
        wakeUp()
        eatBreakfast()
        goToWork()
        work()
        comeBackHome()
        eatDinner()
        sleep()
    }

    func wakeUp() {
        print("Wake Up")
    }

    func eatBreakfast() {
        print("Eat Breakfast")
    }

    func goToWork() {
        print("Go to work")
    }

    func work() {
        fatalError("Abstract method. Subclasses must implement work.")
    }

    func comeBackHome() {
        print("Come back Home")
    }

    func eatDinner() {
        print("Eat dinner")
    }

    func sleep() {
        print("Sleep")
    }
}

class Doctor: AbstractWorker {
    override func work() {
        print("...Treat Patients...")
    }
}

class FireFighter: AbstractWorker {
    override func work() {
        print("...Fight Fire...")
    }
}

class SuperHero: AbstractWorker {
    override func work() {
        print("...Save the world!...")
    }
}

// Client code.
let doctor = Doctor()
doctor.dailyRoutine()
print()

let fireFighter = FireFighter()
fireFighter.dailyRoutine()
print()

let superHero = SuperHero()
superHero.dailyRoutine()

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
