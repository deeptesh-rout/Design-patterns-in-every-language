open class Person(protected var name: String) {
    protected var oath: String? = null

    override fun toString(): String {
        return "Person: $name : $oath"
    }

    open fun setOath() {
        this.oath = "Always tell truth"
    }
}

class Citizen(name: String, private val id: Int) : Person(name) {
    override fun setOath() {
        this.oath = "Country comes first"
    }
}

fun main() {
    val p = Person("John")
    p.setOath()
    println(p.toString())

    val c = Citizen("Smith", 31)
    c.setOath()
    println(c.toString())
}

/*
Person: John : Always tell truth
Person: Smith : Country comes first
*/