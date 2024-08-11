// Define AbstractWorker
class AbstractWorker {
    dailyRoutine() {
        this.wakeUp();
        this.eatBreakfast();
        this.goToWork();
        this.work();
        this.comeBackHome();
        this.eatDinner();
        this.sleep();
    }

    wakeUp() {
        console.log("Wake Up");
    }

    eatBreakfast() {
        console.log("Eat Breakfast");
    }

    goToWork() {
        console.log("Go to work");
    }

    work() {
        throw new Error("work method must be implemented");
    }

    comeBackHome() {
        console.log("Come back Home");
    }

    eatDinner() {
        console.log("Eat dinner");
    }

    sleep() {
        console.log("Sleep");
    }
}

// Define Doctor extending AbstractWorker
class Doctor extends AbstractWorker {
    work() {
        console.log("...Treat Patients...");
    }
}

// Define FireFighter extending AbstractWorker
class FireFighter extends AbstractWorker {
    work() {
        console.log("...Fight Fire...");
    }
}

// Define SuperHero extending AbstractWorker
class SuperHero extends AbstractWorker {
    work() {
        console.log("...Save the world!...");
    }
}

// Client code
const doctor = new Doctor();
doctor.dailyRoutine();
console.log();

const fireFighter = new FireFighter();
fireFighter.dailyRoutine();
console.log();

const superHero = new SuperHero();
superHero.dailyRoutine();

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