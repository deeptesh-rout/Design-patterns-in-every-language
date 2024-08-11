class Student {
    private var name: String

    init(name: String) {
        self.name = name
    }

    var description: String {
        return "Student: \(name)"
    }
}

class SchoolClass {
    private var className: String
    private var students: [Student]

    init(className: String) {
        self.className = className
        self.students = []
    }

    func addStudent(_ student: Student) {
        students.append(student)
    }

    func display() {
        for student in students {
            print(student.description)
        }
    }
}

let schoolClass = SchoolClass(className: "SS1")
let student1 = Student(name: "John Smith")
let student2 = Student(name: "Jane Smith")

schoolClass.addStudent(student1)
schoolClass.addStudent(student2)

schoolClass.display()
