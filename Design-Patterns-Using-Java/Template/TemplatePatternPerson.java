abstract class AbstractWorker {
    final void dailyRoutine() {
        wakeUp();
        eatBreakfast();
        goToWork();
        work();
        comeBackHome();
        eatDinner();
        sleep();
    }

    void wakeUp() {
        System.out.println("Wake Up");
    }

    void eatBreakfast() {
        System.out.println("Eat Breakfast");
    }

    void goToWork() {
        System.out.println("Go to work");
    }

    abstract void work();

    void comeBackHome() {
        System.out.println("Come back Home");
    }

    void eatDinner() {
        System.out.println("Eat dinner");
    }

    void sleep() {
        System.out.println("Sleep");
    }
}

class Doctor extends AbstractWorker {
    @Override
    void work() {
        System.out.println("...Treat Patients...");
    }
}

class FireFighter extends AbstractWorker {
    @Override
    void work() {
        System.out.println("...Fight Fire...");
    }
}

class SuperHero extends AbstractWorker {
    @Override
    void work() {
        System.out.println("...Save the world!...");
    }
}

public class TemplatePatternPerson {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        doctor.dailyRoutine();
        System.out.println();

        FireFighter fireFighter = new FireFighter();
        fireFighter.dailyRoutine();
        System.out.println();

        SuperHero superHero = new SuperHero();
        superHero.dailyRoutine();
    }
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