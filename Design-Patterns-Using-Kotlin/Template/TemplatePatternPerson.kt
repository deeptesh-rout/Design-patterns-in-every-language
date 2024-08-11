abstract class AbstractWorker {
    fun dailyRoutine() {
        wakeUp()
        eatBreakfast()
        goToWork()
        work()
        comeBackHome()
        eatDinner()
        sleep()
    }

    fun wakeUp() {
        println("Wake Up")
    }

    fun eatBreakfast() {
        println("Eat Breakfast")
    }

    fun goToWork() {
        println("Go to work")
    }

    abstract fun work()

    fun comeBackHome() {
        println("Come back Home")
    }

    fun eatDinner() {
        println("Eat dinner")
    }

    fun sleep() {
        println("Sleep")
    }
}

class Doctor : AbstractWorker() {
    override fun work() {
        println("...Treat Patients...")
    }
}

class FireFighter : AbstractWorker() {
    override fun work() {
        println("...Fight Fire...")
    }
}

class SuperHero : AbstractWorker() {
    override fun work() {
        println("...Save the world!...")
    }
}


// Client code
fun main() {
    val doctor = Doctor()
    doctor.dailyRoutine()
    println()

    val fireFighter = FireFighter()
    fireFighter.dailyRoutine()
    println()

    val superHero = SuperHero()
    superHero.dailyRoutine()
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