using System;
using System.Collections.Generic;

// Observer interface
interface IObserver
{
    void Notify(string subject, string message);
}

// Subject class
class Courses
{
    private Dictionary<string, HashSet<IObserver>> courseStudents = new Dictionary<string, HashSet<IObserver>>();

    public void Subscribe(string subject, IObserver student)
    {
        if (!courseStudents.ContainsKey(subject))
        {
            courseStudents[subject] = new HashSet<IObserver>();
        }

        courseStudents[subject].Add(student);
    }

    public void Unsubscribe(string subject, IObserver student)
    {
        if (courseStudents.ContainsKey(subject))
        {
            courseStudents[subject].Remove(student);
        }
    }

    public void Publish(string subject, string message)
    {
        if (!courseStudents.ContainsKey(subject))
        {
            Console.WriteLine("No subscribers for subject '" + subject + "'.");
            return;
        }

        foreach (IObserver student in courseStudents[subject])
        {
            student.Notify(subject, message);
        }
    }
}

// Concrete Observer class
class Student : IObserver
{
    private string name;

    public Student(string name)
    {
        this.name = name;
    }

    public void Notify(string subject, string message)
    {
        Console.WriteLine(name + " received message on subject '" + subject + "': " + message);
    }
}

// Client code
class CourseStudentPubSub
{
    static void Main(string[] args)
    {
        Courses courses = new Courses();
        Student john = new Student("John");
        Student eric = new Student("Eric");
        Student jack = new Student("Jack");

        courses.Subscribe("English", john);
        courses.Subscribe("English", eric);
        courses.Subscribe("Maths", eric);
        courses.Subscribe("Science", jack);

        courses.Publish("English", "Tomorrow class at 11");
        courses.Publish("Maths", "Tomorrow class at 1");

        // Unsubscribe Eric from English
        courses.Unsubscribe("English", eric);

        courses.Publish("English", "Updated schedule for English");
    }
}

/*
John received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'Maths': Tomorrow class at 1
John received message on subject 'English': Updated schedule for English
*/