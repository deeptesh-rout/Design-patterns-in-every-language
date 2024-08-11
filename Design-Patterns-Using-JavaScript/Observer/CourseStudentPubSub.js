class Courses {
    constructor() {
        this.courseStudents = new Map();
    }

    subscribe(subject, student) {
        if (!this.courseStudents.has(subject)) {
            this.courseStudents.set(subject, new Set());
        }
        this.courseStudents.get(subject).add(student);
    }

    unsubscribe(subject, student) {
        const students = this.courseStudents.get(subject);
        if (students) {
            students.delete(student);
        }
    }

    publish(subject, message) {
        if (!this.courseStudents.has(subject)) {
            console.log(`No subscribers for subject '${subject}'.`);
            return;
        }

        for (const student of this.courseStudents.get(subject)) {
            student.notify(subject, message);
        }
    }
}

class Student {
    constructor(name) {
        this.name = name;
    }

    notify(subject, message) {
        console.log(`${this.constructor.name} received message on subject '${subject}': ${message}`);
    }
}

// Client code
const courses = new Courses();
const john = new Student("John");
const eric = new Student("Eric");
const jack = new Student("Jack");

courses.subscribe("English", john);
courses.subscribe("English", eric);
courses.subscribe("Maths", eric);
courses.subscribe("Science", jack);

courses.publish("English", "Tomorrow class at 11");
courses.publish("Maths", "Tomorrow class at 1");

// Unsubscribe Eric from English
courses.unsubscribe("English", eric);

courses.publish("English", "Updated schedule for English");

/*
Student received message on subject 'English': Tomorrow class at 11
Student received message on subject 'English': Tomorrow class at 11
Student received message on subject 'Maths': Tomorrow class at 1
Student received message on subject 'English': Updated schedule for English
*/