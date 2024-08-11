using System;
using System.Collections.Generic;

class Student
{
    private string name;

    public Student(string name)
    {
        this.name = name;
    }

    public override string ToString()
    {
        return "Student: " + name;
    }
}

class SchoolClass
{
    private string className;
    private List<Student> students;

    public SchoolClass(string className)
    {
        this.className = className;
        this.students = new List<Student>();
    }

    public void AddStudent(Student student)
    {
        students.Add(student);
    }

    public void Display()
    {
        foreach (Student student in students)
        {
            Console.WriteLine(student);
        }
    }
}

public class AssociationRelationship
{
    public static void Main(string[] args)
    {
        SchoolClass schoolClass = new SchoolClass("SS1");
        Student student1 = new Student("John Smith");
        Student student2 = new Student("Jane Smith");

        schoolClass.AddStudent(student1);
        schoolClass.AddStudent(student2);

        schoolClass.Display();
    }
}
