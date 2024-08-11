import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}

class SchoolClass {
    private String className;
    private List<Student> students;

    public SchoolClass(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void display() {
        System.out.println("Students in class: " + className);        
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class AssociationRelationship {
    public static void main(String[] args) {
        SchoolClass schoolClass = new SchoolClass("S1");
        Student student1 = new Student("John Smith");
        Student student2 = new Student("Jane Smith");

        schoolClass.addStudent(student1);
        schoolClass.addStudent(student2);

        schoolClass.display();
    }
}

/*
Students in class: S1
Student: John Smith
Student: Jane Smith
*/