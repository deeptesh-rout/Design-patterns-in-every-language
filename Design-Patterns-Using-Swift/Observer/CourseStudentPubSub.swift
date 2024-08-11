import Foundation

class Student: Hashable {
    var name: String

    init(name: String) {
        self.name = name
    }

    func notify(subject: String, message: String) {
        print("\(name) received message on subject '\(subject)': \(message)")
    }

    static func == (lhs: Student, rhs: Student) -> Bool {
        return lhs.name == rhs.name
    }

    func hash(into hasher: inout Hasher) {
        hasher.combine(name)
    }
}

class Courses {
    private var courseStudents = [String: Set<Student>]()

    func subscribe(subject: String, student: Student) {
        courseStudents[subject, default: []].insert(student)
    }

    func unsubscribe(subject: String, student: Student) {
        courseStudents[subject]?.remove(student)
    }

    func publish(subject: String, message: String) {
        guard let subscribers = courseStudents[subject] else {
            print("No subscribers for subject '\(subject)'.")
            return
        }

        for student in subscribers {
            student.notify(subject: subject, message: message)
        }
    }
}

// Client code.
let courses = Courses()
let john = Student(name: "John")
let eric = Student(name: "Eric")
let jack = Student(name: "Jack")

courses.subscribe(subject: "English", student: john)
courses.subscribe(subject: "English", student: eric)
courses.subscribe(subject: "Maths", student: eric)
courses.subscribe(subject: "Science", student: jack)

courses.publish(subject: "English", message: "Tomorrow class at 11")
courses.publish(subject: "Maths", message: "Tomorrow class at 1")

// Unsubscribe Eric from English
courses.unsubscribe(subject: "English", student: eric)

courses.publish(subject: "English", message: "Tomorrow class at 3")

/*
Eric received message on subject 'English': Tomorrow class at 11
John received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'Maths': Tomorrow class at 1
John received message on subject 'English': Tomorrow class at 3
*/
