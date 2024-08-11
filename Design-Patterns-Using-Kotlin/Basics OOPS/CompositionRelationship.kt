class Tyre(val type: String)

class Car(private val model: String) {
    private val tyres: MutableList<Tyre> = ArrayList()

    init {
        for (i in 0..3) {
            tyres.add(Tyre("MRF"))
        }
    }

    fun display() {
        println("Car: " + model + ", Tyre: " + tyres[0].type)
    }
}

fun main() {
    val car = Car("BMW")
    car.display()
}

/*
Car: BMW, Tyre: MRF
*/