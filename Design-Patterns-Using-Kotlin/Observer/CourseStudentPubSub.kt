class Courses {
    private val courseStudents: MutableMap<String, MutableSet<Student>> = mutableMapOf()

    fun subscribe(subject: String, student: Student) {
        courseStudents.computeIfAbsent(subject) { mutableSetOf() }.add(student)
    }

    fun unsubscribe(subject: String, student: Student) {
        courseStudents[subject]?.remove(student)
    }

    fun publish(subject: String, message: String) {
        val subscribers = courseStudents[subject]
        if (subscribers.isNullOrEmpty()) {
            println("No subscribers for subject '$subject'.")
            return
        }
        for (student in subscribers) {
            student.notify(subject, message)
        }
    }
}

class Student(val name: String) {
    fun notify(subject: String, message: String) {
        println("$name received message on subject '$subject': $message")
    }
}

// Client Code
fun main() {
    val courses = Courses()
    val john = Student("John")
    val eric = Student("Eric")
    val jack = Student("Jack")

    courses.subscribe("English", john)
    courses.subscribe("English", eric)
    courses.subscribe("Maths", eric)
    courses.subscribe("Science", jack)

    courses.publish("English", "Tomorrow class at 11")
    courses.publish("Maths", "Tomorrow class at 1")

    // Unsubscribe Eric from English
    courses.unsubscribe("English", eric)

    courses.publish("English", "Tomorrow class at 3")
}


/*
Eric received message on subject 'English': Tomorrow class at 11
John received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'Maths': Tomorrow class at 1
John received message on subject 'English': Tomorrow class at 3
*/

