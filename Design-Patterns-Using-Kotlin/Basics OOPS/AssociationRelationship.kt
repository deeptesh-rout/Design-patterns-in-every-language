open class Student( val name: String) {
    override fun toString(): String {
        return "Student: $name"
    }
}

class SchoolClass(private val className: String) {
    private val students: MutableList<Student> = ArrayList()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun display() {
        for (student in students) {
            println(student)
        }
    }
}

fun main() {
    val schoolClass = SchoolClass("SS1")
    val student1 = Student("John Smith")
    val student2 = Student("Jane Smith")

    schoolClass.addStudent(student1)
    schoolClass.addStudent(student2)

    schoolClass.display()
}

/*
Student: John Smith
Student: Jane Smith
*/