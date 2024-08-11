import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Courses {
    private Map<String, Set<Observer>> courseStudents = new HashMap<>();

    public void subscribe(String subject, Observer student) {
        courseStudents.computeIfAbsent(subject, k -> new HashSet<>()).add(student);
    }

    public void unsubscribe(String subject, Observer student) {
        courseStudents.getOrDefault(subject, new HashSet<>()).remove(student);
    }

    public void publish(String subject, String message) {
        if (!courseStudents.containsKey(subject)) {
            System.out.println("No subscribers for subject '" + subject + "'.");
            return;
        }

        for (Observer student : courseStudents.get(subject)) {
            student.notify(subject, message);
        }
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void notify(String subject, String message) {
        System.out.println(name + " received message on subject '" + subject + "': " + message);
    }
}

public class CourseStudentPubSub {
    public static void main(String[] args) {
        Courses courses = new Courses();
        Student john = new Student("John");
        Student eric = new Student("Eric");
        Student jack = new Student("Jack");

        courses.subscribe("English", john);
        courses.subscribe("English", eric);
        courses.subscribe("Maths", eric);
        courses.subscribe("Science", jack);

        courses.publish("English", "Tomorrow class at 11");
        courses.publish("Maths", "Tomorrow class at 1");

        // Unsubscribe Eric from English
        courses.unsubscribe("English", eric);

        courses.publish("English", "Updated schedule for English");
    }
}

/*
Eric received message on subject 'English': Tomorrow class at 11
John received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'Maths': Tomorrow class at 1
John received message on subject 'English': Updated schedule for English
*/