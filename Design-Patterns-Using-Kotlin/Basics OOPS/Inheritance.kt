open class Person(protected var name: String, protected var age: Int, protected var gender: String) {
    override fun toString(): String {
        return String.format("Person: %s is a %s and %s years old.", name, gender, age)
    }
}

class Citizen(name: String, age: Int, gender: String, var voterId: Int) : Person(name, age, gender) {
    override fun toString(): String {
        return String.format("Citizen: %s is a %s and %s years old with voter id %s.", name, gender, age, voterId)
    }
}

fun main() {
    val p = Person("John", 32, "Male")
    println(p)

    val c = Citizen("Smith", 31, "Male", 1234)
    println(c)
}

/*
Person: John is a Male and 32 years old.
Citizen: Smith is a Male and 31 years old with voter id 1234.
*/