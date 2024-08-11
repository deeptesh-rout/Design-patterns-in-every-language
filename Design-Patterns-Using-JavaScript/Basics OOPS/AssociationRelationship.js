class Student {
    constructor(name) {
        this.name = name;
    }

    toString() {
        return `Student: ${this.name}`;
    }
}

class SchoolClass {
    constructor(className) {
        this.className = className;
        this.students = [];
    }

    addStudent(student) {
        this.students.push(student);
    }

    display() {
        for (const student of this.students) {
            console.log(student.toString());
        }
    }
}

// Client code
const schoolClass = new SchoolClass("SS1");
const student1 = new Student("John Smith");
const student2 = new Student("Jane Smith");

schoolClass.addStudent(student1);
schoolClass.addStudent(student2);

schoolClass.display();

/*
Student: John Smith
Student: Jane Smith
*/